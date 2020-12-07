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
/* loaded from: classes25.dex */
public class b extends h<d> {
    protected com.baidu.swan.apps.setting.oauth.e dBu;
    protected boolean dDP;
    protected final String dDQ;
    @NonNull
    protected final String[] dDS;
    protected boolean dDT;
    protected final boolean dDV;
    protected final Context mContext;
    protected boolean dDU = false;
    private boolean dDW = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.dDT = z;
        this.dDS = strArr == null ? new String[0] : strArr;
        this.dDQ = str;
        this.dDP = z2;
        this.dDV = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aLI() {
        a(new C0495b());
        return super.aLI();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aLJ() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aMj().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aMj().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String akA = com.baidu.swan.apps.t.a.azm().akA();
            if (!TextUtils.isEmpty(akA)) {
                jSONObject2.put("host_api_key", akA);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.dDS) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.dDP));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.dDQ)) {
                jSONObject.put("provider_appkey", this.dDQ);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        cB("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.azm().g(this.mContext, hVar.aMk());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bW */
    public d bQ(JSONObject jSONObject) throws JSONException {
        JSONObject bS = com.baidu.swan.apps.setting.oauth.c.bS(jSONObject);
        int optInt = bS.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bS.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = bS.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.dDP, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aMe() {
        super.aMe();
        if (this.dDW) {
            v(new OAuthException(10003));
            this.dDW = false;
        }
        if (TextUtils.isEmpty(this.dDQ)) {
            com.baidu.swan.apps.network.c.b.a.aFu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class C0495b extends com.baidu.swan.apps.setting.oauth.d {
        private C0495b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aLO() throws Exception {
            if (b.this.dDS == null || b.this.dDS.length > 1) {
                aLQ();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.b(b.this.dDS[0], new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: c */
                public void M(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.dBu = eVar;
                    if (eVar == null) {
                        C0495b.this.w(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.aLT() && !b.this.dDU) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0495b.this.aLQ();
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class c extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private c() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aLO() throws Exception {
            b.this.dDU = true;
            if (b.this.aMj().aKh().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0495b());
                return true;
            }
            com.baidu.swan.apps.runtime.e aMj = b.this.aMj();
            if (aMj.ama()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                w(new OAuthException(10004));
                return true;
            }
            Activity aMf = b.this.aMf();
            if (aMf == null) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                w(new OAuthException(10004));
                return true;
            }
            aMj.aKh().a(aMf, null, this);
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
                    b.this.a(new C0495b());
                    aLQ();
                    return;
            }
        }
    }

    /* loaded from: classes25.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aLO() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.dBu;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.v(new OAuthException(10001));
                com.baidu.swan.apps.statistic.h.b(10001, null);
                return true;
            } else if (eVar.forbidden) {
                b.this.v(new OAuthException(10005));
                com.baidu.swan.apps.statistic.h.b(10005, eVar);
                return true;
            } else if (b.this.dDV || !b.this.dDP) {
                return true;
            } else {
                if (!b.this.dDT && eVar.dDk < 0) {
                    b.this.Z(new d(false, null));
                    b.this.v(new OAuthException(10005));
                    return true;
                } else if (eVar.dDk > 0) {
                    b.this.Z(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.aMj().ama()) {
                    com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                    b.this.v(new OAuthException(10005));
                    return true;
                } else {
                    final Activity aMf = b.this.aMf();
                    if (aMf == null) {
                        com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                        b.this.v(new OAuthException(10005));
                        return true;
                    }
                    com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!aMf.isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(aMf, b.this.aMj(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.dDP = z;
                                        b.this.dDW = !z;
                                        a.this.aLQ();
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

    protected Activity aMf() {
        if (this.mContext instanceof Activity) {
            return (Activity) this.mContext;
        }
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (aJV == null) {
            return null;
        }
        return aJV.aJO();
    }

    /* loaded from: classes25.dex */
    public static class d {
        public final String code;
        public final boolean dDg;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.dDg = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.dDg), this.code);
        }
    }
}
