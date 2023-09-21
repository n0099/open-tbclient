package com.baidu.tbadk;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class RobotMallConfig {
    public static /* synthetic */ Interceptable $ic;
    public static final RobotMallConfig DEFAULT;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean isVaild;
    public String mAiChatEntranceImage;
    public String mAiChatEntranceUrl;
    public String mDefaultConf;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-754363810, "Lcom/baidu/tbadk/RobotMallConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-754363810, "Lcom/baidu/tbadk/RobotMallConfig;");
                return;
            }
        }
        DEFAULT = new RobotMallConfig(false);
    }

    public String getAiChatEntranceImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAiChatEntranceImage;
        }
        return (String) invokeV.objValue;
    }

    public String getAiChatEntranceUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mAiChatEntranceUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getDefaultConf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mDefaultConf;
        }
        return (String) invokeV.objValue;
    }

    public boolean isVaild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.isVaild;
        }
        return invokeV.booleanValue;
    }

    public RobotMallConfig(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isVaild = z;
    }

    @NonNull
    public static RobotMallConfig parseJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return DEFAULT;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("cloud_control_data_info");
            if (optJSONObject == null) {
                return DEFAULT;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("common_config");
            if (optJSONObject2 == null) {
                return DEFAULT;
            }
            RobotMallConfig robotMallConfig = new RobotMallConfig(true);
            robotMallConfig.dealConfigJson(optJSONObject2);
            return robotMallConfig;
        }
        return (RobotMallConfig) invokeL.objValue;
    }

    private void dealConfigJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, jSONObject) == null) {
            this.mDefaultConf = jSONObject.optString("default_conf");
            this.mAiChatEntranceImage = jSONObject.optString("aichat_entrance_img");
            this.mAiChatEntranceUrl = jSONObject.optString("aichat_entrance_url");
        }
    }
}
