package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends h<d> {
    protected com.baidu.swan.apps.setting.oauth.e dFn;
    protected boolean dHH;
    protected final String dHI;
    @NonNull
    protected final String[] dHK;
    protected boolean dHL;
    protected final boolean dHN;
    protected final Context mContext;
    protected boolean dHM = false;
    private boolean dHO = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.dHL = z;
        this.dHK = strArr == null ? new String[0] : strArr;
        this.dHI = str;
        this.dHH = z2;
        this.dHN = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aKf() {
        a(new C0471b());
        return super.aKf();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aKg() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aKG().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aKG().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String ahR = com.baidu.swan.apps.t.a.awK().ahR();
            if (!TextUtils.isEmpty(ahR)) {
                jSONObject2.put("host_api_key", ahR);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.dHK) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.dHH));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.dHI)) {
                jSONObject.put("provider_appkey", this.dHI);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        cz("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.awK().g(this.mContext, hVar.aKH());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: ce */
    public d bY(JSONObject jSONObject) throws JSONException {
        JSONObject ca = com.baidu.swan.apps.setting.oauth.c.ca(jSONObject);
        int optInt = ca.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + ca.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = ca.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.dHH, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aKB() {
        super.aKB();
        if (this.dHO) {
            w(new OAuthException(10003));
            this.dHO = false;
        }
        if (TextUtils.isEmpty(this.dHI)) {
            com.baidu.swan.apps.network.c.b.a.aCV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0471b extends com.baidu.swan.apps.setting.oauth.d {
        private C0471b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aKl() throws Exception {
            if (b.this.dHK == null || b.this.dHK.length > 1) {
                aKn();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.b(b.this.dHK[0], new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: c */
                public void L(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.dFn = eVar;
                    if (eVar == null) {
                        C0471b.this.x(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.aKq() && !b.this.dHM) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0471b.this.aKn();
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
        protected boolean aKl() throws Exception {
            b.this.dHM = true;
            if (b.this.aKG().aIE().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0471b());
                return true;
            }
            com.baidu.swan.apps.runtime.e aKG = b.this.aKG();
            if (aKG.ajr()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                x(new OAuthException(10004));
                return true;
            }
            Activity aKC = b.this.aKC();
            if (aKC == null) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                x(new OAuthException(10004));
                return true;
            }
            aKG.aIE().a(aKC, null, this);
            return false;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
            switch (i) {
                case -2:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                    x(new OAuthException(10004));
                    return;
                case -1:
                default:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                    x(new OAuthException(10004));
                    return;
                case 0:
                    com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                    b.this.a(new C0471b());
                    aKn();
                    return;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aKl() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.dFn;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.w(new OAuthException(10001));
                com.baidu.swan.apps.statistic.h.b(10001, null);
                return true;
            } else if (eVar.forbidden) {
                b.this.w(new OAuthException(10005));
                com.baidu.swan.apps.statistic.h.b(10005, eVar);
                return true;
            } else if (b.this.dHN || !b.this.dHH) {
                return true;
            } else {
                if (!b.this.dHL && eVar.dHc < 0) {
                    b.this.aa(new d(false, null));
                    b.this.w(new OAuthException(10005));
                    return true;
                } else if (eVar.dHc > 0) {
                    b.this.aa(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.aKG().ajr()) {
                    com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                    b.this.w(new OAuthException(10005));
                    return true;
                } else {
                    final Activity aKC = b.this.aKC();
                    if (aKC == null) {
                        com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                        b.this.w(new OAuthException(10005));
                        return true;
                    }
                    com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!aKC.isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(aKC, b.this.aKG(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.dHH = z;
                                        b.this.dHO = !z;
                                        a.this.aKn();
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

    protected Activity aKC() {
        if (this.mContext instanceof Activity) {
            return (Activity) this.mContext;
        }
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        if (aIs == null) {
            return null;
        }
        return aIs.aIl();
    }

    /* loaded from: classes8.dex */
    public static class d {
        public final String code;
        public final boolean dGY;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.dGY = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.dGY), this.code);
        }
    }
}
