package com.baidu.swan.apps.q.a.b.a;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.a.g;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e extends com.baidu.swan.apps.setting.oauth.a.e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String mStoken;

    public e(Activity activity, g.a aVar, Bundle bundle) {
        super(activity, aVar, bundle);
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.e
    @NonNull
    protected com.baidu.swan.apps.setting.oauth.d Cg() {
        return new a();
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.e, com.baidu.swan.apps.setting.oauth.b
    protected boolean Cd() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Jl().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", Jl().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject2.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            String vC = com.baidu.swan.apps.u.a.CI().vC();
            if (!TextUtils.isEmpty(vC)) {
                jSONObject2.put("host_api_key", vC);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ay("data", jSONObject.toString());
        return true;
    }

    /* loaded from: classes4.dex */
    private class a extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean Cf() throws Exception {
            boolean bH = com.baidu.swan.apps.u.a.CB().bH(e.this.mActivity);
            if (e.DEBUG) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + bH + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!bH) {
                e.this.Jl().Ja().a(e.this.mActivity, e.this.aRJ, this);
                return false;
            }
            e.this.a(new b());
            return true;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            com.baidu.swan.apps.setting.oauth.c.a("onResult :: " + i, (Boolean) false);
            switch (i) {
                case -2:
                    com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_UESR_REFUSE", (Boolean) true);
                    m(new OAuthException("login cancel by user", 10004));
                    return;
                case -1:
                default:
                    com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_LOGIN", (Boolean) true);
                    m(new OAuthException("system login error", 10004));
                    return;
                case 0:
                    com.baidu.swan.apps.setting.oauth.c.a("Login Preparation ok, is already login", (Boolean) false);
                    e.this.a(new b());
                    Ke();
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends com.baidu.swan.apps.setting.oauth.d {
        private b() {
            if (e.this.aRI != null && e.this.aRH != null && e.this.aRH.aRa) {
                long j = e.this.aRH.aRb;
                if (e.DEBUG) {
                    Log.d("LoginRequest", "send timeout " + j + "ms msg");
                }
                e.this.aRI.sendEmptyMessageDelayed(1, j >= 0 ? j : 0L);
            }
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean Cf() throws Exception {
            com.baidu.tieba.aiapps.apps.a.a.a(e.this.mActivity, new com.baidu.swan.apps.an.c.a<Bundle>() { // from class: com.baidu.swan.apps.q.a.b.a.e.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: o */
                public void D(Bundle bundle) {
                    if (bundle == null) {
                        b.this.m(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        e.this.mStoken = string;
                        b.this.Ke();
                        return;
                    }
                    b.this.m(new OAuthException("empty stoken", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
