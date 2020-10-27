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
    protected com.baidu.swan.apps.setting.oauth.e dqh;
    protected boolean dsE;
    protected final String dsF;
    @NonNull
    protected final String[] dsH;
    protected boolean dsI;
    protected final boolean dsK;
    protected final Context mContext;
    protected boolean dsJ = false;
    private boolean dsL = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.dsI = z;
        this.dsH = strArr == null ? new String[0] : strArr;
        this.dsF = str;
        this.dsE = z2;
        this.dsK = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aGI() {
        a(new C0473b());
        return super.aGI();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aGJ() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aHj().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aHj().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String afA = com.baidu.swan.apps.t.a.aum().afA();
            if (!TextUtils.isEmpty(afA)) {
                jSONObject2.put("host_api_key", afA);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.dsH) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.dsE));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.dsF)) {
                jSONObject.put("provider_appkey", this.dsF);
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
        return com.baidu.swan.apps.t.a.aum().g(this.mContext, hVar.aHk());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bU */
    public d bO(JSONObject jSONObject) throws JSONException {
        JSONObject bQ = com.baidu.swan.apps.setting.oauth.c.bQ(jSONObject);
        int optInt = bQ.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bQ.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = bQ.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.dsE, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aHe() {
        super.aHe();
        if (this.dsL) {
            v(new OAuthException(10003));
            this.dsL = false;
        }
        if (TextUtils.isEmpty(this.dsF)) {
            com.baidu.swan.apps.network.c.b.a.aAt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0473b extends com.baidu.swan.apps.setting.oauth.d {
        private C0473b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aGO() throws Exception {
            if (b.this.dsH == null || b.this.dsH.length > 1) {
                aGQ();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.b(b.this.dsH[0], new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: c */
                public void M(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.dqh = eVar;
                    if (eVar == null) {
                        C0473b.this.w(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.aGT() && !b.this.dsJ) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0473b.this.aGQ();
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
        protected boolean aGO() throws Exception {
            b.this.dsJ = true;
            if (b.this.aHj().aFh().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0473b());
                return true;
            }
            com.baidu.swan.apps.runtime.e aHj = b.this.aHj();
            if (aHj.aha()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                w(new OAuthException(10004));
                return true;
            }
            Activity aHf = b.this.aHf();
            if (aHf == null) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                w(new OAuthException(10004));
                return true;
            }
            aHj.aFh().a(aHf, null, this);
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
                    b.this.a(new C0473b());
                    aGQ();
                    return;
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aGO() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.dqh;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.v(new OAuthException(10001));
                com.baidu.swan.apps.statistic.h.b(10001, null);
                return true;
            } else if (eVar.forbidden) {
                b.this.v(new OAuthException(10005));
                com.baidu.swan.apps.statistic.h.b(10005, eVar);
                return true;
            } else if (b.this.dsK || !b.this.dsE) {
                return true;
            } else {
                if (!b.this.dsI && eVar.drY < 0) {
                    b.this.Z(new d(false, null));
                    b.this.v(new OAuthException(10005));
                    return true;
                } else if (eVar.drY > 0) {
                    b.this.Z(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.aHj().aha()) {
                    com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                    b.this.v(new OAuthException(10005));
                    return true;
                } else {
                    final Activity aHf = b.this.aHf();
                    if (aHf == null) {
                        com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                        b.this.v(new OAuthException(10005));
                        return true;
                    }
                    com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!aHf.isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(aHf, b.this.aHj(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.dsE = z;
                                        b.this.dsL = !z;
                                        a.this.aGQ();
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

    protected Activity aHf() {
        if (this.mContext instanceof Activity) {
            return (Activity) this.mContext;
        }
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        if (aEV == null) {
            return null;
        }
        return aEV.aEO();
    }

    /* loaded from: classes10.dex */
    public static class d {
        public final String code;
        public final boolean drU;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.drU = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.drU), this.code);
        }
    }
}
