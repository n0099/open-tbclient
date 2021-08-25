package com.baidu.searchbox.logsystem.basic;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.h0.b.a.a;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.baidu.searchbox.logsystem.logsys.CrashUtil;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.searchbox.logsystem.util.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public class LogSystemServiceUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LogSystemServiceUtil";
    public transient /* synthetic */ FieldHolder $fh;

    public LogSystemServiceUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
        }
    }

    public static void startLogHandlerService(@NonNull Context context, @NonNull LogType logType, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(AdIconUtil.AD_TEXT_ID, null, context, logType, str, file, logExtra) == null) {
            try {
                if (logType == LogType.NONE) {
                    if (LLog.sDebug) {
                        throw new RuntimeException("logType should not be LogType.NONE");
                    }
                } else if (TextUtils.isEmpty(str)) {
                    if (LLog.sDebug) {
                        throw new RuntimeException("basicData should no be null or length = 0");
                    }
                } else if (str.length() > 25600) {
                    boolean z = LLog.sDebug;
                    tranLogHandlerAction(context, logType, str, file, logExtra);
                } else {
                    startService(context, logType, str, null, file, logExtra);
                }
            } catch (Exception e2) {
                if (LLog.sDebug) {
                    Log.getStackTraceString(e2);
                }
            }
        }
    }

    public static void startService(@NonNull Context context, @NonNull LogType logType, @Nullable String str, @Nullable File file, @Nullable File file2, @Nullable LogExtra logExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, logType, str, file, file2, logExtra}) == null) {
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
    }

    public static void tranLogHandlerAction(@NonNull Context context, @NonNull LogType logType, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, context, logType, str, file, logExtra) == null) {
            File obtainFileDirWithProcessName = LogPipelineSingleton.obtainFileDirWithProcessName(a.b());
            if (!obtainFileDirWithProcessName.exists()) {
                obtainFileDirWithProcessName.mkdirs();
            }
            File file2 = new File(obtainFileDirWithProcessName, SnapshotConstant.ProcessConstants.PROCESS_LOG_BASIC_DATA);
            if (Utility.createNewEmptyFile(file2)) {
                Utility.writeStringToFile(file2, str);
                if (LLog.sDebug) {
                    String str2 = "basicData" + str;
                    String str3 = "logBasicFile = " + file2;
                }
                startLogHandlerService(context, logType, file2, file, logExtra);
            }
        }
    }

    public static void startLogHandlerService(@NonNull Context context, @NonNull LogType logType, @NonNull File file, @Nullable File file2, @Nullable LogExtra logExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, context, logType, file, file2, logExtra) == null) {
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
                    Log.getStackTraceString(e2);
                }
            }
        }
    }

    public static void startLogHandlerService(@NonNull Context context, @NonNull LogType logType, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, logType, str) == null) {
            startLogHandlerService(context, logType, str, (File) null, (LogExtra) null);
        }
    }

    public static void startLogHandlerService(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, LokiService.class);
                intent.putExtra("logtype", LogType.NONE);
                context.startService(intent);
            } catch (Exception e2) {
                if (LLog.sDebug) {
                    Log.getStackTraceString(e2);
                }
            }
        }
    }
}
