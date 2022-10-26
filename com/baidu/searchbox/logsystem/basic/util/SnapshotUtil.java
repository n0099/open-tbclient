package com.baidu.searchbox.logsystem.basic.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.logsystem.basic.Loki;
import com.baidu.searchbox.logsystem.basic.track.LokiTrackUISaver;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ForwardingDeviceEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ForwardingProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.DeviceSnapshotType;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.searchbox.logsystem.util.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes2.dex */
public class SnapshotUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_FILE_PATH_NAME_PARAMETER_DIVIDER = "=";
    public transient /* synthetic */ FieldHolder $fh;

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
        }
    }

    /* renamed from: com.baidu.searchbox.logsystem.basic.util.SnapshotUtil$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$logsystem$logsys$eventscene$snapshot$DeviceSnapshotType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2098273746, "Lcom/baidu/searchbox/logsystem/basic/util/SnapshotUtil$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2098273746, "Lcom/baidu/searchbox/logsystem/basic/util/SnapshotUtil$1;");
                    return;
                }
            }
            int[] iArr = new int[DeviceSnapshotType.values().length];
            $SwitchMap$com$baidu$searchbox$logsystem$logsys$eventscene$snapshot$DeviceSnapshotType = iArr;
            try {
                iArr[DeviceSnapshotType.DEVICE_APP_DB_INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$logsystem$logsys$eventscene$snapshot$DeviceSnapshotType[DeviceSnapshotType.DEVICE_APP_LOGCAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$logsystem$logsys$eventscene$snapshot$DeviceSnapshotType[DeviceSnapshotType.DEVICE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$logsystem$logsys$eventscene$snapshot$DeviceSnapshotType[DeviceSnapshotType.DEVICE_LINUX_KERNEL_VERSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$logsystem$logsys$eventscene$snapshot$DeviceSnapshotType[DeviceSnapshotType.DEVICE_BUILD_PROC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$logsystem$logsys$eventscene$snapshot$DeviceSnapshotType[DeviceSnapshotType.DEVICE_GUP_MEM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$logsystem$logsys$eventscene$snapshot$DeviceSnapshotType[DeviceSnapshotType.DEVICE_ION_MEM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public SnapshotUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static File createPathNameKeeper(File file, Set set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, file, set)) == null) {
            FileWriter fileWriter = null;
            if (set.size() <= 0) {
                return null;
            }
            File file2 = new File(file, SnapshotConstant.LocalConstants.LOCAL_PROCESS_PATH_NAME_KEEPER);
            try {
                if (Utility.createNewEmptyFile(file2)) {
                    try {
                        FileWriter fileWriter2 = new FileWriter(file2, true);
                        try {
                            Iterator it = set.iterator();
                            HashSet hashSet = new HashSet(set.size());
                            while (it.hasNext()) {
                                LogFile logFile = (LogFile) it.next();
                                if (logFile != null) {
                                    String absolutePath = logFile.mFile.getAbsolutePath();
                                    if (!TextUtils.isEmpty(absolutePath) && !hashSet.contains(absolutePath)) {
                                        hashSet.add(absolutePath);
                                        fileWriter2.write(absolutePath);
                                        fileWriter2.write("=");
                                        fileWriter2.write(String.valueOf(logFile.mCanDelete));
                                        fileWriter2.write("=");
                                        fileWriter2.write(String.valueOf(logFile.mNecessary));
                                        fileWriter2.write("\n");
                                    }
                                }
                            }
                            fileWriter2.flush();
                            fileWriter2.close();
                        } catch (Throwable th) {
                            th = th;
                            fileWriter = fileWriter2;
                            try {
                                th.printStackTrace();
                                if (fileWriter != null) {
                                    fileWriter.close();
                                }
                                return file2;
                            } catch (Throwable th2) {
                                if (fileWriter != null) {
                                    try {
                                        fileWriter.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return file2;
        }
        return (File) invokeLL.objValue;
    }

    public static Set obtainDeviceSnapShots(Context context, Set set, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, set, file)) == null) {
            HashSet hashSet = new HashSet(5);
            Iterator it = set.iterator();
            while (it.hasNext()) {
                switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$logsystem$logsys$eventscene$snapshot$DeviceSnapshotType[((DeviceSnapshotType) it.next()).ordinal()]) {
                    case 1:
                        File file2 = new File(file, SnapshotConstant.DeviceConstants.DEVICE_APP_DB_INFO);
                        if (!Utility.createNewEmptyFile(file2)) {
                            break;
                        } else {
                            Utility.obtainDBInfo(context, file2);
                            hashSet.add(new LogFile(file2));
                            break;
                        }
                    case 2:
                        File file3 = new File(file, SnapshotConstant.DeviceConstants.DEVICE_APP_LOGCAT_FILE_NAME);
                        if (!Utility.createNewEmptyFile(file3)) {
                            break;
                        } else {
                            Utility.obtainLogcatFile(file3);
                            hashSet.add(new LogFile(file3));
                            break;
                        }
                    case 3:
                        File file4 = new File(file, SnapshotConstant.DeviceConstants.DEVICE_INFO);
                        if (!Utility.createNewEmptyFile(file4)) {
                            break;
                        } else {
                            Utility.obtainDeviceInfo(context, file4);
                            hashSet.add(new LogFile(file4));
                            break;
                        }
                    case 4:
                        File file5 = new File(SnapshotConstant.DeviceFilePathConstants.DEVICE_VERSION);
                        if (file5.exists() && file5.isFile()) {
                            hashSet.add(new LogFile(file5, false));
                            break;
                        }
                        break;
                    case 5:
                        File file6 = new File(SnapshotConstant.DeviceFilePathConstants.DEVICE_BUILD_CONFIG);
                        if (file6.exists() && file6.isFile()) {
                            hashSet.add(new LogFile(file6, false));
                            break;
                        }
                        break;
                    case 6:
                        File file7 = new File(SnapshotConstant.DeviceFilePathConstants.DEVICE_MALI_GPU_MEMORY);
                        if (!file7.exists() || !file7.isFile()) {
                            file7 = new File(SnapshotConstant.DeviceFilePathConstants.DEVICE_MALI_GPU_MEMORY_0);
                        }
                        if (file7.exists() && file7.isFile()) {
                            hashSet.add(new LogFile(file7, false));
                            break;
                        }
                        break;
                    case 7:
                        File file8 = new File(SnapshotConstant.DeviceFilePathConstants.DEVICE_ION_HEAP);
                        if (file8.exists() && file8.isFile()) {
                            hashSet.add(new LogFile(file8, false));
                            break;
                        }
                        break;
                }
            }
            return hashSet;
        }
        return (Set) invokeLLL.objValue;
    }

    public static LogFile obtainFragmentSnapShot(Context context, ForwardingDeviceEventSceneHandler forwardingDeviceEventSceneHandler, EventObject eventObject, File file, String str) {
        InterceptResult invokeLLLLL;
        boolean saveFragmentSnapshot;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, forwardingDeviceEventSceneHandler, eventObject, file, str)) == null) {
            File file2 = new File(file, str);
            if (Utility.createNewEmptyFile(file2)) {
                try {
                    saveFragmentSnapshot = forwardingDeviceEventSceneHandler.saveFragmentSnapshot(context, eventObject, file2);
                } catch (Exception e) {
                    if (LLog.sDebug) {
                        e.printStackTrace();
                    }
                }
                if (saveFragmentSnapshot && file2.exists()) {
                    file2.delete();
                    return null;
                }
                return new LogFile(file2, true);
            }
            saveFragmentSnapshot = false;
            if (saveFragmentSnapshot) {
            }
            return new LogFile(file2, true);
        }
        return (LogFile) invokeLLLLL.objValue;
    }

    public static LogFile obtainFragmentSnapShot(Context context, ForwardingProcessEventSceneHandler forwardingProcessEventSceneHandler, EventObject eventObject, File file, String str) {
        InterceptResult invokeLLLLL;
        boolean saveFragmentSnapshot;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65541, null, context, forwardingProcessEventSceneHandler, eventObject, file, str)) == null) {
            File file2 = new File(file, str);
            if (Utility.createNewEmptyFile(file2)) {
                try {
                    saveFragmentSnapshot = forwardingProcessEventSceneHandler.saveFragmentSnapshot(context, eventObject, file2);
                } catch (Exception e) {
                    if (LLog.sDebug) {
                        Log.d("SnapshotUtil", Log.getStackTraceString(e));
                    }
                }
                if (saveFragmentSnapshot && file2.exists()) {
                    file2.delete();
                    return null;
                }
                return new LogFile(file2, true);
            }
            saveFragmentSnapshot = false;
            if (saveFragmentSnapshot) {
            }
            return new LogFile(file2, true);
        }
        return (LogFile) invokeLLLLL.objValue;
    }

    public static Set obtainProcessSnapShots(Context context, Set set, File file, String str, LogExtra logExtra) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65542, null, context, set, file, str, logExtra)) == null) {
            HashSet hashSet = new HashSet(5);
            Iterator it = set.iterator();
            while (it.hasNext()) {
                ProcessSnapshotType processSnapshotType = (ProcessSnapshotType) it.next();
                if (processSnapshotType == ProcessSnapshotType.PROCESS_SMAPS) {
                    File file2 = new File(file, SnapshotConstant.ProcessConstants.PROC_SMAPS_FILE);
                    if (Utility.createNewEmptyFile(file2)) {
                        Utility.obtainProcessSmaps(file2);
                        hashSet.add(new LogFile(file2));
                    }
                } else if (processSnapshotType == ProcessSnapshotType.PROCESS_STATUS) {
                    File file3 = new File(file, SnapshotConstant.ProcessConstants.PROC_STATUS);
                    if (Utility.createNewEmptyFile(file3)) {
                        Utility.obtainProcessStatus(file3);
                        hashSet.add(new LogFile(file3, true, true));
                    }
                } else if (processSnapshotType == ProcessSnapshotType.PROCESS_MAPS) {
                    File file4 = new File(file, SnapshotConstant.ProcessConstants.PROC_MAPS);
                    if (Utility.createNewEmptyFile(file4)) {
                        Utility.obtainProcessMaps(file4);
                        hashSet.add(new LogFile(file4));
                    }
                } else if (processSnapshotType == ProcessSnapshotType.PROCESS_THREAD_LIST) {
                    File file5 = new File(file, SnapshotConstant.ProcessConstants.PROC_THREADS_INFO);
                    if (Utility.createNewEmptyFile(file5)) {
                        Utility.obtainProcessThreadsInfo(file5);
                        hashSet.add(new LogFile(file5));
                    }
                } else if (processSnapshotType == ProcessSnapshotType.PROCESS_FILE_DESCRIPTOR) {
                    File file6 = new File(file, SnapshotConstant.ProcessConstants.PROC_FD_INFO);
                    if (Utility.createNewEmptyFile(file6)) {
                        Utility.obtainProcessFdInfo(file6);
                        hashSet.add(new LogFile(file6));
                    }
                } else if (processSnapshotType == ProcessSnapshotType.PROCESS_UI_TRACE) {
                    File file7 = new File(file, SnapshotConstant.ProcessConstants.PROC_UI_TRACE);
                    if (Loki.isStartTrack() && Utility.createNewEmptyFile(file7)) {
                        if (LokiTrackUISaver.saveFinalTraceFile(file7)) {
                            hashSet.add(new LogFile(file7, true));
                        } else {
                            file7.delete();
                        }
                    }
                } else if (processSnapshotType == ProcessSnapshotType.PROCESS_MEMORY_STATUS) {
                    File file8 = new File(file, SnapshotConstant.ProcessConstants.PROCESS_MEM_STATUS);
                    if (Utility.createNewEmptyFile(file8)) {
                        Utility.obtainMemoryInfo(context, file8);
                        hashSet.add(new LogFile(file8));
                    }
                } else if (processSnapshotType == ProcessSnapshotType.PROCESS_RUNNING_STATUS) {
                    File file9 = new File(file, SnapshotConstant.ProcessConstants.PROCESS_RUNNING_STATUS);
                    if (Utility.createNewEmptyFile(file9)) {
                        Utility.obtainProcessRunningStatus(context, file9, str, logExtra);
                        hashSet.add(new LogFile(file9, true, true));
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeLLLLL.objValue;
    }
}
