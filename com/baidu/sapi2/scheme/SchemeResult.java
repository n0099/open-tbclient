package com.baidu.sapi2.scheme;

import com.baidu.sapi2.result.SapiResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SchemeResult extends SapiResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_SC_PACKAGE_SIGN_ERROR = -604;
    public static final int ERROR_CODE_SYSTEM_ERROR = -603;
    public static final String ERROR_MSG_SC_PACKAGE_SIGN_ERROR = "验证失败，检测到当前百度安全中心App存在风险，请于官方渠道下载后重试";
    public static final String ERROR_MSG_SYSTEM_ERROR = "系统错误，请稍后再试";
    public transient /* synthetic */ FieldHolder $fh;

    public SchemeResult() {
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
        this.msgMap.put(ERROR_CODE_SYSTEM_ERROR, ERROR_MSG_SYSTEM_ERROR);
        this.msgMap.put(ERROR_CODE_SC_PACKAGE_SIGN_ERROR, ERROR_MSG_SC_PACKAGE_SIGN_ERROR);
    }

    public String toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", getResultCode());
                jSONObject.put("errmsg", getResultMsg());
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
