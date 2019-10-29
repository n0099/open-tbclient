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
    public boolean IL() {
        if (Rq().Re().isLogin(this.mActivity)) {
            Log.e("aiapps-oauth", "StokenPreparation: ");
            a(new c());
            return true;
        }
        Log.e("aiapps-oauth", "ListPreparation: ");
        a(new a());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.b
    protected boolean IM() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Rq().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", Rq().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject2.put("stoken", this.mStoken);
            String BQ = com.baidu.swan.apps.u.a.Ju().BQ();
            if (!TextUtils.isEmpty(BQ)) {
                jSONObject2.put("host_api_key", BQ);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.box));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aI("data", jSONObject.toString());
        if (this.box) {
            St();
            return true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.b
    /* renamed from: Y */
    public b.d X(JSONObject jSONObject) throws JSONException {
        com.baidu.tieba.aiapps.apps.a.c.b(this.mActivity, jSONObject);
        return super.X(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.a.g
    public void IN() {
        super.IN();
        com.baidu.swan.apps.network.c.b.a.MZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean IO() throws Exception {
            com.baidu.swan.apps.network.c.b.a.a(b.this.mScope, new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.q.a.b.a.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: c */
                public void B(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    Log.e("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    b.this.bmM = eVar;
                    if (eVar == null) {
                        a.this.m(new Exception("no such scope"));
                        return;
                    }
                    Log.e("aiapps-oauth", "isUidScope: " + eVar.Sq() + "mFlagTryLogin:" + b.this.boA);
                    if (eVar.Sq() && !b.this.boA) {
                        b.this.a(new C0206b());
                    } else {
                        b.this.a(new b.a());
                    }
                    a.this.Sn();
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.q.a.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0206b extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private C0206b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean IO() throws Exception {
            b.this.boA = true;
            if (!b.this.Rq().Re().isLogin(b.this.mActivity)) {
                b.this.Rq().Re().a(b.this.mActivity, null, this);
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
                    Sn();
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
        protected boolean IO() throws Exception {
            Log.e("aiapps-oauth", "getstoken: ");
            com.baidu.tieba.aiapps.apps.a.c.a(b.this.mActivity, new com.baidu.swan.apps.an.d.a<Bundle>() { // from class: com.baidu.swan.apps.q.a.b.a.b.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: o */
                public void B(Bundle bundle) {
                    if (bundle == null) {
                        c.this.m(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        b.this.mStoken = string;
                        b.this.a(new a());
                        c.this.Sn();
                        return;
                    }
                    c.this.m(new OAuthException("empty stoken", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
