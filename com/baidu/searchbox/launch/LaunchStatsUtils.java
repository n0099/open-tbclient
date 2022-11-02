package com.baidu.searchbox.launch;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class LaunchStatsUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD = "ad";
    public static final int COLD_LAUNCH_TYPE = 0;
    public static final boolean DEBUG;
    public static final String EXTERNAL_LAUNCH = "external";
    public static final int HOT_LAUNCH_TYPE = 1;
    public static final long INVALID_LONG = -1;
    public static final String NEW_INSTALL_LAUNCH = "newInstall";
    public static final String NORMAL_LAUNCH = "normal";
    public static final String SKIN = "skin";
    public static final String TAG = "LaunchStatsUtils";
    public static final String UPGRADE_LAUNCH = "upgrade";
    public static long sAppCreateTimeStamp;
    public static long sHomePageFirstRenderEndTimeStamp;
    public static int sLaunchType;
    public static String sLaunchTypeDetail;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(98570996, "Lcom/baidu/searchbox/launch/LaunchStatsUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(98570996, "Lcom/baidu/searchbox/launch/LaunchStatsUtils;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        sAppCreateTimeStamp = -1L;
        sHomePageFirstRenderEndTimeStamp = -1L;
        sLaunchType = 0;
    }

    public LaunchStatsUtils() {
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

    public static long getAppCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return sAppCreateTimeStamp;
        }
        return invokeV.longValue;
    }

    public static long getHomePageFirstRenderEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return sHomePageFirstRenderEndTimeStamp;
        }
        return invokeV.longValue;
    }

    public static int getLaunchType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return sLaunchType;
        }
        return invokeV.intValue;
    }

    public static String getLaunchTypeDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return sLaunchTypeDetail;
        }
        return (String) invokeV.objValue;
    }

    public static boolean isAppCreateTimeValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (sAppCreateTimeStamp != -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isHomePageFirstRenderEndTimeValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (sHomePageFirstRenderEndTimeStamp != -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void setAppCreateTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65544, null, j) == null) {
            sAppCreateTimeStamp = j;
        }
    }

    public static void setHomePageFirstRenderEndTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65545, null, j) == null) {
            sHomePageFirstRenderEndTimeStamp = j;
        }
    }

    public static void setLaunchType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, null, i) == null) {
            sLaunchType = i;
        }
    }

    public static void setLaunchTypeDetail(int i, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (!z) {
                sLaunchTypeDetail = EXTERNAL_LAUNCH;
            } else if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        sLaunchTypeDetail = NEW_INSTALL_LAUNCH;
                    }
                } else {
                    sLaunchTypeDetail = "upgrade";
                }
            } else {
                sLaunchTypeDetail = "normal";
            }
            if (z2) {
                sLaunchTypeDetail += "_skin";
            }
            if (z3 && i != 2) {
                sLaunchTypeDetail += "_ad";
            }
            if (DEBUG) {
                Log.d(TAG, "isLaunchFromLauncher: " + z + " hasSkin " + z2 + " hasAd " + z3);
                StringBuilder sb = new StringBuilder();
                sb.append("sLaunchType: ");
                sb.append(sLaunchType);
                Log.d(TAG, sb.toString());
            }
        }
    }
}
