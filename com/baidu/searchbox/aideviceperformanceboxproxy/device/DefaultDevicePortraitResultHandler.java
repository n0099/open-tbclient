package com.baidu.searchbox.aideviceperformanceboxproxy.device;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler;
import com.baidu.searchbox.aideviceperformance.utils.DeviceInfoSharedPreferenceWrapper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class DefaultDevicePortraitResultHandler implements IDevicePortraitResultHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SP_KEY_STATIC_SCORE = "static_predict_score";
    public static final String SP_KEY_STATIC_SCORE_PERCENTAGE = "static_score_percent";
    public transient /* synthetic */ FieldHolder $fh;

    public DefaultDevicePortraitResultHandler() {
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

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler
    public float getStaticPredictScore(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? DeviceInfoSharedPreferenceWrapper.getInstance().getFloat(SP_KEY_STATIC_SCORE, -1.0f) : invokeF.floatValue;
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler
    public float getStaticScorePercent(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) ? DeviceInfoSharedPreferenceWrapper.getInstance().getFloat(SP_KEY_STATIC_SCORE_PERCENTAGE, -1.0f) : invokeF.floatValue;
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler
    public void putStaticPredictScore(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            DeviceInfoSharedPreferenceWrapper.getInstance().putFloat(SP_KEY_STATIC_SCORE, f2);
        }
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler
    public void putStaticScorePercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            DeviceInfoSharedPreferenceWrapper.getInstance().putFloat(SP_KEY_STATIC_SCORE_PERCENTAGE, f2);
        }
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler
    public void removeStaticPredictScore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            DeviceInfoSharedPreferenceWrapper.getInstance().remove(SP_KEY_STATIC_SCORE);
        }
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler
    public void removeStaticScorePercent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            DeviceInfoSharedPreferenceWrapper.getInstance().remove(SP_KEY_STATIC_SCORE_PERCENTAGE);
        }
    }
}
