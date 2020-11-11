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
/* loaded from: classes10.dex */
public class b extends h<d> {
    protected com.baidu.swan.apps.setting.oauth.e dwc;
    @NonNull
    protected final String[] dyA;
    protected boolean dyB;
    protected final boolean dyD;
    protected boolean dyx;
    protected final String dyy;
    protected final Context mContext;
    protected boolean dyC = false;
    private boolean dyE = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.dyB = z;
        this.dyA = strArr == null ? new String[0] : strArr;
        this.dyy = str;
        this.dyx = z2;
        this.dyD = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aJi() {
        a(new C0485b());
        return super.aJi();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aJj() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aJJ().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aJJ().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String aia = com.baidu.swan.apps.t.a.awM().aia();
            if (!TextUtils.isEmpty(aia)) {
                jSONObject2.put("host_api_key", aia);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.dyA) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.dyx));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.dyy)) {
                jSONObject.put("provider_appkey", this.dyy);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        cv("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.awM().g(this.mContext, hVar.aJK());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: ca */
    public d bU(JSONObject jSONObject) throws JSONException {
        JSONObject bW = com.baidu.swan.apps.setting.oauth.c.bW(jSONObject);
        int optInt = bW.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bW.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = bW.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.dyx, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aJE() {
        super.aJE();
        if (this.dyE) {
            v(new OAuthException(10003));
            this.dyE = false;
        }
        if (TextUtils.isEmpty(this.dyy)) {
            com.baidu.swan.apps.network.c.b.a.aCT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0485b extends com.baidu.swan.apps.setting.oauth.d {
        private C0485b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aJo() throws Exception {
            if (b.this.dyA == null || b.this.dyA.length > 1) {
                aJq();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.b(b.this.dyA[0], new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: c */
                public void M(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.dwc = eVar;
                    if (eVar == null) {
                        C0485b.this.w(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.aJt() && !b.this.dyC) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0485b.this.aJq();
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
        protected boolean aJo() throws Exception {
            b.this.dyC = true;
            if (b.this.aJJ().aHH().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0485b());
                return true;
            }
            com.baidu.swan.apps.runtime.e aJJ = b.this.aJJ();
            if (aJJ.ajA()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                w(new OAuthException(10004));
                return true;
            }
            Activity aJF = b.this.aJF();
            if (aJF == null) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                w(new OAuthException(10004));
                return true;
            }
            aJJ.aHH().a(aJF, null, this);
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
                    b.this.a(new C0485b());
                    aJq();
                    return;
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aJo() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.dwc;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.v(new OAuthException(10001));
                com.baidu.swan.apps.statistic.h.b(10001, null);
                return true;
            } else if (eVar.forbidden) {
                b.this.v(new OAuthException(10005));
                com.baidu.swan.apps.statistic.h.b(10005, eVar);
                return true;
            } else if (b.this.dyD || !b.this.dyx) {
                return true;
            } else {
                if (!b.this.dyB && eVar.dxS < 0) {
                    b.this.Z(new d(false, null));
                    b.this.v(new OAuthException(10005));
                    return true;
                } else if (eVar.dxS > 0) {
                    b.this.Z(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.aJJ().ajA()) {
                    com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                    b.this.v(new OAuthException(10005));
                    return true;
                } else {
                    final Activity aJF = b.this.aJF();
                    if (aJF == null) {
                        com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                        b.this.v(new OAuthException(10005));
                        return true;
                    }
                    com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!aJF.isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(aJF, b.this.aJJ(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.dyx = z;
                                        b.this.dyE = !z;
                                        a.this.aJq();
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

    protected Activity aJF() {
        if (this.mContext instanceof Activity) {
            return (Activity) this.mContext;
        }
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        if (aHv == null) {
            return null;
        }
        return aHv.aHo();
    }

    /* loaded from: classes10.dex */
    public static class d {
        public final String code;
        public final boolean dxO;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.dxO = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.dxO), this.code);
        }
    }
}
