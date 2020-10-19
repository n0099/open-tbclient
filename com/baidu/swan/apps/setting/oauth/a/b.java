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
    protected com.baidu.swan.apps.setting.oauth.e dhF;
    protected boolean dkd;
    protected final String dke;
    @NonNull
    protected final String[] dkg;
    protected boolean dkh;
    protected final boolean dkj;
    protected final Context mContext;
    protected boolean dki = false;
    private boolean dkk = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.dkh = z;
        this.dkg = strArr == null ? new String[0] : strArr;
        this.dke = str;
        this.dkd = z2;
        this.dkj = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aEO() {
        a(new C0459b());
        return super.aEO();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aEP() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aFp().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aFp().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String adG = com.baidu.swan.apps.t.a.ass().adG();
            if (!TextUtils.isEmpty(adG)) {
                jSONObject2.put("host_api_key", adG);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.dkg) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.dkd));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.dke)) {
                jSONObject.put("provider_appkey", this.dke);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        co("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.ass().g(this.mContext, hVar.aFq());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bR */
    public d bL(JSONObject jSONObject) throws JSONException {
        JSONObject bN = com.baidu.swan.apps.setting.oauth.c.bN(jSONObject);
        int optInt = bN.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bN.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = bN.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.dkd, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aFk() {
        super.aFk();
        if (this.dkk) {
            v(new OAuthException(10003));
            this.dkk = false;
        }
        if (TextUtils.isEmpty(this.dke)) {
            com.baidu.swan.apps.network.c.b.a.ayz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0459b extends com.baidu.swan.apps.setting.oauth.d {
        private C0459b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aEU() throws Exception {
            if (b.this.dkg == null || b.this.dkg.length > 1) {
                aEW();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.b(b.this.dkg[0], new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: c */
                public void M(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.dhF = eVar;
                    if (eVar == null) {
                        C0459b.this.w(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.aEZ() && !b.this.dki) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0459b.this.aEW();
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
        protected boolean aEU() throws Exception {
            b.this.dki = true;
            if (b.this.aFp().aDn().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0459b());
                return true;
            }
            com.baidu.swan.apps.runtime.e aFp = b.this.aFp();
            if (aFp.afg()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                w(new OAuthException(10004));
                return true;
            }
            Activity aFl = b.this.aFl();
            if (aFl == null) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                w(new OAuthException(10004));
                return true;
            }
            aFp.aDn().a(aFl, null, this);
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
                    b.this.a(new C0459b());
                    aEW();
                    return;
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aEU() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.dhF;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.v(new OAuthException(10001));
                com.baidu.swan.apps.statistic.h.b(10001, null);
                return true;
            } else if (eVar.forbidden) {
                b.this.v(new OAuthException(10005));
                com.baidu.swan.apps.statistic.h.b(10005, eVar);
                return true;
            } else if (b.this.dkj || !b.this.dkd) {
                return true;
            } else {
                if (!b.this.dkh && eVar.djy < 0) {
                    b.this.Z(new d(false, null));
                    b.this.v(new OAuthException(10005));
                    return true;
                } else if (eVar.djy > 0) {
                    b.this.Z(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.aFp().afg()) {
                    com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                    b.this.v(new OAuthException(10005));
                    return true;
                } else {
                    final Activity aFl = b.this.aFl();
                    if (aFl == null) {
                        com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                        b.this.v(new OAuthException(10005));
                        return true;
                    }
                    com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!aFl.isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(aFl, b.this.aFp(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.dkd = z;
                                        b.this.dkk = !z;
                                        a.this.aEW();
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

    protected Activity aFl() {
        if (this.mContext instanceof Activity) {
            return (Activity) this.mContext;
        }
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        if (aDb == null) {
            return null;
        }
        return aDb.aCU();
    }

    /* loaded from: classes10.dex */
    public static class d {
        public final String code;
        public final boolean dju;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.dju = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.dju), this.code);
        }
    }
}
