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
import com.baidu.swan.apps.statistic.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends g<d> {
    protected com.baidu.swan.apps.setting.oauth.e cCI;
    protected boolean cES;
    protected final String cET;
    @NonNull
    protected final String[] cEV;
    protected boolean cEW;
    protected final boolean cEY;
    protected final Context mContext;
    protected boolean cEX = false;
    private boolean cEZ = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.cEW = z;
        this.cEV = strArr == null ? new String[0] : strArr;
        this.cET = str;
        this.cES = z2;
        this.cEY = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aqp() {
        a(new C0389b());
        return super.aqp();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aqq() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", apd().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", apd().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String SG = com.baidu.swan.apps.u.a.afd().SG();
            if (!TextUtils.isEmpty(SG)) {
                jSONObject2.put("host_api_key", SG);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.cEV) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.cES));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.cET)) {
                jSONObject.put("provider_appkey", this.cET);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        bP("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected HttpRequest a(g gVar) {
        return com.baidu.swan.apps.u.a.afd().f(this.mContext, gVar.aqM());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bn */
    public d bh(JSONObject jSONObject) throws JSONException {
        JSONObject bj = com.baidu.swan.apps.setting.oauth.c.bj(jSONObject);
        int optInt = bj.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bj.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = bj.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.cES, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void aqI() {
        super.aqI();
        if (this.cEZ) {
            s(new OAuthException(10003));
            this.cEZ = false;
        }
        if (TextUtils.isEmpty(this.cET)) {
            com.baidu.swan.apps.network.c.b.a.akN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0389b extends com.baidu.swan.apps.setting.oauth.d {
        private C0389b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aqv() throws Exception {
            if (b.this.cEV == null || b.this.cEV.length > 1) {
                aqx();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.a(b.this.cEV[0], new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: c */
                public void H(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.cCI = eVar;
                    if (eVar == null) {
                        C0389b.this.t(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.aqA() && !b.this.cEX) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0389b.this.aqx();
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private c() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aqv() throws Exception {
            b.this.cEX = true;
            if (b.this.apd().aoS().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0389b());
                return true;
            }
            com.baidu.swan.apps.runtime.e apd = b.this.apd();
            if (apd.TU()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                t(new OAuthException(10004));
                return true;
            } else if (!(b.this.mContext instanceof Activity)) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                t(new OAuthException(10004));
                return true;
            } else {
                apd.aoS().a((Activity) b.this.mContext, null, this);
                return false;
            }
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
            switch (i) {
                case -2:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                    t(new OAuthException(10004));
                    return;
                case -1:
                default:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                    t(new OAuthException(10004));
                    return;
                case 0:
                    com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                    b.this.a(new C0389b());
                    aqx();
                    return;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aqv() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.cCI;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.s(new OAuthException(10001));
                h.b(10001, null);
                return true;
            } else if (eVar.forbidden) {
                b.this.s(new OAuthException(10005));
                h.b(10005, eVar);
                return true;
            } else if (b.this.cEY || !b.this.cES) {
                return true;
            } else {
                if (!b.this.cEW && eVar.cEu < 0) {
                    b.this.S(new d(false, null));
                    b.this.s(new OAuthException(10005));
                    return true;
                } else if (eVar.cEu > 0) {
                    b.this.S(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.apd().TU()) {
                    com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                    b.this.s(new OAuthException(10005));
                    return true;
                } else if (!(b.this.mContext instanceof Activity)) {
                    com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                    b.this.s(new OAuthException(10005));
                    return true;
                } else {
                    com.baidu.swan.apps.setting.oauth.c.k(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if ((b.this.mContext instanceof Activity) && !((Activity) b.this.mContext).isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(b.this.mContext, b.this.apd(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.cES = z;
                                        b.this.cEZ = !z;
                                        a.this.aqx();
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

    /* loaded from: classes11.dex */
    public static class d {
        public final boolean cEq;
        public final String code;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.cEq = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.cEq), this.code);
        }
    }
}
