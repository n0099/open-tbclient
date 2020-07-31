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
/* loaded from: classes7.dex */
public class b extends g<d> {
    protected com.baidu.swan.apps.setting.oauth.e cKv;
    protected boolean cMT;
    protected final String cMU;
    @NonNull
    protected final String[] cMW;
    protected boolean cMX;
    protected final boolean cMZ;
    protected final Context mContext;
    protected boolean cMY = false;
    private boolean cNa = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.cMX = z;
        this.cMW = strArr == null ? new String[0] : strArr;
        this.cMU = str;
        this.cMT = z2;
        this.cMZ = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean atn() {
        a(new C0401b());
        return super.atn();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean ato() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", atN().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", atN().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String Uj = com.baidu.swan.apps.t.a.ahv().Uj();
            if (!TextUtils.isEmpty(Uj)) {
                jSONObject2.put("host_api_key", Uj);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.cMW) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.cMT));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.cMU)) {
                jSONObject.put("provider_appkey", this.cMU);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        bS("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected HttpRequest a(g gVar) {
        return com.baidu.swan.apps.t.a.ahv().f(this.mContext, gVar.atO());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bz */
    public d bt(JSONObject jSONObject) throws JSONException {
        JSONObject bv = com.baidu.swan.apps.setting.oauth.c.bv(jSONObject);
        int optInt = bv.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bv.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = bv.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.cMT, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void atJ() {
        super.atJ();
        if (this.cNa) {
            s(new OAuthException(10003));
            this.cNa = false;
        }
        if (TextUtils.isEmpty(this.cMU)) {
            com.baidu.swan.apps.network.c.b.a.anj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0401b extends com.baidu.swan.apps.setting.oauth.d {
        private C0401b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean att() throws Exception {
            if (b.this.cMW == null || b.this.cMW.length > 1) {
                atv();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.a(b.this.cMW[0], new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: c */
                public void H(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.cKv = eVar;
                    if (eVar == null) {
                        C0401b.this.t(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.aty() && !b.this.cMY) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0401b.this.atv();
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private c() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean att() throws Exception {
            b.this.cMY = true;
            if (b.this.atN().arI().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0401b());
                return true;
            }
            com.baidu.swan.apps.runtime.e atN = b.this.atN();
            if (atN.VF()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                t(new OAuthException(10004));
                return true;
            } else if (!(b.this.mContext instanceof Activity)) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                t(new OAuthException(10004));
                return true;
            } else {
                atN.arI().a((Activity) b.this.mContext, null, this);
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
                    b.this.a(new C0401b());
                    atv();
                    return;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean att() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.cKv;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.s(new OAuthException(10001));
                h.b(10001, null);
                return true;
            } else if (eVar.forbidden) {
                b.this.s(new OAuthException(10005));
                h.b(10005, eVar);
                return true;
            } else if (b.this.cMZ || !b.this.cMT) {
                return true;
            } else {
                if (!b.this.cMX && eVar.cMo < 0) {
                    b.this.S(new d(false, null));
                    b.this.s(new OAuthException(10005));
                    return true;
                } else if (eVar.cMo > 0) {
                    b.this.S(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.atN().VF()) {
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
                                com.baidu.swan.apps.setting.oauth.c.a(b.this.mContext, b.this.atN(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.cMT = z;
                                        b.this.cNa = !z;
                                        a.this.atv();
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

    /* loaded from: classes7.dex */
    public static class d {
        public final boolean cMk;
        public final String code;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.cMk = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.cMk), this.code);
        }
    }
}
