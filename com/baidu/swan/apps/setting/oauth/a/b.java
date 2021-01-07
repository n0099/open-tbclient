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
/* loaded from: classes9.dex */
public class b extends h<d> {
    protected com.baidu.swan.apps.setting.oauth.e dJZ;
    protected boolean dMt;
    protected final String dMu;
    @NonNull
    protected final String[] dMw;
    protected boolean dMx;
    protected final boolean dMz;
    protected final Context mContext;
    protected boolean dMy = false;
    private boolean dMA = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.dMx = z;
        this.dMw = strArr == null ? new String[0] : strArr;
        this.dMu = str;
        this.dMt = z2;
        this.dMz = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aNZ() {
        a(new C0488b());
        return super.aNZ();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aOa() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aOA().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aOA().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String alL = com.baidu.swan.apps.t.a.aAE().alL();
            if (!TextUtils.isEmpty(alL)) {
                jSONObject2.put("host_api_key", alL);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.dMw) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.dMt));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.dMu)) {
                jSONObject.put("provider_appkey", this.dMu);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        cA("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.aAE().g(this.mContext, hVar.aOB());
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
        return new d(this.dMt, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aOv() {
        super.aOv();
        if (this.dMA) {
            w(new OAuthException(10003));
            this.dMA = false;
        }
        if (TextUtils.isEmpty(this.dMu)) {
            com.baidu.swan.apps.network.c.b.a.aGP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0488b extends com.baidu.swan.apps.setting.oauth.d {
        private C0488b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aOf() throws Exception {
            if (b.this.dMw == null || b.this.dMw.length > 1) {
                aOh();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.b(b.this.dMw[0], new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: c */
                public void L(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.dJZ = eVar;
                    if (eVar == null) {
                        C0488b.this.x(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.aOk() && !b.this.dMy) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0488b.this.aOh();
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
        protected boolean aOf() throws Exception {
            b.this.dMy = true;
            if (b.this.aOA().aMy().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0488b());
                return true;
            }
            com.baidu.swan.apps.runtime.e aOA = b.this.aOA();
            if (aOA.anl()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                x(new OAuthException(10004));
                return true;
            }
            Activity aOw = b.this.aOw();
            if (aOw == null) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                x(new OAuthException(10004));
                return true;
            }
            aOA.aMy().a(aOw, null, this);
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
                    b.this.a(new C0488b());
                    aOh();
                    return;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aOf() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.dJZ;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.w(new OAuthException(10001));
                com.baidu.swan.apps.statistic.h.b(10001, null);
                return true;
            } else if (eVar.forbidden) {
                b.this.w(new OAuthException(10005));
                com.baidu.swan.apps.statistic.h.b(10005, eVar);
                return true;
            } else if (b.this.dMz || !b.this.dMt) {
                return true;
            } else {
                if (!b.this.dMx && eVar.dLO < 0) {
                    b.this.aa(new d(false, null));
                    b.this.w(new OAuthException(10005));
                    return true;
                } else if (eVar.dLO > 0) {
                    b.this.aa(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.aOA().anl()) {
                    com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                    b.this.w(new OAuthException(10005));
                    return true;
                } else {
                    final Activity aOw = b.this.aOw();
                    if (aOw == null) {
                        com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                        b.this.w(new OAuthException(10005));
                        return true;
                    }
                    com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!aOw.isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(aOw, b.this.aOA(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.dMt = z;
                                        b.this.dMA = !z;
                                        a.this.aOh();
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

    protected Activity aOw() {
        if (this.mContext instanceof Activity) {
            return (Activity) this.mContext;
        }
        com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
        if (aMm == null) {
            return null;
        }
        return aMm.aMf();
    }

    /* loaded from: classes9.dex */
    public static class d {
        public final String code;
        public final boolean dLK;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.dLK = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.dLK), this.code);
        }
    }
}
