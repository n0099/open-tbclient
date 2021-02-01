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
    protected com.baidu.swan.apps.setting.oauth.e dHr;
    protected boolean dJL;
    protected final String dJM;
    @NonNull
    protected final String[] dJO;
    protected boolean dJP;
    protected final boolean dJR;
    protected final Context mContext;
    protected boolean dJQ = false;
    private boolean dJS = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.dJP = z;
        this.dJO = strArr == null ? new String[0] : strArr;
        this.dJM = str;
        this.dJL = z2;
        this.dJR = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aKy() {
        a(new C0468b());
        return super.aKy();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aKz() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aKZ().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aKZ().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String aip = com.baidu.swan.apps.t.a.axi().aip();
            if (!TextUtils.isEmpty(aip)) {
                jSONObject2.put("host_api_key", aip);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.dJO) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.dJL));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.dJM)) {
                jSONObject.put("provider_appkey", this.dJM);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        ct("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.axi().g(this.mContext, hVar.aLa());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: cb */
    public d bV(JSONObject jSONObject) throws JSONException {
        JSONObject bX = com.baidu.swan.apps.setting.oauth.c.bX(jSONObject);
        int optInt = bX.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bX.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = bX.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.dJL, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aKU() {
        super.aKU();
        if (this.dJS) {
            w(new OAuthException(10003));
            this.dJS = false;
        }
        if (TextUtils.isEmpty(this.dJM)) {
            com.baidu.swan.apps.network.c.b.a.aDr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0468b extends com.baidu.swan.apps.setting.oauth.d {
        private C0468b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aKE() throws Exception {
            if (b.this.dJO == null || b.this.dJO.length > 1) {
                aKG();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.b(b.this.dJO[0], new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: c */
                public void L(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.dHr = eVar;
                    if (eVar == null) {
                        C0468b.this.x(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.aKJ() && !b.this.dJQ) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0468b.this.aKG();
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
        protected boolean aKE() throws Exception {
            b.this.dJQ = true;
            if (b.this.aKZ().aIX().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0468b());
                return true;
            }
            com.baidu.swan.apps.runtime.e aKZ = b.this.aKZ();
            if (aKZ.ajP()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                x(new OAuthException(10004));
                return true;
            }
            Activity aKV = b.this.aKV();
            if (aKV == null) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                x(new OAuthException(10004));
                return true;
            }
            aKZ.aIX().a(aKV, null, this);
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
                    b.this.a(new C0468b());
                    aKG();
                    return;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aKE() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.dHr;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.w(new OAuthException(10001));
                com.baidu.swan.apps.statistic.h.b(10001, null);
                return true;
            } else if (eVar.forbidden) {
                b.this.w(new OAuthException(10005));
                com.baidu.swan.apps.statistic.h.b(10005, eVar);
                return true;
            } else if (b.this.dJR || !b.this.dJL) {
                return true;
            } else {
                if (!b.this.dJP && eVar.dJg < 0) {
                    b.this.aa(new d(false, null));
                    b.this.w(new OAuthException(10005));
                    return true;
                } else if (eVar.dJg > 0) {
                    b.this.aa(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.aKZ().ajP()) {
                    com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                    b.this.w(new OAuthException(10005));
                    return true;
                } else {
                    final Activity aKV = b.this.aKV();
                    if (aKV == null) {
                        com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                        b.this.w(new OAuthException(10005));
                        return true;
                    }
                    com.baidu.swan.apps.setting.oauth.c.f(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!aKV.isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(aKV, b.this.aKZ(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.dJL = z;
                                        b.this.dJS = !z;
                                        a.this.aKG();
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

    protected Activity aKV() {
        if (this.mContext instanceof Activity) {
            return (Activity) this.mContext;
        }
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (aIL == null) {
            return null;
        }
        return aIL.aIE();
    }

    /* loaded from: classes9.dex */
    public static class d {
        public final String code;
        public final boolean dJc;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.dJc = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.dJc), this.code);
        }
    }
}
