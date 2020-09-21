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
/* loaded from: classes3.dex */
public class b extends h<d> {
    protected com.baidu.swan.apps.setting.oauth.e cVx;
    protected boolean cXT;
    protected final String cXU;
    @NonNull
    protected final String[] cXW;
    protected boolean cXX;
    protected final boolean cXZ;
    protected final Context mContext;
    protected boolean cXY = false;
    private boolean cYa = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.cXX = z;
        this.cXW = strArr == null ? new String[0] : strArr;
        this.cXU = str;
        this.cXT = z2;
        this.cXZ = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aCf() {
        a(new C0442b());
        return super.aCf();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aCg() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aCG().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aCG().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String aaU = com.baidu.swan.apps.t.a.apG().aaU();
            if (!TextUtils.isEmpty(aaU)) {
                jSONObject2.put("host_api_key", aaU);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.cXW) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.cXT));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.cXU)) {
                jSONObject.put("provider_appkey", this.cXU);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        cj("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.apG().g(this.mContext, hVar.aCH());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bK */
    public d bE(JSONObject jSONObject) throws JSONException {
        JSONObject bG = com.baidu.swan.apps.setting.oauth.c.bG(jSONObject);
        int optInt = bG.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bG.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = bG.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.cXT, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aCB() {
        super.aCB();
        if (this.cYa) {
            v(new OAuthException(10003));
            this.cYa = false;
        }
        if (TextUtils.isEmpty(this.cXU)) {
            com.baidu.swan.apps.network.c.b.a.avO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0442b extends com.baidu.swan.apps.setting.oauth.d {
        private C0442b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aCl() throws Exception {
            if (b.this.cXW == null || b.this.cXW.length > 1) {
                aCn();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.b(b.this.cXW[0], new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: c */
                public void J(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.cVx = eVar;
                    if (eVar == null) {
                        C0442b.this.w(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.aCq() && !b.this.cXY) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0442b.this.aCn();
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private c() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aCl() throws Exception {
            b.this.cXY = true;
            if (b.this.aCG().aAE().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0442b());
                return true;
            }
            com.baidu.swan.apps.runtime.e aCG = b.this.aCG();
            if (aCG.acu()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                w(new OAuthException(10004));
                return true;
            }
            Activity aCC = b.this.aCC();
            if (aCC == null) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                w(new OAuthException(10004));
                return true;
            }
            aCG.aAE().a(aCC, null, this);
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
                    b.this.a(new C0442b());
                    aCn();
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aCl() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.cVx;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.v(new OAuthException(10001));
                com.baidu.swan.apps.statistic.h.b(10001, null);
                return true;
            } else if (eVar.forbidden) {
                b.this.v(new OAuthException(10005));
                com.baidu.swan.apps.statistic.h.b(10005, eVar);
                return true;
            } else if (b.this.cXZ || !b.this.cXT) {
                return true;
            } else {
                if (!b.this.cXX && eVar.cXo < 0) {
                    b.this.W(new d(false, null));
                    b.this.v(new OAuthException(10005));
                    return true;
                } else if (eVar.cXo > 0) {
                    b.this.W(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.aCG().acu()) {
                    com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                    b.this.v(new OAuthException(10005));
                    return true;
                } else {
                    final Activity aCC = b.this.aCC();
                    if (aCC == null) {
                        com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                        b.this.v(new OAuthException(10005));
                        return true;
                    }
                    com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!aCC.isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(aCC, b.this.aCG(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.cXT = z;
                                        b.this.cYa = !z;
                                        a.this.aCn();
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

    protected Activity aCC() {
        if (this.mContext instanceof Activity) {
            return (Activity) this.mContext;
        }
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (aAs == null) {
            return null;
        }
        return aAs.aAl();
    }

    /* loaded from: classes3.dex */
    public static class d {
        public final boolean cXk;
        public final String code;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.cXk = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.cXk), this.code);
        }
    }
}
