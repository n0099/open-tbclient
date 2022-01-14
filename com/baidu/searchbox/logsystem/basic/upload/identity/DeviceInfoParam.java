package com.baidu.searchbox.logsystem.basic.upload.identity;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
/* loaded from: classes11.dex */
public class DeviceInfoParam {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mDeviceInfo;
    public String mEnDeviceInfo;
    public String mManufacturer;
    public String mModel;
    public String mOSVersion;

    public DeviceInfoParam() {
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

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            String str = Build.MODEL;
            this.mModel = str;
            if (TextUtils.isEmpty(str)) {
                this.mModel = "NUL";
            } else {
                this.mModel = this.mModel.replace("_", "-");
            }
            String str2 = Build.MANUFACTURER;
            this.mManufacturer = str2;
            if (TextUtils.isEmpty(str2)) {
                this.mManufacturer = "NUL";
            } else {
                this.mManufacturer = this.mManufacturer.replace("_", "-");
            }
            String str3 = Build.VERSION.RELEASE;
            this.mOSVersion = str3;
            if (TextUtils.isEmpty(str3)) {
                this.mOSVersion = "0.0";
            } else {
                this.mOSVersion = this.mOSVersion.replace("_", "-");
            }
            this.mDeviceInfo = initDeviceInfo();
        }
    }

    private String initDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            String str = this.mModel;
            String str2 = this.mOSVersion;
            int i2 = Build.VERSION.SDK_INT;
            String str3 = this.mManufacturer;
            return str + "_" + str2 + "_" + i2 + "_" + str3;
        }
        return (String) invokeV.objValue;
    }

    private void initEnDeviceInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mEnDeviceInfo = new String(Base64Encoder.B64Encode(this.mDeviceInfo.getBytes()));
        }
    }

    public String getDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDeviceInfo : (String) invokeV.objValue;
    }

    public String getEnDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.mEnDeviceInfo)) {
                initEnDeviceInfo();
            }
            return this.mEnDeviceInfo;
        }
        return (String) invokeV.objValue;
    }

    public String getManufacturer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mManufacturer : (String) invokeV.objValue;
    }

    public String getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mModel : (String) invokeV.objValue;
    }

    public String getOSVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mOSVersion : (String) invokeV.objValue;
    }
}
