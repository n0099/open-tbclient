package com.baidu.sapi2;

import android.content.Context;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class AbstractService {
    protected AsyncHttpClient asyncHttpClient;
    protected SapiConfiguration configuration;
    protected DomainRetry domainRetry;
    protected String versionName;

    public AbstractService(SapiConfiguration sapiConfiguration, String str) {
        this.configuration = sapiConfiguration;
        this.domainRetry = new DomainRetry(sapiConfiguration);
        this.versionName = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class DomainRetry {
        static List<String> c = new ArrayList();
        static int d;
        SapiConfiguration a;
        Context b;

        private void a() {
            c.clear();
            c.add(SapiEnv.PASS_RETRY_IP1);
            c.add(SapiEnv.PASS_RETRY_IP2);
            c.add(SapiEnv.PASS_RETRY_IP3);
        }

        public DomainRetry(SapiConfiguration sapiConfiguration) {
            this.a = sapiConfiguration;
            reset();
            a();
        }

        public String getDomain() {
            String url = this.a.environment.getURL(SapiUtils.getDefaultHttpsEnabled());
            if (d > 0) {
                if (d > c.size()) {
                    d = 1;
                }
                return c.get(d - 1);
            }
            return url;
        }

        public void retry() {
            d++;
        }

        public boolean isShouldRetry() {
            return !isReachMaxTried() && (SapiContext.getInstance(this.b).isHostsHijacked() || !SapiUtils.getDefaultHttpsEnabled());
        }

        public boolean isReachMaxTried() {
            return d >= c.size();
        }

        public void reset() {
            d = 0;
        }
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
        sapiAccount.displayname = jSONObject.optString("displayname");
        sapiAccount.username = jSONObject.optString("uname");
        sapiAccount.stoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_STOKEN);
        sapiAccount.ptoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PTOKEN);
        sapiAccount.extra = jSONObject.toString();
        sapiAccount.app = SapiUtils.getAppName(this.configuration.context);
        return sapiAccount;
    }

    SapiAccount a(SapiAccountResponse sapiAccountResponse) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = SapiUtils.getAppName(this.configuration.context);
        return sapiAccount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getUaInfo() {
        return "tpl:" + this.configuration.tpl + ";android_sapi_v" + this.versionName;
    }

    public void cancelRequest() {
        if (this.asyncHttpClient != null) {
            this.asyncHttpClient.cancelRequests(this.configuration.context, true);
        }
    }
}
