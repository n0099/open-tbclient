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
/* loaded from: classes10.dex */
public class b extends g<d> {
    protected com.baidu.swan.apps.setting.oauth.e bNF;
    protected boolean bPJ;
    protected final String bPK;
    @NonNull
    protected final String[] bPM;
    protected boolean bPN;
    protected final boolean bPP;
    protected final Context mContext;
    protected boolean bPO = false;
    private boolean bPQ = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.bPN = z;
        this.bPM = strArr == null ? new String[0] : strArr;
        this.bPK = str;
        this.bPJ = z2;
        this.bPP = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean abP() {
        a(new C0286b());
        return super.abP();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean abQ() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aaL().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aaL().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String FL = com.baidu.swan.apps.w.a.RS().FL();
            if (!TextUtils.isEmpty(FL)) {
                jSONObject2.put("host_api_key", FL);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.bPM) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.bPJ));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.bPK)) {
                jSONObject.put("provider_appkey", this.bPK);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        bc("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.w.a.RS().f(this.mContext, gVar.acl());
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
        return new d(this.bPJ, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void aci() {
        super.aci();
        if (this.bPQ) {
            k(new OAuthException(10003));
            this.bPQ = false;
        }
        if (TextUtils.isEmpty(this.bPK)) {
            com.baidu.swan.apps.network.c.b.a.WW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0286b extends com.baidu.swan.apps.setting.oauth.d {
        private C0286b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean abV() throws Exception {
            if (b.this.bPM == null || b.this.bPM.length > 1) {
                abX();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.a(b.this.bPM[0], new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: c */
                public void B(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.bNF = eVar;
                    if (eVar == null) {
                        C0286b.this.l(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.aca() && !b.this.bPO) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0286b.this.abX();
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private c() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean abV() throws Exception {
            b.this.bPO = true;
            if (b.this.aaL().aaA().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0286b());
                return true;
            }
            com.baidu.swan.apps.runtime.e aaL = b.this.aaL();
            if (aaL.Ho()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                l(new OAuthException(10004));
                return true;
            } else if (!(b.this.mContext instanceof Activity)) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                l(new OAuthException(10004));
                return true;
            } else {
                aaL.aaA().a((Activity) b.this.mContext, null, this);
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
                    b.this.a(new C0286b());
                    abX();
                    return;
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean abV() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.bNF;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.k(new OAuthException(10001));
                return true;
            } else if (eVar.forbidden) {
                b.this.k(new OAuthException(10005));
                return true;
            } else if (b.this.bPP || !b.this.bPJ) {
                return true;
            } else {
                if (!b.this.bPN && eVar.bPk < 0) {
                    b.this.L(new d(false, null));
                    b.this.k(new OAuthException(10005));
                    return true;
                } else if (eVar.bPk > 0) {
                    b.this.L(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.aaL().Ho()) {
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
                                com.baidu.swan.apps.setting.oauth.c.a(b.this.mContext, b.this.aaL(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.bPJ = z;
                                        b.this.bPQ = !z;
                                        a.this.abX();
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

    /* loaded from: classes10.dex */
    public static class d {
        public final boolean bPg;
        public final String code;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.bPg = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.bPg), this.code);
        }
    }
}
