package com.baidu.searchbox.logsystem.basic;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.baidu.searchbox.logsystem.logsys.CrashUtil;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.searchbox.logsystem.util.Utility;
import d.b.c0.b.a.a;
import java.io.File;
/* loaded from: classes2.dex */
public class LogSystemServiceUtil {
    public static final String TAG = "LogSystemServiceUtil";

    public static void init() {
    }

    public static void startLogHandlerService(@NonNull Context context, @NonNull LogType logType, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
        try {
            if (logType == LogType.NONE) {
                if (LLog.sDebug) {
                    Log.d(TAG, "logType should not be LogType.NONE");
                    throw new RuntimeException("logType should not be LogType.NONE");
                }
            } else if (TextUtils.isEmpty(str)) {
                if (LLog.sDebug) {
                    Log.d(TAG, "basicData should no be null or length = 0");
                    throw new RuntimeException("basicData should no be null or length = 0");
                }
            } else if (str.length() > 25600) {
                if (LLog.sDebug) {
                    Log.d(TAG, "basicData.length() > 25600");
                }
                tranLogHandlerAction(context, logType, str, file, logExtra);
            } else {
                startService(context, logType, str, null, file, logExtra);
            }
        } catch (Exception e2) {
            if (LLog.sDebug) {
                Log.d(TAG, Log.getStackTraceString(e2));
            }
        }
    }

    public static void startService(@NonNull Context context, @NonNull LogType logType, @Nullable String str, @Nullable File file, @Nullable File file2, @Nullable LogExtra logExtra) {
        if (str == null && file == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, LokiService.class);
        intent.putExtra(LokiService.Constant.LOG_PROCESS_NAME, a.b());
        intent.putExtra("logtype", logType);
        if (str != null) {
            intent.putExtra(LokiService.Constant.LOG_BASIC_DATA, str);
        }
        if (file != null) {
            intent.putExtra(LokiService.Constant.LOG_BASIC_DATA_FILE, file.getAbsolutePath());
        }
        if (logExtra != null) {
            intent.putExtra(LokiService.Constant.LOG_EXTRA, logExtra);
        }
        if (file2 != null) {
            String absolutePath = file2.getAbsolutePath();
            if (!TextUtils.isEmpty(absolutePath)) {
                intent.putExtra(LokiService.Constant.LOG_EXTRA_PATHNAME_KEEPER, absolutePath);
            }
        }
        intent.putExtra(LokiService.Constant.LOG_CRASH_TAG, CrashUtil.getCrashTAG());
        context.startService(intent);
    }

    public static void tranLogHandlerAction(@NonNull Context context, @NonNull LogType logType, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
        File obtainFileDirWithProcessName = LogPipelineSingleton.obtainFileDirWithProcessName(a.b());
        if (!obtainFileDirWithProcessName.exists()) {
            obtainFileDirWithProcessName.mkdirs();
        }
        File file2 = new File(obtainFileDirWithProcessName, SnapshotConstant.ProcessConstants.PROCESS_LOG_BASIC_DATA);
        if (Utility.createNewEmptyFile(file2)) {
            Utility.writeStringToFile(file2, str);
            if (LLog.sDebug) {
                Log.d(TAG, "basicData" + str);
                Log.d(TAG, "logBasicFile = " + file2);
            }
            startLogHandlerService(context, logType, file2, file, logExtra);
        }
    }

    public static void startLogHandlerService(@NonNull Context context, @NonNull LogType logType, @NonNull File file, @Nullable File file2, @Nullable LogExtra logExtra) {
        try {
            if (logType == LogType.NONE) {
                if (LLog.sDebug) {
                    throw new RuntimeException("logType should not be LogType.NONE");
                }
                return;
            }
            if (file.exists() && file.isFile()) {
                startService(context, logType, null, file, file2, logExtra);
                return;
            }
            if (LLog.sDebug) {
                throw new RuntimeException("basicDataFile should exist and be a file.");
            }
        } catch (Exception e2) {
            if (LLog.sDebug) {
                Log.d(TAG, Log.getStackTraceString(e2));
            }
        }
    }

    public static void startLogHandlerService(@NonNull Context context, @NonNull LogType logType, @NonNull String str) {
        startLogHandlerService(context, logType, str, (File) null, (LogExtra) null);
    }

    public static void startLogHandlerService(@NonNull Context context) {
        try {
            Intent intent = new Intent();
            intent.setClass(context, LokiService.class);
            intent.putExtra("logtype", LogType.NONE);
            context.startService(intent);
        } catch (Exception e2) {
            if (LLog.sDebug) {
                Log.d(TAG, Log.getStackTraceString(e2));
            }
        }
    }
}
