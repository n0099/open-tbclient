package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends g<d> {
    protected com.baidu.swan.apps.setting.oauth.e bmM;
    protected boolean boA = false;
    protected final boolean boB;
    protected boolean box;
    protected final Activity mActivity;
    protected final String mScope;

    public b(Activity activity, boolean z, String str, boolean z2) {
        this.mActivity = activity;
        this.mScope = str;
        this.box = z;
        this.boB = z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    public boolean IL() {
        a(new C0223b());
        return super.IL();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean IM() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Rq().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", Rq().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
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
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.u.a.Ju().f(this.mActivity, gVar.Ss());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: Y */
    public d X(JSONObject jSONObject) throws JSONException {
        JSONObject aD = com.baidu.swan.apps.setting.oauth.c.aD(jSONObject);
        int optInt = aD.optInt("errno", 11001);
        if (optInt != 0) {
            if (11001 == optInt) {
                com.baidu.swan.apps.setting.oauth.c.aC(aD);
                com.baidu.swan.apps.setting.oauth.c.aH("Authorize", aD.toString());
            }
            throw new JSONException("Illegal errno=" + optInt + " errms=" + aD.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = aD.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.box, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void IN() {
        super.IN();
        com.baidu.swan.apps.network.c.b.a.MZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0223b extends com.baidu.swan.apps.setting.oauth.d {
        private C0223b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean IO() throws Exception {
            com.baidu.swan.apps.network.c.b.a.a(b.this.mScope, new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: c */
                public void B(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.bmM = eVar;
                    if (eVar == null) {
                        C0223b.this.m(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.Sq() && !b.this.boA) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0223b.this.Sn();
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private c() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean IO() throws Exception {
            b.this.boA = true;
            if (b.this.Rq().Re().isLogin(b.this.mActivity)) {
                com.baidu.swan.apps.setting.oauth.c.a("LoginPreparation: isLogin true", (Boolean) false);
                b.this.a(new C0223b());
                return true;
            }
            b.this.Rq().Re().a(b.this.mActivity, null, this);
            return false;
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
                    b.this.a(new C0223b());
                    Sn();
                    return;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean IO() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.bmM;
            if (eVar == null || eVar.forbidden) {
                b.this.l(new OAuthException("Illegal ScopeInfo", eVar == null ? 10006 : 10005));
                return true;
            } else if (b.this.boB || !b.this.box) {
                return true;
            } else {
                if (eVar.bou < 0) {
                    b.this.H(new d(false, null));
                    b.this.finish();
                    return true;
                } else if (eVar.bou > 0) {
                    b.this.H(new d(true, null));
                    b.this.finish();
                    return true;
                } else {
                    com.baidu.swan.apps.setting.oauth.c.e(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.setting.oauth.c.a(b.this.mActivity, b.this.Rq(), eVar, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    b.this.box = z;
                                    a.this.Sn();
                                }
                            });
                        }
                    });
                    return false;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {
        public final boolean boy;
        public final String code;

        private d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.boy = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.boy), this.code);
        }
    }
}
