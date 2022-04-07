package com.baidu.sapi2.result;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OpenBdussResult extends SapiResult implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_NOT_LOGIN = -901;
    public static final String ERROR_MSG_NOT_LOGIN = "未登录";
    public static final String PARAMS_BDUSS = "bduss";
    public static final String PARAMS_DISPLAYNAME = "displayname";
    public static final String PARAMS_ERRMSG = "errmsg";
    public static final String PARAMS_ERRNO = "errno";
    public static final String PARAMS_FLAG = "flag";
    public static final String PARAMS_OPEN_BDUSS = "openbduss";
    public static final String PARAMS_TPL_STOKEN_MAP = "stoken_list";
    public static final String PARAMS_UID = "uid";
    public static final String PARAMS_UNIONID = "unionid";
    public transient /* synthetic */ FieldHolder $fh;
    public String bduss;
    public String displayname;
    public String flag;
    public String openBduss;
    public Map<String, String> tplStokenMap;
    public String uid;
    public String unionid;

    public OpenBdussResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.flag = "";
        this.tplStokenMap = new HashMap();
        this.msgMap.put(-901, "未登录");
    }

    public static OpenBdussResult fromJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                OpenBdussResult openBdussResult = new OpenBdussResult();
                openBdussResult.setResultCode(jSONObject.optInt("errno"));
                openBdussResult.setResultMsg(jSONObject.optString("errmsg"));
                openBdussResult.flag = jSONObject.optString("flag");
                openBdussResult.uid = jSONObject.optString("uid");
                openBdussResult.bduss = jSONObject.optString("bduss");
                openBdussResult.unionid = jSONObject.optString("unionid");
                openBdussResult.displayname = jSONObject.optString("displayname");
                openBdussResult.openBduss = jSONObject.optString(PARAMS_OPEN_BDUSS);
                JSONObject optJSONObject = jSONObject.optJSONObject("stoken_list");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String optString = optJSONObject.optString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                            openBdussResult.tplStokenMap.put(next, optString);
                        }
                    }
                }
                return openBdussResult;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
        return (OpenBdussResult) invokeL.objValue;
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", getResultCode());
                jSONObject.put("errmsg", getResultMsg());
                jSONObject.put("flag", this.flag);
                jSONObject.put("uid", this.uid);
                jSONObject.put("bduss", this.bduss);
                jSONObject.put("unionid", this.unionid);
                jSONObject.put("displayname", this.displayname);
                jSONObject.put(PARAMS_OPEN_BDUSS, this.openBduss);
                if (this.tplStokenMap != null && this.tplStokenMap.size() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, String> entry : this.tplStokenMap.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject.put("stoken_list", jSONObject2);
                }
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
