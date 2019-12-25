package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends g<d> {
    protected com.baidu.swan.apps.setting.oauth.e bMV;
    protected boolean bOZ;
    protected final String bPa;
    @NonNull
    protected final String[] bPc;
    protected boolean bPd;
    protected final boolean bPf;
    protected final Context mContext;
    protected boolean bPe = false;
    private boolean bPg = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.bPd = z;
        this.bPc = strArr == null ? new String[0] : strArr;
        this.bPa = str;
        this.bOZ = z2;
        this.bPf = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean abs() {
        a(new C0284b());
        return super.abs();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean abt() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aao().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aao().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String Fp = com.baidu.swan.apps.w.a.Rw().Fp();
            if (!TextUtils.isEmpty(Fp)) {
                jSONObject2.put("host_api_key", Fp);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.bPc) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.bOZ));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.bPa)) {
                jSONObject.put("provider_appkey", this.bPa);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        bb("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.w.a.Rw().f(this.mContext, gVar.abO());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: aT */
    public d aN(JSONObject jSONObject) throws JSONException {
        JSONObject aP = com.baidu.swan.apps.setting.oauth.c.aP(jSONObject);
        int optInt = aP.optInt("errno", 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + aP.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = aP.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.bOZ, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void abL() {
        super.abL();
        if (this.bPg) {
            k(new OAuthException(10003));
            this.bPg = false;
        }
        if (TextUtils.isEmpty(this.bPa)) {
            com.baidu.swan.apps.network.c.b.a.Wz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0284b extends com.baidu.swan.apps.setting.oauth.d {
        private C0284b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aby() throws Exception {
            if (b.this.bPc == null || b.this.bPc.length > 1) {
                abA();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.a(b.this.bPc[0], new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: c */
                public void B(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.bMV = eVar;
                    if (eVar == null) {
                        C0284b.this.l(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.abD() && !b.this.bPe) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0284b.this.abA();
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private c() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aby() throws Exception {
            b.this.bPe = true;
            if (b.this.aao().aad().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0284b());
                return true;
            }
            com.baidu.swan.apps.runtime.e aao = b.this.aao();
            if (aao.GS()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                l(new OAuthException(10004));
                return true;
            } else if (!(b.this.mContext instanceof Activity)) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                l(new OAuthException(10004));
                return true;
            } else {
                aao.aad().a((Activity) b.this.mContext, null, this);
                return false;
            }
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
            switch (i) {
                case -2:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                    l(new OAuthException(10004));
                    return;
                case -1:
                default:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                    l(new OAuthException(10004));
                    return;
                case 0:
                    com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                    b.this.a(new C0284b());
                    abA();
                    return;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aby() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.bMV;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.k(new OAuthException(10001));
                return true;
            } else if (eVar.forbidden) {
                b.this.k(new OAuthException(10005));
                return true;
            } else if (b.this.bPf || !b.this.bOZ) {
                return true;
            } else {
                if (!b.this.bPd && eVar.bOA < 0) {
                    b.this.L(new d(false, null));
                    b.this.k(new OAuthException(10005));
                    return true;
                } else if (eVar.bOA > 0) {
                    b.this.L(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.aao().GS()) {
                    com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                    b.this.k(new OAuthException(10005));
                    return true;
                } else if (!(b.this.mContext instanceof Activity)) {
                    com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                    b.this.k(new OAuthException(10005));
                    return true;
                } else {
                    com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if ((b.this.mContext instanceof Activity) && !((Activity) b.this.mContext).isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(b.this.mContext, b.this.aao(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.bOZ = z;
                                        b.this.bPg = !z;
                                        a.this.abA();
                                    }
                                });
                            }
                        }
                    });
                    return false;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        public final boolean bOw;
        public final String code;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.bOw = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.bOw), this.code);
        }
    }
}
