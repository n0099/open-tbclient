package com.baidu.tbadk.browser.auth;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AuthHttpResponseMsg extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject data;
    public String errorCode;
    public String errorMessage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthHttpResponseMsg() {
        super(CmdConfigHttp.CMD_GET_ALI_AUTH_INFO);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public JSONObject getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.data;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.errorCode;
        }
        return (String) invokeV.objValue;
    }

    public String getErrorMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.errorMessage;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            if (!hasError() && jSONObject != null) {
                this.errorCode = jSONObject.optString("error_code", "0");
                this.errorMessage = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    this.data = optJSONObject;
                    if (optJSONObject != null) {
                        str2 = optJSONObject.getString("user_id");
                    } else {
                        str2 = null;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        this.data = null;
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    this.data = null;
                    return;
                }
            }
            if (getErrorString() != null) {
                str = getErrorString();
            } else {
                str = "100000";
            }
            this.errorCode = str;
            this.errorMessage = "网络请求失败(" + getStatusCode() + SmallTailInfo.EMOTION_SUFFIX;
            this.data = null;
        }
    }
}
