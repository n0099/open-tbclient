package com.baidu.searchbox.ruka;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ruka.ioc.IANRMonitor;
import com.baidu.searchbox.ruka.ioc.ILooperMonitor;
import com.baidu.searchbox.track.Track;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class Ruka {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BLOCK_THRESHOLD = 2000;
    public static volatile AtomicBoolean sANRInited;
    public static volatile AtomicBoolean sIsStartTrack;
    public static volatile AtomicBoolean sLooperInited;
    public static long sProcessLaunchTime;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-557969370, "Lcom/baidu/searchbox/ruka/Ruka;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-557969370, "Lcom/baidu/searchbox/ruka/Ruka;");
                return;
            }
        }
        sProcessLaunchTime = System.currentTimeMillis();
        sANRInited = new AtomicBoolean(false);
        sLooperInited = new AtomicBoolean(false);
        sIsStartTrack = new AtomicBoolean(false);
    }

    public Ruka() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static long getProcessLaunchTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sProcessLaunchTime : invokeV.longValue;
    }

    public static boolean isLooperMonitorStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? LooperProvider.getLooperMonitor().isMonitorStarted() : invokeV.booleanValue;
    }

    public static void setProcessLaunchTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j2) == null) {
            sProcessLaunchTime = j2;
        }
    }

    public static void startAnrMonitor(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context) == null) {
            if (AppConfig.isDebug()) {
                IANRMonitor aNRMonitor = ANRProvider.getANRMonitor();
                String str = "IANRMonitor = " + aNRMonitor.getClass().getSimpleName();
            }
            if (ANRProvider.getANRMonitor() == ANRProvider.EMPTY) {
                AppConfig.isDebug();
            } else if (!sANRInited.get() && ANRProvider.getANRMonitor().enableMonitor()) {
                sANRInited.set(true);
                ANRProvider.getANRMonitor().startANRMonitor();
                startTrack(context);
            }
        }
    }

    public static void startLooperMonitor(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, context, i2) == null) {
            if (AppConfig.isDebug()) {
                ILooperMonitor looperMonitor = LooperProvider.getLooperMonitor();
                String str = "iLooperMonitor = " + looperMonitor.getClass().getSimpleName();
            }
            if (LooperProvider.getLooperMonitor() == LooperProvider.EMPTY) {
                AppConfig.isDebug();
            } else if (!sLooperInited.get() && LooperProvider.getLooperMonitor().enableMonitor()) {
                sLooperInited.set(true);
                LooperProvider.getLooperMonitor().startLooperMonitor(context, i2);
                startTrack(context);
            }
        }
    }

    public static void startTrack(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, context) == null) || sIsStartTrack.getAndSet(true)) {
            return;
        }
        Track.getInstance().startTrack(context);
    }

    public static void stopAnrMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            ANRProvider.getANRMonitor().stopANRMonitor();
        }
    }

    public static void stopLooperMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            LooperProvider.getLooperMonitor().stopLooperMonitor();
        }
    }

    public static void startLooperMonitor(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            startLooperMonitor(context, 2000);
        }
    }
}
