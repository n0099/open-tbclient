package com.baidu.searchbox.logsystem.basic;

import android.app.Service;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.baidu.searchbox.logsystem.basic.eventhandler.DefaultDeviceEventSceneHandler;
import com.baidu.searchbox.logsystem.basic.eventhandler.OOMDeviceEventSceneSceneHandler;
import com.baidu.searchbox.logsystem.basic.eventhandler.SOEventSceneSceneHandler;
import com.baidu.searchbox.logsystem.basic.eventhandler.SQLiteFullSceneHandler;
import com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.searchbox.logsystem.basic.util.SnapshotUtil;
import com.baidu.searchbox.logsystem.logsys.LogBaseObject;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.LogObject;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ForwardingDeviceEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.DeviceSnapshotType;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.searchbox.logsystem.util.Utility;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public class LogSystemProcessor {
    private static final int KEEP_ALIVE_TIME = 60000;
    protected static final String TAG = "LogSystemProcessor";
    private ForwardingDeviceEventSceneHandler mForwardingEventSceneHandler;
    private Handler mHandler;
    @NonNull
    private ThreadPoolExecutor mProcessExecutor;
    private List<BaseUploaderStrategy> mUploaderStrategies;

    public LogSystemProcessor() {
        this(null, null);
    }

    public LogSystemProcessor(@Nullable ForwardingDeviceEventSceneHandler forwardingDeviceEventSceneHandler) {
        this(forwardingDeviceEventSceneHandler, null);
    }

    public LogSystemProcessor(@Nullable ForwardingDeviceEventSceneHandler forwardingDeviceEventSceneHandler, @Nullable List<BaseUploaderStrategy> list) {
        if (forwardingDeviceEventSceneHandler == null) {
            this.mForwardingEventSceneHandler = new ForwardingDeviceEventSceneHandler();
        } else {
            this.mForwardingEventSceneHandler = forwardingDeviceEventSceneHandler;
        }
        this.mForwardingEventSceneHandler.addEventHandleCallback(new DefaultDeviceEventSceneHandler());
        this.mForwardingEventSceneHandler.addEventHandleCallback(new OOMDeviceEventSceneSceneHandler());
        this.mForwardingEventSceneHandler.addEventHandleCallback(new SOEventSceneSceneHandler());
        this.mForwardingEventSceneHandler.addEventHandleCallback(new SQLiteFullSceneHandler());
        this.mProcessExecutor = new ThreadPoolExecutor(1, 1, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        if (list == null) {
            list = new LinkedList<>();
            list.add(new LogSystemUploaderStrategy());
        }
        this.mUploaderStrategies = list;
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public void process(@NonNull final Service service, final int i, @NonNull LogBaseObject logBaseObject) {
        Runnable runnable = null;
        switch (logBaseObject.mLogType) {
            case NATIVE_CRASH:
            case JAVA_CRASH:
                if (logBaseObject instanceof LogObject) {
                    final LogObject logObject = (LogObject) logBaseObject;
                    if (TextUtils.isEmpty(logObject.getLogBasicData()) && logObject.getLogBasicDataFile() == null) {
                        if (LLog.sDebug) {
                            throw new RuntimeException("if the logType = " + logObject.mLogType.getTypeName() + ", mLogBasicData should not be empty and mLogBasicDataFile should not be null");
                        }
                        stopSelfIfNeed(service, i);
                        return;
                    } else if (TextUtils.isEmpty(logObject.getProcessName())) {
                        if (LLog.sDebug) {
                            throw new RuntimeException("if the logType = " + logObject.mLogType.getTypeName() + "mProcessName should not be null or its length = 0");
                        }
                        stopSelfIfNeed(service, i);
                        return;
                    } else {
                        runnable = new Runnable() { // from class: com.baidu.searchbox.logsystem.basic.LogSystemProcessor.1
                            @Override // java.lang.Runnable
                            public void run() {
                                List<LogFile> list;
                                File file;
                                File obtainFileDirWithProcessName = LogPipelineSingleton.obtainFileDirWithProcessName(logObject.getProcessName());
                                if (!obtainFileDirWithProcessName.exists()) {
                                    obtainFileDirWithProcessName.mkdirs();
                                }
                                Context applicationContext = service.getApplicationContext();
                                if (logObject.getLogBasicDataFile() != null) {
                                    Pair<String, Boolean> readFile = Utility.readFile(logObject.getLogBasicDataFile(), LokiService.Constant.MAX_LENGTH_OF_STRING_TO_DIRECT_TRANS_WITH_BINDER);
                                    if (readFile != null && readFile.first != null) {
                                        logObject.setLogBasicData((String) readFile.first);
                                        logObject.setLogBasicDataOverflow(((Boolean) readFile.second).booleanValue());
                                    } else {
                                        logObject.setLogBasicData("logsystem read file error");
                                        logObject.setLogBasicDataOverflow(false);
                                    }
                                } else {
                                    logObject.setLogBasicDataFile(new File(obtainFileDirWithProcessName, SnapshotConstant.ProcessConstants.PROCESS_LOG_BASIC_DATA));
                                    if (Utility.createNewEmptyFile(logObject.getLogBasicDataFile())) {
                                        FileUtils.saveToFile(logObject.getLogBasicData(), logObject.getLogBasicDataFile(), true);
                                    }
                                }
                                ArrayList obtainProcessLogFiles = logObject.getLogExtraPathNameKeeper() != null ? LogSystemProcessor.this.obtainProcessLogFiles(logObject.getLogExtraPathNameKeeper()) : null;
                                if (LLog.sDebug) {
                                    Log.d(LogSystemProcessor.TAG, "processFiles.size = " + (obtainProcessLogFiles != null ? Integer.valueOf(obtainProcessLogFiles.size()) : "null"));
                                }
                                Set<LogFile> generateDeviceUploadFile = LogSystemProcessor.this.generateDeviceUploadFile(applicationContext, new EventObject(logObject.mLogType, logObject.getLogBasicData()), obtainFileDirWithProcessName);
                                if (LLog.sDebug) {
                                    Log.d(LogSystemProcessor.TAG, "devicesLogFiles.size = " + (generateDeviceUploadFile != null ? Integer.valueOf(generateDeviceUploadFile.size()) : "null"));
                                }
                                if (logObject.mLogType == LogType.NATIVE_CRASH) {
                                    File processCrashpadDir = LogPipelineSingleton.getInstance().getProcessCrashpadDir(logObject.getCrashTAG());
                                    if (processCrashpadDir != null) {
                                        list = LogSystemProcessor.this.getCrashpadFile(processCrashpadDir);
                                        file = processCrashpadDir;
                                    } else {
                                        list = null;
                                        file = processCrashpadDir;
                                    }
                                } else {
                                    list = null;
                                    file = null;
                                }
                                if (LLog.sDebug) {
                                    Log.d(LogSystemProcessor.TAG, "crashFiles.size = " + (list != null ? Integer.valueOf(list.size()) : "null"));
                                }
                                for (int i2 = 0; i2 < LogSystemProcessor.this.mUploaderStrategies.size(); i2++) {
                                    BaseUploaderStrategy baseUploaderStrategy = (BaseUploaderStrategy) LogSystemProcessor.this.mUploaderStrategies.get(i2);
                                    if (LLog.sDebug) {
                                        Log.d(LogSystemProcessor.TAG, "uploaderStrategy = " + baseUploaderStrategy.getClass().getName());
                                    }
                                    try {
                                        baseUploaderStrategy.upload(applicationContext, logObject, obtainProcessLogFiles, generateDeviceUploadFile, list);
                                    } catch (Exception e) {
                                        if (LLog.sDebug) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                LogSystemProcessor.this.deleteLogFiles(logObject, obtainProcessLogFiles, generateDeviceUploadFile, file);
                                LogSystemProcessor.this.stopSelfIfNeed(service, i);
                            }
                        };
                        break;
                    }
                }
                break;
            case NONE:
                runnable = new Runnable() { // from class: com.baidu.searchbox.logsystem.basic.LogSystemProcessor.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= LogSystemProcessor.this.mUploaderStrategies.size()) {
                                LogSystemProcessor.this.stopSelfIfNeed(service, i);
                                return;
                            } else {
                                ((BaseUploaderStrategy) LogSystemProcessor.this.mUploaderStrategies.get(i3)).upload(service.getApplicationContext());
                                i2 = i3 + 1;
                            }
                        }
                    }
                };
                break;
        }
        if (runnable != null) {
            this.mProcessExecutor.submit(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteLogFiles(@NonNull LogObject logObject, @Nullable ArrayList<LogFile> arrayList, @Nullable Set<LogFile> set, @Nullable File file) {
        if (logObject.getLogBasicDataFile() != null) {
            logObject.getLogBasicDataFile().delete();
            if (LLog.sDebug) {
                Log.d(TAG, "logBasicDataFile = " + logObject.getLogBasicDataFile());
            }
        }
        if (logObject.getLogExtraPathNameKeeper() != null) {
            logObject.getLogExtraPathNameKeeper().delete();
            if (LLog.sDebug) {
                Log.d(TAG, "pathNameKeeper = " + logObject.getLogExtraPathNameKeeper());
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<LogFile> it = arrayList.iterator();
            while (it.hasNext()) {
                LogFile next = it.next();
                if (next != null && next.mCanDelete) {
                    next.mFile.delete();
                    if (LLog.sDebug) {
                        Log.d(TAG, "processLogFile = " + next.mFile.getAbsolutePath());
                    }
                }
            }
        }
        if (set != null && set.size() > 0) {
            for (LogFile logFile : set) {
                if (logFile != null && logFile.mCanDelete) {
                    logFile.mFile.delete();
                    if (LLog.sDebug) {
                        Log.d(TAG, "deviceLogFile = " + logFile.mFile.getAbsolutePath());
                    }
                }
            }
        }
        if (file != null && file.exists()) {
            FileUtils.deleteFile(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopSelfIfNeed(@NonNull final Service service, final int i) {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.searchbox.logsystem.basic.LogSystemProcessor.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                int i2 = 0;
                boolean z2 = true;
                while (true) {
                    if (i2 >= LogSystemProcessor.this.mUploaderStrategies.size()) {
                        z = z2;
                        break;
                    }
                    z = z2 && ((BaseUploaderStrategy) LogSystemProcessor.this.mUploaderStrategies.get(i2)).canStopService();
                    if (!z) {
                        break;
                    }
                    i2++;
                    z2 = z;
                }
                if (!z || LogSystemProcessor.this.mProcessExecutor.getQueue().size() != 0 || LogSystemProcessor.this.mProcessExecutor.getActiveCount() != 0) {
                    LogSystemProcessor.this.stopSelfIfNeed(service, i);
                } else {
                    service.stopSelf(i);
                }
            }
        }, 60000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public ArrayList<LogFile> obtainProcessLogFiles(@NonNull File file) {
        BufferedReader bufferedReader;
        IOException e;
        LogFile logFile;
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        ArrayList<LogFile> arrayList = new ArrayList<>(5);
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (!TextUtils.isEmpty(readLine)) {
                                if (LLog.sDebug) {
                                    Log.d(TAG, "pathNameKeep line = " + readLine);
                                }
                                String[] split = readLine.split("=");
                                if (split != null && split.length == 3 && split[0] != null && split[1] != null && split[2] != null) {
                                    File file2 = new File(split[0].trim());
                                    if (file2.exists() && file2.isFile()) {
                                        arrayList.add(new LogFile(file2, Boolean.valueOf(split[1].trim()).booleanValue(), Boolean.valueOf(split[2].trim()).booleanValue()));
                                        if (LLog.sDebug) {
                                            Log.d(TAG, "LogFile = " + logFile.toString());
                                        }
                                    }
                                }
                            }
                        } else {
                            Closeables.closeSafely(bufferedReader);
                            return arrayList;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        Closeables.closeSafely(bufferedReader);
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th = th;
                    Closeables.closeSafely(bufferedReader);
                    throw th;
                }
            }
        } catch (IOException e3) {
            bufferedReader = null;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            Closeables.closeSafely(bufferedReader);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<LogFile> getCrashpadFile(@NonNull File file) {
        File[] listFiles;
        if (file == null || !file.exists() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (File file2 : listFiles) {
            LogFile logFile = new LogFile(file2, true, true);
            if (LLog.sDebug) {
                Log.d(TAG, logFile.mFile.getAbsolutePath() + ", " + logFile.mCanDelete + ", " + logFile.mNecessary);
            }
            linkedList.add(logFile);
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<LogFile> generateDeviceUploadFile(@NonNull Context context, @NonNull EventObject eventObject, @NonNull File file) {
        Set<LogFile> obtainDeviceSnapShots;
        HashSet hashSet = null;
        if (this.mForwardingEventSceneHandler != null) {
            hashSet = new HashSet(5);
            Set<DeviceSnapshotType> requireGeneralSnapshots = this.mForwardingEventSceneHandler.requireGeneralSnapshots(context, eventObject);
            if (requireGeneralSnapshots != null && requireGeneralSnapshots.size() > 0 && (obtainDeviceSnapShots = SnapshotUtil.obtainDeviceSnapShots(context, requireGeneralSnapshots, file)) != null && obtainDeviceSnapShots.size() > 0) {
                hashSet.addAll(obtainDeviceSnapShots);
            }
            Set<LogFile> customizedSnapshots = this.mForwardingEventSceneHandler.getCustomizedSnapshots(context, file, eventObject);
            if (customizedSnapshots != null && customizedSnapshots.size() > 0) {
                hashSet.addAll(customizedSnapshots);
            }
            LogFile obtainFragmentSnapShot = SnapshotUtil.obtainFragmentSnapShot(context, this.mForwardingEventSceneHandler, eventObject, file, SnapshotConstant.DeviceConstants.DEVICE_APP_SHARED_FRAGMENT_FILE);
            if (obtainFragmentSnapShot != null && obtainFragmentSnapShot.mFile.exists()) {
                hashSet.add(obtainFragmentSnapShot);
            }
        }
        return hashSet;
    }
}
