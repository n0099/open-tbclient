package com.baidu.swan.apps.q.a.b.a;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends com.baidu.swan.apps.setting.oauth.a.b {
    private String mStoken;

    public b(Activity activity, boolean z, String str, boolean z2) {
        super(activity, z, str, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.b
    public boolean DN() {
        if (Mu().Mi().aD(this.mActivity)) {
            Log.e("aiapps-oauth", "StokenPreparation: ");
            a(new c());
            return true;
        }
        Log.e("aiapps-oauth", "ListPreparation: ");
        a(new a());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.b
    protected boolean DO() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Mu().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", Mu().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject2.put("stoken", this.mStoken);
            String wS = com.baidu.swan.apps.u.a.Ew().wS();
            if (!TextUtils.isEmpty(wS)) {
                jSONObject2.put("host_api_key", wS);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.aUV));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aA("data", jSONObject.toString());
        if (this.aUV) {
            Nz();
            return true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.b
    /* renamed from: A */
    public b.d z(JSONObject jSONObject) throws JSONException {
        com.baidu.tieba.aiapps.apps.a.c.b(this.mActivity, jSONObject);
        return super.z(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.a.g
    public void DP() {
        super.DP();
        com.baidu.swan.apps.network.c.b.a.Ib();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean DQ() throws Exception {
            com.baidu.swan.apps.network.c.b.a.a(b.this.mScope, new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.q.a.b.a.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: c */
                public void D(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    Log.e("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    b.this.aTj = eVar;
                    if (eVar == null) {
                        a.this.m(new Exception("no such scope"));
                        return;
                    }
                    Log.e("aiapps-oauth", "isUidScope: " + eVar.Nw() + "mFlagTryLogin:" + b.this.aUY);
                    if (eVar.Nw() && !b.this.aUY) {
                        b.this.a(new C0160b());
                    } else {
                        b.this.a(new b.a());
                    }
                    a.this.Nt();
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.q.a.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0160b extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private C0160b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean DQ() throws Exception {
            b.this.aUY = true;
            if (!b.this.Mu().Mi().aD(b.this.mActivity)) {
                b.this.Mu().Mi().a(b.this.mActivity, null, this);
                return false;
            }
            com.baidu.swan.apps.setting.oauth.c.a("LoginPreparation: isLogin true", (Boolean) false);
            Log.e("yyb", "LoginPreparation: isLogin true");
            b.this.a(new c());
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
                    b.this.a(new c());
                    Nt();
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends com.baidu.swan.apps.setting.oauth.d {
        private c() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean DQ() throws Exception {
            Log.e("aiapps-oauth", "getstoken: ");
            com.baidu.tieba.aiapps.apps.a.c.a(b.this.mActivity, new com.baidu.swan.apps.an.d.a<Bundle>() { // from class: com.baidu.swan.apps.q.a.b.a.b.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: o */
                public void D(Bundle bundle) {
                    if (bundle == null) {
                        c.this.m(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        b.this.mStoken = string;
                        b.this.a(new a());
                        c.this.Nt();
                        return;
                    }
                    c.this.m(new OAuthException("empty stoken", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
