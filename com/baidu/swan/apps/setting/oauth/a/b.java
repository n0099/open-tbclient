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
    protected com.baidu.swan.apps.setting.oauth.e cHs;
    protected boolean cJC;
    protected final String cJD;
    @NonNull
    protected final String[] cJF;
    protected boolean cJG;
    protected final boolean cJI;
    protected final Context mContext;
    protected boolean cJH = false;
    private boolean cJJ = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.cJG = z;
        this.cJF = strArr == null ? new String[0] : strArr;
        this.cJD = str;
        this.cJC = z2;
        this.cJI = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean arv() {
        a(new C0395b());
        return super.arv();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean arw() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aqk().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aqk().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String TM = com.baidu.swan.apps.u.a.agj().TM();
            if (!TextUtils.isEmpty(TM)) {
                jSONObject2.put("host_api_key", TM);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.cJF) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.cJC));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.cJD)) {
                jSONObject.put("provider_appkey", this.cJD);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        bR("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected HttpRequest a(g gVar) {
        return com.baidu.swan.apps.u.a.agj().f(this.mContext, gVar.arS());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bu */
    public d bo(JSONObject jSONObject) throws JSONException {
        JSONObject bq = com.baidu.swan.apps.setting.oauth.c.bq(jSONObject);
        int optInt = bq.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bq.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = bq.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.cJC, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void arO() {
        super.arO();
        if (this.cJJ) {
            s(new OAuthException(10003));
            this.cJJ = false;
        }
        if (TextUtils.isEmpty(this.cJD)) {
            com.baidu.swan.apps.network.c.b.a.alT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0395b extends com.baidu.swan.apps.setting.oauth.d {
        private C0395b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean arB() throws Exception {
            if (b.this.cJF == null || b.this.cJF.length > 1) {
                arD();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.a(b.this.cJF[0], new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: c */
                public void H(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.cHs = eVar;
                    if (eVar == null) {
                        C0395b.this.t(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.arG() && !b.this.cJH) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0395b.this.arD();
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
        protected boolean arB() throws Exception {
            b.this.cJH = true;
            if (b.this.aqk().apZ().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0395b());
                return true;
            }
            com.baidu.swan.apps.runtime.e aqk = b.this.aqk();
            if (aqk.Va()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                t(new OAuthException(10004));
                return true;
            } else if (!(b.this.mContext instanceof Activity)) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                t(new OAuthException(10004));
                return true;
            } else {
                aqk.apZ().a((Activity) b.this.mContext, null, this);
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
                    b.this.a(new C0395b());
                    arD();
                    return;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean arB() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.cHs;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.s(new OAuthException(10001));
                h.b(10001, null);
                return true;
            } else if (eVar.forbidden) {
                b.this.s(new OAuthException(10005));
                h.b(10005, eVar);
                return true;
            } else if (b.this.cJI || !b.this.cJC) {
                return true;
            } else {
                if (!b.this.cJG && eVar.cJe < 0) {
                    b.this.S(new d(false, null));
                    b.this.s(new OAuthException(10005));
                    return true;
                } else if (eVar.cJe > 0) {
                    b.this.S(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.aqk().Va()) {
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
                                com.baidu.swan.apps.setting.oauth.c.a(b.this.mContext, b.this.aqk(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.cJC = z;
                                        b.this.cJJ = !z;
                                        a.this.arD();
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
        public final boolean cJa;
        public final String code;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.cJa = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.cJa), this.code);
        }
    }
}
