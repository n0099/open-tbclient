package com.baidu.searchbox.logsystem.basic;

import android.app.Service;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class LogSystemProcessor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int KEEP_ALIVE_TIME = 60000;
    public static final String TAG = "LogSystemProcessor";
    public transient /* synthetic */ FieldHolder $fh;
    public ForwardingDeviceEventSceneHandler mForwardingEventSceneHandler;
    public Handler mHandler;
    @NonNull
    public ThreadPoolExecutor mProcessExecutor;
    public List<BaseUploaderStrategy> mUploaderStrategies;

    /* renamed from: com.baidu.searchbox.logsystem.basic.LogSystemProcessor$4  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$logsystem$logsys$LogType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1826836085, "Lcom/baidu/searchbox/logsystem/basic/LogSystemProcessor$4;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1826836085, "Lcom/baidu/searchbox/logsystem/basic/LogSystemProcessor$4;");
                    return;
                }
            }
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LogSystemProcessor() {
        this(null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((ForwardingDeviceEventSceneHandler) objArr[0], (List) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteLogFiles(@NonNull LogObject logObject, @Nullable ArrayList<LogFile> arrayList, @Nullable Set<LogFile> set, @Nullable File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, this, logObject, arrayList, set, file) == null) {
            if (logObject.getLogBasicDataFile() != null) {
                logObject.getLogBasicDataFile().delete();
                if (LLog.sDebug) {
                    String str = "logBasicDataFile = " + logObject.getLogBasicDataFile();
                }
            }
            if (logObject.getLogExtraPathNameKeeper() != null) {
                logObject.getLogExtraPathNameKeeper().delete();
                if (LLog.sDebug) {
                    String str2 = "pathNameKeeper = " + logObject.getLogExtraPathNameKeeper();
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<LogFile> it = arrayList.iterator();
                while (it.hasNext()) {
                    LogFile next = it.next();
                    if (next != null && next.mCanDelete) {
                        next.mFile.delete();
                        if (LLog.sDebug) {
                            String str3 = "processLogFile = " + next.mFile.getAbsolutePath();
                        }
                    }
                }
            }
            if (set != null && set.size() > 0) {
                for (LogFile logFile : set) {
                    if (logFile != null && logFile.mCanDelete) {
                        logFile.mFile.delete();
                        if (LLog.sDebug) {
                            String str4 = "deviceLogFile = " + logFile.mFile.getAbsolutePath();
                        }
                    }
                }
            }
            if (file == null || !file.exists()) {
                return;
            }
            FileUtils.deleteFile(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<LogFile> generateDeviceUploadFile(@NonNull Context context, @NonNull EventObject eventObject, @NonNull File file) {
        InterceptResult invokeLLL;
        Set<LogFile> obtainDeviceSnapShots;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, this, context, eventObject, file)) == null) {
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
                if (obtainFragmentSnapShot == null || !obtainFragmentSnapShot.mFile.exists()) {
                    return hashSet;
                }
                hashSet.add(obtainFragmentSnapShot);
                return hashSet;
            }
            return null;
        }
        return (Set) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<LogFile> getCrashpadFile(@NonNull File file) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, file)) == null) {
            if (file == null || !file.exists() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (File file2 : listFiles) {
                LogFile logFile = new LogFile(file2, true, true);
                if (LLog.sDebug) {
                    String str = logFile.mFile.getAbsolutePath() + StringUtil.ARRAY_ELEMENT_SEPARATOR + logFile.mCanDelete + StringUtil.ARRAY_ELEMENT_SEPARATOR + logFile.mNecessary;
                }
                linkedList.add(logFile);
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public ArrayList<LogFile> obtainProcessLogFiles(@NonNull File file) {
        InterceptResult invokeL;
        LogFile logFile;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65549, this, file)) != null) {
            return (ArrayList) invokeL.objValue;
        }
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
                                String str = "pathNameKeep line = " + readLine;
                            }
                            String[] split = readLine.split("=");
                            if (split != null && split.length == 3 && split[0] != null && split[1] != null && split[2] != null) {
                                File file2 = new File(split[0].trim());
                                if (file2.exists() && file2.isFile()) {
                                    arrayList.add(new LogFile(file2, Boolean.valueOf(split[1].trim()).booleanValue(), Boolean.valueOf(split[2].trim()).booleanValue()));
                                    if (LLog.sDebug) {
                                        String str2 = "LogFile = " + logFile.toString();
                                    }
                                }
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
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
            } catch (IOException e3) {
                e = e3;
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopSelfIfNeed(@NonNull Service service, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, this, service, i2) == null) {
            this.mHandler.postDelayed(new Runnable(this, service, i2) { // from class: com.baidu.searchbox.logsystem.basic.LogSystemProcessor.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LogSystemProcessor this$0;
                public final /* synthetic */ Service val$service;
                public final /* synthetic */ int val$startID;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, service, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$service = service;
                    this.val$startID = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        boolean z = true;
                        for (int i3 = 0; i3 < this.this$0.mUploaderStrategies.size(); i3++) {
                            z = z && ((BaseUploaderStrategy) this.this$0.mUploaderStrategies.get(i3)).canStopService();
                            if (!z) {
                                break;
                            }
                        }
                        if (!z || this.this$0.mProcessExecutor.getQueue().size() != 0 || this.this$0.mProcessExecutor.getActiveCount() != 0) {
                            this.this$0.stopSelfIfNeed(this.val$service, this.val$startID);
                        } else {
                            this.val$service.stopSelf(this.val$startID);
                        }
                    }
                }
            }, 60000L);
        }
    }

    public void process(@NonNull Service service, int i2, @NonNull LogBaseObject logBaseObject) {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, service, i2, logBaseObject) == null) {
            int i3 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$logsys$LogType[logBaseObject.mLogType.ordinal()];
            if (i3 == 1 || i3 == 2) {
                if (logBaseObject instanceof LogObject) {
                    LogObject logObject = (LogObject) logBaseObject;
                    if (TextUtils.isEmpty(logObject.getLogBasicData()) && logObject.getLogBasicDataFile() == null) {
                        if (!LLog.sDebug) {
                            stopSelfIfNeed(service, i2);
                            return;
                        }
                        throw new RuntimeException("if the logType = " + logObject.mLogType.getTypeName() + ", mLogBasicData should not be empty and mLogBasicDataFile should not be null");
                    } else if (TextUtils.isEmpty(logObject.getProcessName())) {
                        if (!LLog.sDebug) {
                            stopSelfIfNeed(service, i2);
                            return;
                        }
                        throw new RuntimeException("if the logType = " + logObject.mLogType.getTypeName() + "mProcessName should not be null or its length = 0");
                    } else {
                        runnable = new Runnable(this, logObject, service, i2) { // from class: com.baidu.searchbox.logsystem.basic.LogSystemProcessor.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ LogSystemProcessor this$0;
                            public final /* synthetic */ LogObject val$logObject;
                            public final /* synthetic */ Service val$service;
                            public final /* synthetic */ int val$serviceStartID;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, logObject, service, Integer.valueOf(i2)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$logObject = logObject;
                                this.val$service = service;
                                this.val$serviceStartID = i2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                List<LogFile> list;
                                File file;
                                Object obj;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    File obtainFileDirWithProcessName = LogPipelineSingleton.obtainFileDirWithProcessName(this.val$logObject.getProcessName());
                                    if (!obtainFileDirWithProcessName.exists()) {
                                        obtainFileDirWithProcessName.mkdirs();
                                    }
                                    Context applicationContext = this.val$service.getApplicationContext();
                                    if (this.val$logObject.getLogBasicDataFile() != null) {
                                        Pair<String, Boolean> readFile = Utility.readFile(this.val$logObject.getLogBasicDataFile(), LokiService.Constant.MAX_LENGTH_OF_STRING_TO_DIRECT_TRANS_WITH_BINDER);
                                        if (readFile != null && (obj = readFile.first) != null) {
                                            this.val$logObject.setLogBasicData((String) obj);
                                            this.val$logObject.setLogBasicDataOverflow(((Boolean) readFile.second).booleanValue());
                                        } else {
                                            this.val$logObject.setLogBasicData("logsystem read file error");
                                            this.val$logObject.setLogBasicDataOverflow(false);
                                        }
                                    } else {
                                        this.val$logObject.setLogBasicDataFile(new File(obtainFileDirWithProcessName, SnapshotConstant.ProcessConstants.PROCESS_LOG_BASIC_DATA));
                                        if (Utility.createNewEmptyFile(this.val$logObject.getLogBasicDataFile())) {
                                            FileUtils.saveToFile(this.val$logObject.getLogBasicData(), this.val$logObject.getLogBasicDataFile(), true);
                                        }
                                    }
                                    ArrayList obtainProcessLogFiles = this.val$logObject.getLogExtraPathNameKeeper() != null ? this.this$0.obtainProcessLogFiles(this.val$logObject.getLogExtraPathNameKeeper()) : null;
                                    boolean z = LLog.sDebug;
                                    Object obj2 = StringUtil.NULL_STRING;
                                    if (z) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("processFiles.size = ");
                                        sb.append(obtainProcessLogFiles != null ? Integer.valueOf(obtainProcessLogFiles.size()) : StringUtil.NULL_STRING);
                                        sb.toString();
                                    }
                                    LogSystemProcessor logSystemProcessor = this.this$0;
                                    LogObject logObject2 = this.val$logObject;
                                    Set<LogFile> generateDeviceUploadFile = logSystemProcessor.generateDeviceUploadFile(applicationContext, new EventObject(logObject2.mLogType, logObject2.getLogBasicData()), obtainFileDirWithProcessName);
                                    if (LLog.sDebug) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("devicesLogFiles.size = ");
                                        sb2.append(generateDeviceUploadFile != null ? Integer.valueOf(generateDeviceUploadFile.size()) : StringUtil.NULL_STRING);
                                        sb2.toString();
                                    }
                                    if (this.val$logObject.mLogType == LogType.NATIVE_CRASH) {
                                        File processCrashpadDir = LogPipelineSingleton.getInstance().getProcessCrashpadDir(this.val$logObject.getCrashTAG());
                                        file = processCrashpadDir;
                                        list = processCrashpadDir != null ? this.this$0.getCrashpadFile(processCrashpadDir) : null;
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
                                        sb3.toString();
                                    }
                                    for (int i4 = 0; i4 < this.this$0.mUploaderStrategies.size(); i4++) {
                                        BaseUploaderStrategy baseUploaderStrategy = (BaseUploaderStrategy) this.this$0.mUploaderStrategies.get(i4);
                                        if (LLog.sDebug) {
                                            String str = "uploaderStrategy = " + baseUploaderStrategy.getClass().getName();
                                        }
                                        try {
                                            baseUploaderStrategy.upload(applicationContext, this.val$logObject, obtainProcessLogFiles, generateDeviceUploadFile, list);
                                        } catch (Exception e2) {
                                            if (LLog.sDebug) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    }
                                    this.this$0.deleteLogFiles(this.val$logObject, obtainProcessLogFiles, generateDeviceUploadFile, file);
                                    this.this$0.stopSelfIfNeed(this.val$service, this.val$serviceStartID);
                                }
                            }
                        };
                    }
                }
                runnable = null;
            } else {
                if (i3 == 3) {
                    runnable = new Runnable(this, service, i2) { // from class: com.baidu.searchbox.logsystem.basic.LogSystemProcessor.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LogSystemProcessor this$0;
                        public final /* synthetic */ Service val$service;
                        public final /* synthetic */ int val$serviceStartID;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, service, Integer.valueOf(i2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$service = service;
                            this.val$serviceStartID = i2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                for (int i4 = 0; i4 < this.this$0.mUploaderStrategies.size(); i4++) {
                                    ((BaseUploaderStrategy) this.this$0.mUploaderStrategies.get(i4)).upload(this.val$service.getApplicationContext());
                                }
                                this.this$0.stopSelfIfNeed(this.val$service, this.val$serviceStartID);
                            }
                        }
                    };
                }
                runnable = null;
            }
            if (runnable != null) {
                this.mProcessExecutor.submit(runnable);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LogSystemProcessor(@Nullable ForwardingDeviceEventSceneHandler forwardingDeviceEventSceneHandler) {
        this(forwardingDeviceEventSceneHandler, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forwardingDeviceEventSceneHandler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ForwardingDeviceEventSceneHandler) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public LogSystemProcessor(@Nullable ForwardingDeviceEventSceneHandler forwardingDeviceEventSceneHandler, @Nullable List<BaseUploaderStrategy> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forwardingDeviceEventSceneHandler, list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
}
