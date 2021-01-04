package com.baidu.searchbox.logsystem.basic.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes5.dex */
public class SnapshotUtil {
    public static final String LOG_FILE_PATH_NAME_PARAMETER_DIVIDER = "=";

    public static void init() {
    }

    @NonNull
    public static Set<LogFile> obtainDeviceSnapShots(@NonNull Context context, @NonNull Set<DeviceSnapshotType> set, @NonNull File file) {
        HashSet hashSet = new HashSet(5);
        Iterator<DeviceSnapshotType> it = set.iterator();
        while (it.hasNext()) {
            switch (it.next()) {
                case DEVICE_APP_DB_INFO:
                    File file2 = new File(file, SnapshotConstant.DeviceConstants.DEVICE_APP_DB_INFO);
                    if (!Utility.createNewEmptyFile(file2)) {
                        break;
                    } else {
                        Utility.obtainDBInfo(context, file2);
                        hashSet.add(new LogFile(file2));
                        break;
                    }
                case DEVICE_APP_LOGCAT:
                    File file3 = new File(file, SnapshotConstant.DeviceConstants.DEVICE_APP_LOGCAT_FILE_NAME);
                    if (!Utility.createNewEmptyFile(file3)) {
                        break;
                    } else {
                        Utility.obtainLogcatFile(file3);
                        hashSet.add(new LogFile(file3));
                        break;
                    }
                case DEVICE_INFO:
                    File file4 = new File(file, SnapshotConstant.DeviceConstants.DEVICE_INFO);
                    if (!Utility.createNewEmptyFile(file4)) {
                        break;
                    } else {
                        Utility.obtainDeviceInfo(context, file4);
                        hashSet.add(new LogFile(file4));
                        break;
                    }
                case DEVICE_LINUX_KERNEL_VERSION:
                    File file5 = new File(SnapshotConstant.DeviceFilePathConstants.DEVICE_VERSION);
                    if (file5.exists() && file5.isFile()) {
                        hashSet.add(new LogFile(file5, false));
                        break;
                    }
                    break;
                case DEVICE_BUILD_PROC:
                    File file6 = new File(SnapshotConstant.DeviceFilePathConstants.DEVICE_BUILD_CONFIG);
                    if (file6.exists() && file6.isFile()) {
                        hashSet.add(new LogFile(file6, false));
                        break;
                    }
                    break;
                case DEVICE_GUP_MEM:
                    File file7 = new File(SnapshotConstant.DeviceFilePathConstants.DEVICE_MALI_GPU_MEMORY);
                    if (!file7.exists() || !file7.isFile()) {
                        file7 = new File(SnapshotConstant.DeviceFilePathConstants.DEVICE_MALI_GPU_MEMORY_0);
                    }
                    if (file7.exists() && file7.isFile()) {
                        hashSet.add(new LogFile(file7, false));
                        break;
                    }
                    break;
                case DEVICE_ION_MEM:
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

    @NonNull
    public static Set<LogFile> obtainProcessSnapShots(@NonNull Context context, @NonNull Set<ProcessSnapshotType> set, @NonNull File file, @NonNull String str, @NonNull LogExtra logExtra) {
        HashSet hashSet = new HashSet(5);
        for (ProcessSnapshotType processSnapshotType : set) {
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

    @Nullable
    public static LogFile obtainFragmentSnapShot(@NonNull Context context, @NonNull ForwardingDeviceEventSceneHandler forwardingDeviceEventSceneHandler, @NonNull EventObject eventObject, @NonNull File file, @NonNull String str) {
        boolean z = false;
        File file2 = new File(file, str);
        if (Utility.createNewEmptyFile(file2)) {
            try {
                z = forwardingDeviceEventSceneHandler.saveFragmentSnapshot(context, eventObject, file2);
            } catch (Exception e) {
                if (LLog.sDebug) {
                    e.printStackTrace();
                }
            }
        }
        if (!z && file2.exists()) {
            file2.delete();
            return null;
        }
        return new LogFile(file2, true);
    }

    @Nullable
    public static LogFile obtainFragmentSnapShot(@NonNull Context context, @NonNull ForwardingProcessEventSceneHandler forwardingProcessEventSceneHandler, @NonNull EventObject eventObject, @NonNull File file, @NonNull String str) {
        boolean z = false;
        File file2 = new File(file, str);
        if (Utility.createNewEmptyFile(file2)) {
            try {
                z = forwardingProcessEventSceneHandler.saveFragmentSnapshot(context, eventObject, file2);
            } catch (Exception e) {
                if (LLog.sDebug) {
                    Log.d("SnapshotUtil", Log.getStackTraceString(e));
                }
            }
        }
        if (!z && file2.exists()) {
            file2.delete();
            return null;
        }
        return new LogFile(file2, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [322=4, 317=4] */
    @Nullable
    public static File createPathNameKeeper(@NonNull File file, @NonNull Set<LogFile> set) {
        FileWriter fileWriter;
        if (set.size() > 0) {
            File file2 = new File(file, SnapshotConstant.LocalConstants.LOCAL_PROCESS_PATH_NAME_KEEPER);
            if (Utility.createNewEmptyFile(file2)) {
                try {
                    fileWriter = new FileWriter(file2, true);
                    try {
                        HashSet hashSet = new HashSet(set.size());
                        for (LogFile logFile : set) {
                            if (logFile != null) {
                                String absolutePath = logFile.mFile.getAbsolutePath();
                                if (!TextUtils.isEmpty(absolutePath) && !hashSet.contains(absolutePath)) {
                                    hashSet.add(absolutePath);
                                    fileWriter.write(absolutePath);
                                    fileWriter.write("=");
                                    fileWriter.write(String.valueOf(logFile.mCanDelete));
                                    fileWriter.write("=");
                                    fileWriter.write(String.valueOf(logFile.mNecessary));
                                    fileWriter.write("\n");
                                }
                            }
                        }
                        fileWriter.flush();
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                                return file2;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return file2;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                    return file2;
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    return file2;
                                }
                            }
                            return file2;
                        } catch (Throwable th2) {
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileWriter = null;
                }
            }
            return file2;
        }
        return null;
    }
}
