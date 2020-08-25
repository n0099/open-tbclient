package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends h<d> {
    protected com.baidu.swan.apps.setting.oauth.e cTt;
    protected boolean cVP;
    protected final String cVQ;
    @NonNull
    protected final String[] cVS;
    protected boolean cVT;
    protected final boolean cVV;
    protected final Context mContext;
    protected boolean cVU = false;
    private boolean cVW = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.cVT = z;
        this.cVS = strArr == null ? new String[0] : strArr;
        this.cVQ = str;
        this.cVP = z2;
        this.cVV = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aBv() {
        a(new C0447b());
        return super.aBv();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aBw() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aBW().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aBW().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String aal = com.baidu.swan.apps.t.a.aoV().aal();
            if (!TextUtils.isEmpty(aal)) {
                jSONObject2.put("host_api_key", aal);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.cVS) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.cVP));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.cVQ)) {
                jSONObject.put("provider_appkey", this.cVQ);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        cj("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.aoV().g(this.mContext, hVar.aBX());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bH */
    public d bB(JSONObject jSONObject) throws JSONException {
        JSONObject bD = com.baidu.swan.apps.setting.oauth.c.bD(jSONObject);
        int optInt = bD.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bD.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = bD.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.cVP, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aBR() {
        super.aBR();
        if (this.cVW) {
            v(new OAuthException(10003));
            this.cVW = false;
        }
        if (TextUtils.isEmpty(this.cVQ)) {
            com.baidu.swan.apps.network.c.b.a.avf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0447b extends com.baidu.swan.apps.setting.oauth.d {
        private C0447b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aBB() throws Exception {
            if (b.this.cVS == null || b.this.cVS.length > 1) {
                aBD();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.b(b.this.cVS[0], new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: c */
                public void I(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.cTt = eVar;
                    if (eVar == null) {
                        C0447b.this.w(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.aBG() && !b.this.cVU) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0447b.this.aBD();
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private c() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aBB() throws Exception {
            b.this.cVU = true;
            if (b.this.aBW().azV().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0447b());
                return true;
            }
            com.baidu.swan.apps.runtime.e aBW = b.this.aBW();
            if (aBW.abL()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                w(new OAuthException(10004));
                return true;
            }
            Activity aBS = b.this.aBS();
            if (aBS == null) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                w(new OAuthException(10004));
                return true;
            }
            aBW.azV().a(aBS, null, this);
            return false;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
            switch (i) {
                case -2:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                    w(new OAuthException(10004));
                    return;
                case -1:
                default:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                    w(new OAuthException(10004));
                    return;
                case 0:
                    com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                    b.this.a(new C0447b());
                    aBD();
                    return;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aBB() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.cTt;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.v(new OAuthException(10001));
                com.baidu.swan.apps.statistic.h.b(10001, null);
                return true;
            } else if (eVar.forbidden) {
                b.this.v(new OAuthException(10005));
                com.baidu.swan.apps.statistic.h.b(10005, eVar);
                return true;
            } else if (b.this.cVV || !b.this.cVP) {
                return true;
            } else {
                if (!b.this.cVT && eVar.cVk < 0) {
                    b.this.V(new d(false, null));
                    b.this.v(new OAuthException(10005));
                    return true;
                } else if (eVar.cVk > 0) {
                    b.this.V(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.aBW().abL()) {
                    com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                    b.this.v(new OAuthException(10005));
                    return true;
                } else {
                    final Activity aBS = b.this.aBS();
                    if (aBS == null) {
                        com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                        b.this.v(new OAuthException(10005));
                        return true;
                    }
                    com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!aBS.isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(aBS, b.this.aBW(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.cVP = z;
                                        b.this.cVW = !z;
                                        a.this.aBD();
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

    protected Activity aBS() {
        if (this.mContext instanceof Activity) {
            return (Activity) this.mContext;
        }
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ == null) {
            return null;
        }
        return azJ.azC();
    }

    /* loaded from: classes8.dex */
    public static class d {
        public final boolean cVg;
        public final String code;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.cVg = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.cVg), this.code);
        }
    }
}
