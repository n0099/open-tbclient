package com.baidu.sapi2.common;

import com.baidu.mobstat.Config;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.SyncAccountUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            loginHistoryModel.portraitSign = jSONObject.optString(SyncAccountUtils.KEY_PORTRAIT_SIGN);
            loginHistoryModel.recent = jSONObject.optBoolean(Config.TRACE_VISIT_RECENT);
            loginHistoryModel.loginType = jSONObject.optString("loginType");
            loginHistoryModel.bduss = jSONObject.optString("bduss");
            return loginHistoryModel;
        }
        return (LoginHistoryModel) invokeL.objValue;
    }
}
