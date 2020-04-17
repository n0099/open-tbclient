package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends g<d> {
    protected com.baidu.swan.apps.setting.oauth.e cqK;
    protected boolean csQ;
    protected final String csR;
    @NonNull
    protected final String[] csT;
    protected boolean csU;
    protected final boolean csW;
    protected final Context mContext;
    protected boolean csV = false;
    private boolean csX = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.csU = z;
        this.csT = strArr == null ? new String[0] : strArr;
        this.csR = str;
        this.csQ = z2;
        this.csW = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean amn() {
        a(new C0326b());
        return super.amn();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean amo() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", alj().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", alj().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String PR = com.baidu.swan.apps.w.a.aca().PR();
            if (!TextUtils.isEmpty(PR)) {
                jSONObject2.put("host_api_key", PR);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.csT) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.csQ));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.csR)) {
                jSONObject.put("provider_appkey", this.csR);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        bu("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.w.a.aca().f(this.mContext, gVar.amJ());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: be */
    public d aY(JSONObject jSONObject) throws JSONException {
        JSONObject ba = com.baidu.swan.apps.setting.oauth.c.ba(jSONObject);
        int optInt = ba.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + ba.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = ba.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.csQ, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void amG() {
        super.amG();
        if (this.csX) {
            k(new OAuthException(10003));
            this.csX = false;
        }
        if (TextUtils.isEmpty(this.csR)) {
            com.baidu.swan.apps.network.c.b.a.ahu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0326b extends com.baidu.swan.apps.setting.oauth.d {
        private C0326b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean amt() throws Exception {
            if (b.this.csT == null || b.this.csT.length > 1) {
                amv();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.a(b.this.csT[0], new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: c */
                public void E(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.cqK = eVar;
                    if (eVar == null) {
                        C0326b.this.l(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.amy() && !b.this.csV) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0326b.this.amv();
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
        protected boolean amt() throws Exception {
            b.this.csV = true;
            if (b.this.alj().akY().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0326b());
                return true;
            }
            com.baidu.swan.apps.runtime.e alj = b.this.alj();
            if (alj.Ru()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                l(new OAuthException(10004));
                return true;
            } else if (!(b.this.mContext instanceof Activity)) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                l(new OAuthException(10004));
                return true;
            } else {
                alj.akY().a((Activity) b.this.mContext, null, this);
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
                    b.this.a(new C0326b());
                    amv();
                    return;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean amt() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.cqK;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.k(new OAuthException(10001));
                return true;
            } else if (eVar.forbidden) {
                b.this.k(new OAuthException(10005));
                return true;
            } else if (b.this.csW || !b.this.csQ) {
                return true;
            } else {
                if (!b.this.csU && eVar.csr < 0) {
                    b.this.O(new d(false, null));
                    b.this.k(new OAuthException(10005));
                    return true;
                } else if (eVar.csr > 0) {
                    b.this.O(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.alj().Ru()) {
                    com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                    b.this.k(new OAuthException(10005));
                    return true;
                } else if (!(b.this.mContext instanceof Activity)) {
                    com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                    b.this.k(new OAuthException(10005));
                    return true;
                } else {
                    com.baidu.swan.apps.setting.oauth.c.j(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if ((b.this.mContext instanceof Activity) && !((Activity) b.this.mContext).isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(b.this.mContext, b.this.alj(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.csQ = z;
                                        b.this.csX = !z;
                                        a.this.amv();
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
        public final String code;
        public final boolean csn;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.csn = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.csn), this.code);
        }
    }
}
