package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends h<d> {
    protected com.baidu.swan.apps.setting.oauth.e dIS;
    protected boolean dLm;
    protected final String dLn;
    @NonNull
    protected final String[] dLp;
    protected boolean dLq;
    protected final boolean dLs;
    protected final Context mContext;
    protected boolean dLr = false;
    private boolean dLt = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.dLq = z;
        this.dLp = strArr == null ? new String[0] : strArr;
        this.dLn = str;
        this.dLm = z2;
        this.dLs = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aKB() {
        a(new C0474b());
        return super.aKB();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aKC() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aLc().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aLc().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String ais = com.baidu.swan.apps.t.a.axl().ais();
            if (!TextUtils.isEmpty(ais)) {
                jSONObject2.put("host_api_key", ais);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.dLp) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.dLm));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.dLn)) {
                jSONObject.put("provider_appkey", this.dLn);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        ct("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.axl().g(this.mContext, hVar.aLd());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: cd */
    public d bX(JSONObject jSONObject) throws JSONException {
        JSONObject bZ = com.baidu.swan.apps.setting.oauth.c.bZ(jSONObject);
        int optInt = bZ.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bZ.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = bZ.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.dLm, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aKX() {
        super.aKX();
        if (this.dLt) {
            w(new OAuthException(10003));
            this.dLt = false;
        }
        if (TextUtils.isEmpty(this.dLn)) {
            com.baidu.swan.apps.network.c.b.a.aDu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0474b extends com.baidu.swan.apps.setting.oauth.d {
        private C0474b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aKH() throws Exception {
            if (b.this.dLp == null || b.this.dLp.length > 1) {
                aKJ();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.b(b.this.dLp[0], new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: c */
                public void N(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.dIS = eVar;
                    if (eVar == null) {
                        C0474b.this.x(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.aKM() && !b.this.dLr) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0474b.this.aKJ();
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private c() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aKH() throws Exception {
            b.this.dLr = true;
            if (b.this.aLc().aJa().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.d("LoginPreparation: isLogin true", false);
                b.this.a(new C0474b());
                return true;
            }
            com.baidu.swan.apps.runtime.e aLc = b.this.aLc();
            if (aLc.ajS()) {
                com.baidu.swan.apps.setting.oauth.c.d("this operation does not supported when app is invisible.", true);
                x(new OAuthException(10004));
                return true;
            }
            Activity aKY = b.this.aKY();
            if (aKY == null) {
                com.baidu.swan.apps.setting.oauth.c.d("login error context is not activity.", true);
                x(new OAuthException(10004));
                return true;
            }
            aLc.aJa().a(aKY, null, this);
            return false;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            com.baidu.swan.apps.setting.oauth.c.d("onResult :: " + i, false);
            switch (i) {
                case -2:
                    com.baidu.swan.apps.setting.oauth.c.d("login error ERR_BY_UESR_REFUSE", true);
                    x(new OAuthException(10004));
                    return;
                case -1:
                default:
                    com.baidu.swan.apps.setting.oauth.c.d("login error ERR_BY_LOGIN", true);
                    x(new OAuthException(10004));
                    return;
                case 0:
                    com.baidu.swan.apps.setting.oauth.c.d("Login Preparation ok, is already login", false);
                    b.this.a(new C0474b());
                    aKJ();
                    return;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aKH() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.dIS;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.d("Illegal ScopeInfo", true);
                b.this.w(new OAuthException(10001));
                com.baidu.swan.apps.statistic.h.b(10001, null);
                return true;
            } else if (eVar.forbidden) {
                b.this.w(new OAuthException(10005));
                com.baidu.swan.apps.statistic.h.b(10005, eVar);
                return true;
            } else if (b.this.dLs || !b.this.dLm) {
                return true;
            } else {
                if (!b.this.dLq && eVar.dKH < 0) {
                    b.this.ac(new d(false, null));
                    b.this.w(new OAuthException(10005));
                    return true;
                } else if (eVar.dKH > 0) {
                    b.this.ac(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.aLc().ajS()) {
                    com.baidu.swan.apps.setting.oauth.c.d("this operation does not supported when app is invisible.", true);
                    b.this.w(new OAuthException(10005));
                    return true;
                } else {
                    final Activity aKY = b.this.aKY();
                    if (aKY == null) {
                        com.baidu.swan.apps.setting.oauth.c.d("login error context is not activity.", true);
                        b.this.w(new OAuthException(10005));
                        return true;
                    }
                    com.baidu.swan.apps.setting.oauth.c.e(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!aKY.isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(aKY, b.this.aLc(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.dLm = z;
                                        b.this.dLt = !z;
                                        a.this.aKJ();
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

    protected Activity aKY() {
        if (this.mContext instanceof Activity) {
            return (Activity) this.mContext;
        }
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (aIO == null) {
            return null;
        }
        return aIO.aIH();
    }

    /* loaded from: classes8.dex */
    public static class d {
        public final String code;
        public final boolean dKD;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.dKD = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.dKD), this.code);
        }
    }
}
