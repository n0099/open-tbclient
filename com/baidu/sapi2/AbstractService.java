package com.baidu.sapi2;

import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class AbstractService {
    protected SapiConfiguration configuration;
    protected String versionName;

    public AbstractService(SapiConfiguration sapiConfiguration, String str) {
        this.configuration = sapiConfiguration;
        this.versionName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getErrorCode(String str) {
        try {
            return new JSONObject(str).getInt("errno");
        } catch (Exception e) {
            Log.e(e);
            return -100;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getErrorMsg(String str) {
        try {
            return new JSONObject(str).optString("errmsg");
        } catch (Exception e) {
            Log.e(e);
            return SapiResult.ERROR_MSG_UNKNOWN;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SapiAccount parseAccount(JSONObject jSONObject) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = jSONObject.optString("uid");
        sapiAccount.bduss = jSONObject.optString("bduss");
        sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
        sapiAccount.username = jSONObject.optString("uname");
        sapiAccount.stoken = jSONObject.optString("stoken");
        sapiAccount.ptoken = jSONObject.optString("ptoken");
        sapiAccount.extra = jSONObject.toString();
        sapiAccount.app = SapiUtils.getAppName(this.configuration.context);
        return sapiAccount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getUaInfo() {
        return "tpl:" + this.configuration.tpl + ";android_sapi_v" + this.versionName;
    }

    protected void cancelRequest(HttpClientWrap httpClientWrap) {
        if (httpClientWrap != null) {
            httpClientWrap.cancelRequest();
        }
    }
}
