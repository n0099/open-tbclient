package com.baidu.searchbox.logsystem.basic;

import android.app.Service;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
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
/* loaded from: classes2.dex */
public class LogSystemProcessor {
    public static final int KEEP_ALIVE_TIME = 60000;
    public static final String TAG = "LogSystemProcessor";
    public ForwardingDeviceEventSceneHandler mForwardingEventSceneHandler;
    public Handler mHandler;
    @NonNull
    public ThreadPoolExecutor mProcessExecutor;
    public List<BaseUploaderStrategy> mUploaderStrategies;

    /* renamed from: com.baidu.searchbox.logsystem.basic.LogSystemProcessor$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$logsystem$logsys$LogType;

        static {
            int[] iArr = new int[LogType.values().length];
            $SwitchMap$com$baidu$searchbox$logsystem$logsys$LogType = iArr;
            try {
                iArr[LogType.NATIVE_CRASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$logsystem$logsys$LogType[LogType.JAVA_CRASH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$logsystem$logsys$LogType[LogType.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

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

    /* JADX INFO: Access modifiers changed from: private */
    public void stopSelfIfNeed(@NonNull final Service service, final int i) {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.searchbox.logsystem.basic.LogSystemProcessor.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z = true;
                for (int i2 = 0; i2 < LogSystemProcessor.this.mUploaderStrategies.size(); i2++) {
                    if (z && ((BaseUploaderStrategy) LogSystemProcessor.this.mUploaderStrategies.get(i2)).canStopService()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        break;
                    }
                }
                if (z && LogSystemProcessor.this.mProcessExecutor.getQueue().size() == 0 && LogSystemProcessor.this.mProcessExecutor.getActiveCount() == 0) {
                    service.stopSelf(i);
                } else {
                    LogSystemProcessor.this.stopSelfIfNeed(service, i);
                }
            }
        }, 60000L);
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
    public Set<LogFile> generateDeviceUploadFile(@NonNull Context context, @NonNull EventObject eventObject, @NonNull File file) {
        Set<LogFile> obtainDeviceSnapShots;
        if (this.mForwardingEventSceneHandler != null) {
            HashSet hashSet = new HashSet(5);
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
                return hashSet;
            }
            return hashSet;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<LogFile> getCrashpadFile(@NonNull File file) {
        File[] listFiles;
        if (file != null && file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            LinkedList linkedList = new LinkedList();
            for (File file2 : listFiles) {
                LogFile logFile = new LogFile(file2, true, true);
                if (LLog.sDebug) {
                    Log.d(TAG, logFile.mFile.getAbsolutePath() + StringUtil.ARRAY_ELEMENT_SEPARATOR + logFile.mCanDelete + StringUtil.ARRAY_ELEMENT_SEPARATOR + logFile.mNecessary);
                }
                linkedList.add(logFile);
            }
            return linkedList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public ArrayList<LogFile> obtainProcessLogFiles(@NonNull File file) {
        BufferedReader bufferedReader = null;
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        ArrayList<LogFile> arrayList = new ArrayList<>(5);
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        } else if (!TextUtils.isEmpty(readLine)) {
                            if (LLog.sDebug) {
                                Log.d(TAG, "pathNameKeep line = " + readLine);
                            }
                            String[] split = readLine.split("=");
                            if (split != null && split.length == 3 && split[0] != null && split[1] != null && split[2] != null) {
                                File file2 = new File(split[0].trim());
                                if (file2.exists() && file2.isFile()) {
                                    LogFile logFile = new LogFile(file2, Boolean.valueOf(split[1].trim()).booleanValue(), Boolean.valueOf(split[2].trim()).booleanValue());
                                    arrayList.add(logFile);
                                    if (LLog.sDebug) {
                                        Log.d(TAG, "LogFile = " + logFile.toString());
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        Closeables.closeSafely(bufferedReader);
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        Closeables.closeSafely(bufferedReader);
                        throw th;
                    }
                }
                Closeables.closeSafely(bufferedReader2);
            } catch (IOException e2) {
                e = e2;
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void process(@NonNull final Service service, final int i, @NonNull LogBaseObject logBaseObject) {
        Runnable runnable;
        int i2 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$logsys$LogType[logBaseObject.mLogType.ordinal()];
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3) {
                runnable = new Runnable() { // from class: com.baidu.searchbox.logsystem.basic.LogSystemProcessor.2
                    @Override // java.lang.Runnable
                    public void run() {
                        for (int i3 = 0; i3 < LogSystemProcessor.this.mUploaderStrategies.size(); i3++) {
                            ((BaseUploaderStrategy) LogSystemProcessor.this.mUploaderStrategies.get(i3)).upload(service.getApplicationContext());
                        }
                        LogSystemProcessor.this.stopSelfIfNeed(service, i);
                    }
                };
            }
            runnable = null;
        } else {
            if (logBaseObject instanceof LogObject) {
                final LogObject logObject = (LogObject) logBaseObject;
                if (TextUtils.isEmpty(logObject.getLogBasicData()) && logObject.getLogBasicDataFile() == null) {
                    if (!LLog.sDebug) {
                        stopSelfIfNeed(service, i);
                        return;
                    }
                    throw new RuntimeException("if the logType = " + logObject.mLogType.getTypeName() + ", mLogBasicData should not be empty and mLogBasicDataFile should not be null");
                } else if (TextUtils.isEmpty(logObject.getProcessName())) {
                    if (!LLog.sDebug) {
                        stopSelfIfNeed(service, i);
                        return;
                    }
                    throw new RuntimeException("if the logType = " + logObject.mLogType.getTypeName() + "mProcessName should not be null or its length = 0");
                } else {
                    runnable = new Runnable() { // from class: com.baidu.searchbox.logsystem.basic.LogSystemProcessor.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ArrayList arrayList;
                            List<LogFile> list;
                            File file;
                            Integer num;
                            Integer num2;
                            Object obj;
                            File obtainFileDirWithProcessName = LogPipelineSingleton.obtainFileDirWithProcessName(logObject.getProcessName());
                            if (!obtainFileDirWithProcessName.exists()) {
                                obtainFileDirWithProcessName.mkdirs();
                            }
                            Context applicationContext = service.getApplicationContext();
                            if (logObject.getLogBasicDataFile() != null) {
                                Pair<String, Boolean> readFile = Utility.readFile(logObject.getLogBasicDataFile(), LokiService.Constant.MAX_LENGTH_OF_STRING_TO_DIRECT_TRANS_WITH_BINDER);
                                if (readFile != null && (obj = readFile.first) != null) {
                                    logObject.setLogBasicData((String) obj);
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
                            List<LogFile> list2 = null;
                            if (logObject.getLogExtraPathNameKeeper() == null) {
                                arrayList = null;
                            } else {
                                arrayList = LogSystemProcessor.this.obtainProcessLogFiles(logObject.getLogExtraPathNameKeeper());
                            }
                            boolean z = LLog.sDebug;
                            Object obj2 = StringUtil.NULL_STRING;
                            if (z) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("processFiles.size = ");
                                if (arrayList != null) {
                                    num2 = Integer.valueOf(arrayList.size());
                                } else {
                                    num2 = StringUtil.NULL_STRING;
                                }
                                sb.append(num2);
                                Log.d(LogSystemProcessor.TAG, sb.toString());
                            }
                            LogSystemProcessor logSystemProcessor = LogSystemProcessor.this;
                            LogObject logObject2 = logObject;
                            Set<LogFile> generateDeviceUploadFile = logSystemProcessor.generateDeviceUploadFile(applicationContext, new EventObject(logObject2.mLogType, logObject2.getLogBasicData()), obtainFileDirWithProcessName);
                            if (LLog.sDebug) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("devicesLogFiles.size = ");
                                if (generateDeviceUploadFile != null) {
                                    num = Integer.valueOf(generateDeviceUploadFile.size());
                                } else {
                                    num = StringUtil.NULL_STRING;
                                }
                                sb2.append(num);
                                Log.d(LogSystemProcessor.TAG, sb2.toString());
                            }
                            if (logObject.mLogType == LogType.NATIVE_CRASH) {
                                File processCrashpadDir = LogPipelineSingleton.getInstance().getProcessCrashpadDir(logObject.getCrashTAG());
                                if (processCrashpadDir != null) {
                                    list2 = LogSystemProcessor.this.getCrashpadFile(processCrashpadDir);
                                }
                                file = processCrashpadDir;
                                list = list2;
                            } else {
                                list = null;
                                file = null;
                            }
                            if (LLog.sDebug) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("crashFiles.size = ");
                                if (list != null) {
                                    obj2 = Integer.valueOf(list.size());
                                }
                                sb3.append(obj2);
                                Log.d(LogSystemProcessor.TAG, sb3.toString());
                            }
                            for (int i3 = 0; i3 < LogSystemProcessor.this.mUploaderStrategies.size(); i3++) {
                                BaseUploaderStrategy baseUploaderStrategy = (BaseUploaderStrategy) LogSystemProcessor.this.mUploaderStrategies.get(i3);
                                if (LLog.sDebug) {
                                    Log.d(LogSystemProcessor.TAG, "uploaderStrategy = " + baseUploaderStrategy.getClass().getName());
                                }
                                try {
                                    baseUploaderStrategy.upload(applicationContext, logObject, arrayList, generateDeviceUploadFile, list);
                                } catch (Exception e) {
                                    if (LLog.sDebug) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            LogSystemProcessor.this.deleteLogFiles(logObject, arrayList, generateDeviceUploadFile, file);
                            LogSystemProcessor.this.stopSelfIfNeed(service, i);
                        }
                    };
                }
            }
            runnable = null;
        }
        if (runnable != null) {
            this.mProcessExecutor.submit(runnable);
        }
    }
}
