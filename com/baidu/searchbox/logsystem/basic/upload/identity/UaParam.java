package com.baidu.searchbox.logsystem.basic.upload.identity;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
/* loaded from: classes11.dex */
public class UaParam {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mEnUa;
    public String mUa;
    public String mVersionName;

    public UaParam() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init();
    }

    private String getUA(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, context)) == null) {
            int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(context);
            int displayHeight = DeviceUtil.ScreenInfo.getDisplayHeight(context);
            int densityDpi = DeviceUtil.ScreenInfo.getDensityDpi(context);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(displayWidth);
            stringBuffer.append("_");
            stringBuffer.append(displayHeight);
            stringBuffer.append("_");
            stringBuffer.append("android");
            stringBuffer.append("_");
            stringBuffer.append(this.mVersionName);
            stringBuffer.append("_");
            stringBuffer.append(densityDpi);
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Context appContext = AppRuntime.getAppContext();
            this.mVersionName = CommonUtils.getAppVersion();
            this.mUa = getUA(appContext);
        }
    }

    private void initEnUA() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mEnUa = new String(Base64Encoder.B64Encode(this.mUa.getBytes()));
        }
    }

    public String getEnUA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.mEnUa)) {
                initEnUA();
            }
            return this.mEnUa;
        }
        return (String) invokeV.objValue;
    }

    public String getUA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mUa : (String) invokeV.objValue;
    }
}
