package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
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

    /* JADX INFO: Access modifiers changed from: protected */
    public String calculateSig(Map<String, String> map, String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : map.keySet()) {
            arrayList.add(str2);
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            sb.append(str3);
            sb.append("=");
            try {
                String str4 = map.get(str3);
                if (!TextUtils.isEmpty(str4)) {
                    sb.append(URLEncoder.encode(str4, HTTP.UTF_8));
                }
            } catch (UnsupportedEncodingException e) {
                Log.e(e);
            }
            sb.append("&");
        }
        sb.append("sign_key=").append(str);
        return MD5Util.toMd5(sb.toString().getBytes(), false);
    }
}
