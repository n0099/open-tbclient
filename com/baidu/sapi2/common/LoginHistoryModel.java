package com.baidu.sapi2.common;

import com.baidu.sapi2.NoProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.IWalletLoginListener;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LoginHistoryModel implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String bduss;
    public String displayname;
    public String loginType;
    public String portrait;
    public String portraitSign;
    public boolean recent;
    public String uid;
    public String username;

    public LoginHistoryModel() {
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

    public static LoginHistoryModel fromJSONObject(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            LoginHistoryModel loginHistoryModel = new LoginHistoryModel();
            loginHistoryModel.uid = jSONObject.optString("uid");
            loginHistoryModel.displayname = jSONObject.optString("displayname");
            loginHistoryModel.username = jSONObject.optString("username");
            loginHistoryModel.portrait = jSONObject.optString("portrait");
            loginHistoryModel.portraitSign = jSONObject.optString("portraitSign");
            loginHistoryModel.recent = jSONObject.optBoolean("recent");
            loginHistoryModel.loginType = jSONObject.optString(IWalletLoginListener.KEY_LOGIN_TYPE);
            loginHistoryModel.bduss = jSONObject.optString("bduss");
            return loginHistoryModel;
        }
        return (LoginHistoryModel) invokeL.objValue;
    }
}
