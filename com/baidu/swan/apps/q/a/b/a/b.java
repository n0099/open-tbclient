package com.baidu.swan.apps.q.a.b.a;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
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
    public boolean Cc() {
        if (Jl().Ja().bk(this.mActivity)) {
            a(new c());
            return true;
        }
        a(new a());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.b
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
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.aRv));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ay("data", jSONObject.toString());
        if (this.aRv) {
            Kk();
            return true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.b
    /* renamed from: D */
    public b.d C(JSONObject jSONObject) throws JSONException {
        com.baidu.tieba.aiapps.apps.a.a.a(this.mActivity, jSONObject);
        return super.C(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.a.g
    public void Ce() {
        super.Ce();
        com.baidu.swan.apps.network.c.b.a.Fk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean Cf() throws Exception {
            com.baidu.swan.apps.network.c.b.a.a(b.this.mScope, new com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.q.a.b.a.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: c */
                public void D(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.aRz = eVar;
                    if (eVar == null) {
                        a.this.m(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.Kh() && !b.this.aRy) {
                        b.this.a(new C0157b());
                    } else {
                        b.this.a(new b.a());
                    }
                    a.this.Ke();
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.q.a.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0157b extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private C0157b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean Cf() throws Exception {
            b.this.aRy = true;
            if (!b.this.Jl().Ja().bk(b.this.mActivity)) {
                b.this.Jl().Ja().a(b.this.mActivity, null, this);
                return false;
            }
            com.baidu.swan.apps.setting.oauth.c.a("LoginPreparation: isLogin true", (Boolean) false);
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
                    Ke();
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
        protected boolean Cf() throws Exception {
            com.baidu.tieba.aiapps.apps.a.a.a(b.this.mActivity, new com.baidu.swan.apps.an.c.a<Bundle>() { // from class: com.baidu.swan.apps.q.a.b.a.b.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
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
                        c.this.Ke();
                        return;
                    }
                    c.this.m(new OAuthException("empty stoken", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
