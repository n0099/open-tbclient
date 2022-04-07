package com.baidu.searchbox.devicescore.dynamic;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aideviceperformanceboxproxy.dynamic.LaunchSpeedScoreManagerSingleton;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.devicescore.IDeviceScore;
import com.baidu.searchbox.devicescore.ParamKeys;
import com.baidu.searchbox.devicescore.ScoreMetaData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes2.dex */
public class LaunchSpeedManager implements IDynamicScoreManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "LaunchSpeedManager";
    public transient /* synthetic */ FieldHolder $fh;
    public float mScore;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-565822747, "Lcom/baidu/searchbox/devicescore/dynamic/LaunchSpeedManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-565822747, "Lcom/baidu/searchbox/devicescore/dynamic/LaunchSpeedManager;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public LaunchSpeedManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mScore = -1.0f;
    }

    @Override // com.baidu.searchbox.devicescore.dynamic.IDynamicScoreManager
    public float getScore(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            float f = this.mScore;
            if (f >= 0.0f) {
                return f;
            }
            float launchSpeedScore = LaunchSpeedScoreManagerSingleton.getInstance().getLaunchSpeedScore();
            this.mScore = launchSpeedScore;
            if (Float.compare(launchSpeedScore, 0.0f) >= 0) {
                if (DEBUG) {
                    Log.d(TAG, "getScore: " + this.mScore);
                }
                return this.mScore;
            }
            return -1.0f;
        }
        return invokeL.floatValue;
    }

    @Override // com.baidu.searchbox.devicescore.dynamic.IDynamicScoreManager
    public void putMetaData(Context context, ScoreMetaData scoreMetaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, scoreMetaData) == null) && validMetaData(context, scoreMetaData)) {
            LaunchSpeedScoreManagerSingleton.getInstance().putLaunchSpeedData(context, ((Long) scoreMetaData.params.get(ParamKeys.KEY_LAUNCH_SPEED_LAUNCH_TS)).longValue(), System.currentTimeMillis());
        }
    }

    @Override // com.baidu.searchbox.devicescore.dynamic.IDynamicScoreManager
    public boolean validMetaData(Context context, ScoreMetaData scoreMetaData) {
        InterceptResult invokeLL;
        Map<String, Object> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, scoreMetaData)) == null) {
            if (scoreMetaData == null || !IDeviceScore.TYPE_LAUNCH_SPEED.equals(scoreMetaData.type) || (map = scoreMetaData.params) == null) {
                return false;
            }
            return map.keySet().contains(ParamKeys.KEY_LAUNCH_SPEED_LAUNCH_TS);
        }
        return invokeLL.booleanValue;
    }
}
