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
    protected com.baidu.swan.apps.setting.oauth.e cqQ;
    protected boolean csW;
    protected final String csX;
    @NonNull
    protected final String[] csZ;
    protected boolean cta;
    protected final boolean ctc;
    protected final Context mContext;
    protected boolean ctb = false;
    private boolean ctd = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.cta = z;
        this.csZ = strArr == null ? new String[0] : strArr;
        this.csX = str;
        this.csW = z2;
        this.ctc = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean amm() {
        a(new C0347b());
        return super.amm();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean amn() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", ali().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", ali().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String PQ = com.baidu.swan.apps.w.a.abZ().PQ();
            if (!TextUtils.isEmpty(PQ)) {
                jSONObject2.put("host_api_key", PQ);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.csZ) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.csW));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.csX)) {
                jSONObject.put("provider_appkey", this.csX);
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
        return com.baidu.swan.apps.w.a.abZ().f(this.mContext, gVar.amI());
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
        return new d(this.csW, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void amF() {
        super.amF();
        if (this.ctd) {
            l(new OAuthException(10003));
            this.ctd = false;
        }
        if (TextUtils.isEmpty(this.csX)) {
            com.baidu.swan.apps.network.c.b.a.aht();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0347b extends com.baidu.swan.apps.setting.oauth.d {
        private C0347b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean ams() throws Exception {
            if (b.this.csZ == null || b.this.csZ.length > 1) {
                amu();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.a(b.this.csZ[0], new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: c */
                public void F(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.cqQ = eVar;
                    if (eVar == null) {
                        C0347b.this.m(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.amx() && !b.this.ctb) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0347b.this.amu();
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
        protected boolean ams() throws Exception {
            b.this.ctb = true;
            if (b.this.ali().akX().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0347b());
                return true;
            }
            com.baidu.swan.apps.runtime.e ali = b.this.ali();
            if (ali.Rt()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                m(new OAuthException(10004));
                return true;
            } else if (!(b.this.mContext instanceof Activity)) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                m(new OAuthException(10004));
                return true;
            } else {
                ali.akX().a((Activity) b.this.mContext, null, this);
                return false;
            }
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
            switch (i) {
                case -2:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                    m(new OAuthException(10004));
                    return;
                case -1:
                default:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                    m(new OAuthException(10004));
                    return;
                case 0:
                    com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                    b.this.a(new C0347b());
                    amu();
                    return;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean ams() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.cqQ;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.l(new OAuthException(10001));
                return true;
            } else if (eVar.forbidden) {
                b.this.l(new OAuthException(10005));
                return true;
            } else if (b.this.ctc || !b.this.csW) {
                return true;
            } else {
                if (!b.this.cta && eVar.csx < 0) {
                    b.this.P(new d(false, null));
                    b.this.l(new OAuthException(10005));
                    return true;
                } else if (eVar.csx > 0) {
                    b.this.P(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.ali().Rt()) {
                    com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                    b.this.l(new OAuthException(10005));
                    return true;
                } else if (!(b.this.mContext instanceof Activity)) {
                    com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                    b.this.l(new OAuthException(10005));
                    return true;
                } else {
                    com.baidu.swan.apps.setting.oauth.c.j(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if ((b.this.mContext instanceof Activity) && !((Activity) b.this.mContext).isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(b.this.mContext, b.this.ali(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.csW = z;
                                        b.this.ctd = !z;
                                        a.this.amu();
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
        public final boolean cst;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.cst = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.cst), this.code);
        }
    }
}
