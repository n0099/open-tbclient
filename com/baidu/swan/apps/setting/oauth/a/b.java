package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends g<d> {
    protected boolean aRs;
    protected boolean aRv = false;
    protected com.baidu.swan.apps.setting.oauth.e aRw;
    protected final boolean aRx;
    protected final Activity mActivity;
    protected final String mScope;

    public b(Activity activity, boolean z, String str, boolean z2) {
        this.mActivity = activity;
        this.mScope = str;
        this.aRs = z;
        this.aRx = z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    public boolean Ce() {
        a(new C0173b());
        return super.Ce();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean Cf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Jn().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", Jn().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String vD = com.baidu.swan.apps.u.a.CK().vD();
            if (!TextUtils.isEmpty(vD)) {
                jSONObject2.put("host_api_key", vD);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.aRs));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ay("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.u.a.CK().f(this.mActivity, gVar.Kl());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: D */
    public d C(JSONObject jSONObject) throws JSONException {
        JSONObject ae = com.baidu.swan.apps.setting.oauth.c.ae(jSONObject);
        int optInt = ae.optInt("errno", SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + ae.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = ae.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.aRs, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void Cg() {
        super.Cg();
        com.baidu.swan.apps.network.c.b.a.Fm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0173b extends com.baidu.swan.apps.setting.oauth.d {
        private C0173b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean Ch() throws Exception {
            com.baidu.swan.apps.network.c.b.a.a(b.this.mScope, new com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: c */
                public void D(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.aRw = eVar;
                    if (eVar == null) {
                        C0173b.this.m(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.Kj() && !b.this.aRv) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0173b.this.Kg();
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
        protected boolean Ch() throws Exception {
            b.this.aRv = true;
            if (b.this.Jn().Jc().bk(b.this.mActivity)) {
                com.baidu.swan.apps.setting.oauth.c.a("LoginPreparation: isLogin true", (Boolean) false);
                b.this.a(new C0173b());
                return true;
            }
            b.this.Jn().Jc().a(b.this.mActivity, null, this);
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
                    b.this.a(new C0173b());
                    Kg();
                    return;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean Ch() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.aRw;
            if (eVar == null || eVar.forbidden) {
                b.this.l(new OAuthException("Illegal ScopeInfo", eVar == null ? 10006 : 10005));
                return true;
            } else if (b.this.aRx || !b.this.aRs) {
                return true;
            } else {
                if (eVar.aRp < 0) {
                    b.this.J(new d(false, null));
                    b.this.finish();
                    return true;
                } else if (eVar.aRp > 0) {
                    b.this.J(new d(true, null));
                    b.this.finish();
                    return true;
                } else {
                    com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.setting.oauth.c.a(b.this.mActivity, b.this.Jn(), eVar, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void bt(boolean z) {
                                    b.this.aRs = z;
                                    a.this.Kg();
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
        public final boolean aRt;
        public final String code;

        private d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.aRt = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.aRt), this.code);
        }
    }
}
