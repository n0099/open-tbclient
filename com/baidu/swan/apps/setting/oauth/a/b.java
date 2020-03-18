package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends g<d> {
    protected com.baidu.swan.apps.setting.oauth.e bRX;
    protected boolean bUb;
    protected final String bUc;
    @NonNull
    protected final String[] bUe;
    protected boolean bUf;
    protected final boolean bUh;
    protected final Context mContext;
    protected boolean bUg = false;
    private boolean bUi = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.bUf = z;
        this.bUe = strArr == null ? new String[0] : strArr;
        this.bUc = str;
        this.bUb = z2;
        this.bUh = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aei() {
        a(new C0296b());
        return super.aei();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aej() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", ade().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", ade().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String If = com.baidu.swan.apps.w.a.Ul().If();
            if (!TextUtils.isEmpty(If)) {
                jSONObject2.put("host_api_key", If);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.bUe) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.bUb));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.bUc)) {
                jSONObject.put("provider_appkey", this.bUc);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        bk("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.w.a.Ul().f(this.mContext, gVar.aeE());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: aT */
    public d aN(JSONObject jSONObject) throws JSONException {
        JSONObject aP = com.baidu.swan.apps.setting.oauth.c.aP(jSONObject);
        int optInt = aP.optInt("errno", 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + aP.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = aP.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.bUb, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void aeB() {
        super.aeB();
        if (this.bUi) {
            k(new OAuthException(10003));
            this.bUi = false;
        }
        if (TextUtils.isEmpty(this.bUc)) {
            com.baidu.swan.apps.network.c.b.a.Zp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0296b extends com.baidu.swan.apps.setting.oauth.d {
        private C0296b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aeo() throws Exception {
            if (b.this.bUe == null || b.this.bUe.length > 1) {
                aeq();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.a(b.this.bUe[0], new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: c */
                public void D(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.bRX = eVar;
                    if (eVar == null) {
                        C0296b.this.l(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.aet() && !b.this.bUg) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0296b.this.aeq();
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
        protected boolean aeo() throws Exception {
            b.this.bUg = true;
            if (b.this.ade().acT().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0296b());
                return true;
            }
            com.baidu.swan.apps.runtime.e ade = b.this.ade();
            if (ade.JI()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                l(new OAuthException(10004));
                return true;
            } else if (!(b.this.mContext instanceof Activity)) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                l(new OAuthException(10004));
                return true;
            } else {
                ade.acT().a((Activity) b.this.mContext, null, this);
                return false;
            }
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
            switch (i) {
                case -2:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                    l(new OAuthException(10004));
                    return;
                case -1:
                default:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                    l(new OAuthException(10004));
                    return;
                case 0:
                    com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                    b.this.a(new C0296b());
                    aeq();
                    return;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aeo() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.bRX;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.k(new OAuthException(10001));
                return true;
            } else if (eVar.forbidden) {
                b.this.k(new OAuthException(10005));
                return true;
            } else if (b.this.bUh || !b.this.bUb) {
                return true;
            } else {
                if (!b.this.bUf && eVar.bTC < 0) {
                    b.this.N(new d(false, null));
                    b.this.k(new OAuthException(10005));
                    return true;
                } else if (eVar.bTC > 0) {
                    b.this.N(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.ade().JI()) {
                    com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                    b.this.k(new OAuthException(10005));
                    return true;
                } else if (!(b.this.mContext instanceof Activity)) {
                    com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                    b.this.k(new OAuthException(10005));
                    return true;
                } else {
                    com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if ((b.this.mContext instanceof Activity) && !((Activity) b.this.mContext).isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(b.this.mContext, b.this.ade(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.bUb = z;
                                        b.this.bUi = !z;
                                        a.this.aeq();
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
        public final boolean bTy;
        public final String code;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.bTy = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.bTy), this.code);
        }
    }
}
