package com.baidu.sapi2.result;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class OpenBdussResult extends SapiResult implements NoProguard {
    public static final int ERROR_CODE_NOT_LOGIN = -901;
    public static final String ERROR_MSG_NOT_LOGIN = "未登录";
    private static final String PARAMS_BDUSS = "bduss";
    private static final String PARAMS_DISPLAYNAME = "displayname";
    private static final String PARAMS_ERRMSG = "errmsg";
    private static final String PARAMS_ERRNO = "errno";
    private static final String PARAMS_FLAG = "flag";
    private static final String PARAMS_OPEN_BDUSS = "openbduss";
    private static final String PARAMS_TPL_STOKEN_MAP = "stoken_list";
    private static final String PARAMS_UID = "uid";
    private static final String PARAMS_UNIONID = "unionid";
    public String bduss;
    public String displayname;
    public String openBduss;
    public String uid;
    public String unionid;
    public String flag = "";
    public Map<String, String> tplStokenMap = new HashMap();

    public OpenBdussResult() {
        this.msgMap.put(-901, "未登录");
    }

    public JSONObject toJson() {
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
                jSONObject.put(PARAMS_TPL_STOKEN_MAP, jSONObject2);
            }
        } catch (JSONException e) {
            Log.e(e);
        }
        return jSONObject;
    }

    public static OpenBdussResult fromJson(String str) {
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
            JSONObject optJSONObject = jSONObject.optJSONObject(PARAMS_TPL_STOKEN_MAP);
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
}
