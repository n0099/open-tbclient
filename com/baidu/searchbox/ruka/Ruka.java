package com.baidu.searchbox.ruka;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ruka.ioc.IANRMonitor;
import com.baidu.searchbox.ruka.ioc.IBlockMonitor;
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
/* loaded from: classes11.dex */
public final class Ruka {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BLOCK_THRESHOLD = 2000;
    public static volatile AtomicBoolean sANRInited;
    public static volatile AtomicBoolean sBlockInited;
    public static volatile AtomicBoolean sIsStartTrack;
    public static int sLineMappingMode;
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
        sBlockInited = new AtomicBoolean(false);
        sIsStartTrack = new AtomicBoolean(false);
        sLineMappingMode = -1;
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

    public static int getLineMappingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sLineMappingMode : invokeV.intValue;
    }

    public static long getProcessLaunchTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sProcessLaunchTime : invokeV.longValue;
    }

    public static boolean isLooperMonitorStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? LooperProvider.getLooperMonitor().isMonitorStarted() : invokeV.booleanValue;
    }

    public static void setLineMappingMode(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65541, null, i2) == null) || i2 < 0) {
            return;
        }
        sLineMappingMode = i2;
    }

    public static void setProcessLaunchTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65542, null, j2) == null) {
            sProcessLaunchTime = j2;
        }
    }

    public static void startAnrMonitor(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
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

    public static void startBlockMonitor(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, context, i2) == null) {
            if (AppConfig.isDebug()) {
                IBlockMonitor blockMonitor = BlockProvider.getBlockMonitor();
                String str = "iBlockMonitor = " + blockMonitor.getClass().getSimpleName();
            }
            if (BlockProvider.getBlockMonitor() == BlockProvider.EMPTY) {
                AppConfig.isDebug();
            } else if (!sBlockInited.get() && BlockProvider.getBlockMonitor().enableMonitor()) {
                sBlockInited.set(true);
                BlockProvider.getBlockMonitor().startBlockMonitor(i2);
                startTrack(context);
            }
        }
    }

    public static void startLooperMonitor(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, context, i2) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(65548, null, context) == null) || sIsStartTrack.getAndSet(true)) {
            return;
        }
        Track.getInstance().startTrack(context);
    }

    public static void stopAnrMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            ANRProvider.getANRMonitor().stopANRMonitor();
        }
    }

    public static void stopBlockMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            BlockProvider.getBlockMonitor().stopBlockMonitor();
        }
    }

    public static void stopLooperMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            LooperProvider.getLooperMonitor().stopLooperMonitor();
        }
    }

    public static void startBlockMonitor(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            startBlockMonitor(context, 2000);
        }
    }

    public static void startLooperMonitor(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            startLooperMonitor(context, 2000);
        }
    }
}
