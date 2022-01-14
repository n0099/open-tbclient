package com.baidu.searchbox.devicescore;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class DeviceScoreStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final float DEFAULT_LOW_THRESHOLD = 0.37f;
    public static final float DEFAULT_MID_THRESHOLD = 0.6f;
    public static final String SP_KEY_LOW_THRESHOLD = "device_score_float_low_threshold";
    public static final String SP_KEY_MID_THRESHOLD = "device_score_float_mid_threshold";
    public static final String TAG = "DeviceScoreStrategy";
    public static float sLowThreshold;
    public static float sMidThreshold;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-769674759, "Lcom/baidu/searchbox/devicescore/DeviceScoreStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-769674759, "Lcom/baidu/searchbox/devicescore/DeviceScoreStrategy;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        sLowThreshold = -1.0f;
        sMidThreshold = -1.0f;
    }

    public DeviceScoreStrategy() {
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

    public static float getLowThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sLowThreshold == -1.0f) {
                sLowThreshold = QuickPersistConfig.getInstance().getFloat(SP_KEY_LOW_THRESHOLD, 0.37f);
            }
            return sLowThreshold;
        }
        return invokeV.floatValue;
    }

    public static float getMidThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sMidThreshold == -1.0f) {
                sMidThreshold = QuickPersistConfig.getInstance().getFloat(SP_KEY_MID_THRESHOLD, 0.6f);
            }
            return sMidThreshold;
        }
        return invokeV.floatValue;
    }

    public static void updateStrategy(DeviceScoreConfig deviceScoreConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, deviceScoreConfig) == null) {
            if (deviceScoreConfig != null && validThreshold(deviceScoreConfig.lowThreshold) && validThreshold(deviceScoreConfig.midThreshold) && Float.compare(deviceScoreConfig.midThreshold, deviceScoreConfig.lowThreshold) > 0) {
                QuickPersistConfig.getInstance().putFloat(SP_KEY_LOW_THRESHOLD, deviceScoreConfig.lowThreshold);
                QuickPersistConfig.getInstance().putFloat(SP_KEY_MID_THRESHOLD, deviceScoreConfig.midThreshold);
                if (DEBUG) {
                    String str = "updateStrategy success. low threshold:" + deviceScoreConfig.lowThreshold + " mid threshold:" + deviceScoreConfig.midThreshold;
                }
            } else if (!DEBUG || deviceScoreConfig == null) {
            } else {
                String str2 = "updateStrategy exception. low threshold:" + deviceScoreConfig.lowThreshold + " mid threshold:" + deviceScoreConfig.midThreshold;
            }
        }
    }

    public static boolean validThreshold(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65541, null, f2)) == null) ? Float.compare(f2, -1.0f) > 0 && Float.compare(f2, 1.0f) <= 0 : invokeF.booleanValue;
    }
}
