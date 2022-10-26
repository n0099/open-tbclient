package com.baidu.searchbox.logsystem.basic;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.crashpad.ZwCrashpad;
import com.baidu.disasterrecovery.jnicrash.NativeCrashCapture;
import com.baidu.searchbox.aop.annotation.TimeSpendTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.basic.javacrash.BaseUncaughtExceptionHandler;
import com.baidu.searchbox.logsystem.basic.track.LokiTrackUISaver;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.searchbox.logsystem.util.AppExtraUtil;
import com.baidu.searchbox.track.Track;
import com.baidu.tieba.h20;
import com.baidu.tieba.ve1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class Loki {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CRASHPAD_DUMPER_PROCESS_NAME = ":dumper";
    public static final String CRASH_PAD_PROCESS_NAME = ":crashpad";
    public static volatile boolean sIsInitialized;
    public static volatile boolean sIsStartTrack;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1613861027, "Lcom/baidu/searchbox/logsystem/basic/Loki;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1613861027, "Lcom/baidu/searchbox/logsystem/basic/Loki;");
        }
    }

    public Loki() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void initService() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, null) == null) && isLokiService(ve1.b())) {
            LokiService.mProcessor = new LogSystemProcessor();
        }
    }

    public static boolean isStartTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return sIsInitialized;
        }
        return invokeV.booleanValue;
    }

    public static void startTrack() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65552, null) == null) && !sIsStartTrack) {
            sIsStartTrack = true;
            Track.getInstance().addTrackUIListener(LokiTrackUISaver.getTrackUiListener());
            Track.getInstance().startTrack(AppRuntime.getAppContext());
        }
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            init(context, new BaseUncaughtExceptionHandler(context));
            startTrack();
        }
    }

    public static void initNative(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            initNative(context, true);
        }
    }

    public static void initService(LogSystemProcessor logSystemProcessor) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, logSystemProcessor) == null) && isLokiService(ve1.b())) {
            LokiService.mProcessor = logSystemProcessor;
        }
    }

    public static boolean isCrashpadService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!str.endsWith(CRASH_PAD_PROCESS_NAME) && !str.endsWith(CRASHPAD_DUMPER_PROCESS_NAME)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isLokiService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                return str.endsWith(LokiService.LOG_SYSTEM_SERVICE);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void retryUpload(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, context) == null) && ve1.f() && LogSystemUploaderStrategy.checkFlag()) {
            LogSystemServiceUtil.startLogHandlerService(context);
        }
    }

    public static void setAppExtraCall(AppExtraUtil.AppExtraCall appExtraCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, appExtraCall) == null) {
            AppExtraUtil.setAppExtraCall(appExtraCall);
        }
    }

    public static boolean setCyberVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            return ZwCrashpad.setCyberVersion(str);
        }
        return invokeL.booleanValue;
    }

    @TimeSpendTrace(tag = "AppInit")
    public static void init(Context context, BaseUncaughtExceptionHandler baseUncaughtExceptionHandler) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, context, baseUncaughtExceptionHandler) != null) || isLokiService(ve1.b())) {
            return;
        }
        retryUpload(context);
        if (sIsInitialized || baseUncaughtExceptionHandler == null) {
            return;
        }
        sIsInitialized = true;
        Thread.setDefaultUncaughtExceptionHandler(baseUncaughtExceptionHandler);
    }

    public static void initNative(Context context, h20 h20Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, h20Var) == null) {
            initNative(context, h20Var, true);
        }
    }

    public static void initNative(Context context, h20 h20Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(65542, null, context, h20Var, z) != null) || isLokiService(ve1.b())) {
            return;
        }
        NativeCrashCapture.init(context, h20Var, z);
    }

    public static void initNative(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65543, null, context, z) != null) || isLokiService(ve1.b())) {
            return;
        }
        NativeCrashCapture.init(context, new h20(context), z);
    }
}
