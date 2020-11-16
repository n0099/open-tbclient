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
/* loaded from: classes7.dex */
public class b extends h<d> {
    protected com.baidu.swan.apps.setting.oauth.e duv;
    protected boolean dwQ;
    protected final String dwR;
    @NonNull
    protected final String[] dwT;
    protected boolean dwU;
    protected final boolean dwW;
    protected final Context mContext;
    protected boolean dwV = false;
    private boolean dwX = false;

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.mContext = context;
        this.dwU = z;
        this.dwT = strArr == null ? new String[0] : strArr;
        this.dwR = str;
        this.dwQ = z2;
        this.dwW = z3;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aIA() {
        a(new C0483b());
        return super.aIA();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aIB() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aJb().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aJb().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String ahs = com.baidu.swan.apps.t.a.awe().ahs();
            if (!TextUtils.isEmpty(ahs)) {
                jSONObject2.put("host_api_key", ahs);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.dwT) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.dwQ));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.dwR)) {
                jSONObject.put("provider_appkey", this.dwR);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        cu("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.awe().g(this.mContext, hVar.aJc());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bU */
    public d bO(JSONObject jSONObject) throws JSONException {
        JSONObject bQ = com.baidu.swan.apps.setting.oauth.c.bQ(jSONObject);
        int optInt = bQ.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bQ.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = bQ.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new d(this.dwQ, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aIW() {
        super.aIW();
        if (this.dwX) {
            v(new OAuthException(10003));
            this.dwX = false;
        }
        if (TextUtils.isEmpty(this.dwR)) {
            com.baidu.swan.apps.network.c.b.a.aCl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.oauth.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0483b extends com.baidu.swan.apps.setting.oauth.d {
        private C0483b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aIG() throws Exception {
            if (b.this.dwT == null || b.this.dwT.length > 1) {
                aII();
                return true;
            }
            com.baidu.swan.apps.network.c.b.a.b(b.this.dwT[0], new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.oauth.a.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: c */
                public void M(com.baidu.swan.apps.setting.oauth.e eVar) {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                    }
                    b.this.duv = eVar;
                    if (eVar == null) {
                        C0483b.this.w(new Exception("no such scope"));
                        return;
                    }
                    if (eVar.aIL() && !b.this.dwV) {
                        b.this.a(new c());
                    } else {
                        b.this.a(new a());
                    }
                    C0483b.this.aII();
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
        protected boolean aIG() throws Exception {
            b.this.dwV = true;
            if (b.this.aJb().aGZ().isLogin(b.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                b.this.a(new C0483b());
                return true;
            }
            com.baidu.swan.apps.runtime.e aJb = b.this.aJb();
            if (aJb.aiS()) {
                com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                w(new OAuthException(10004));
                return true;
            }
            Activity aIX = b.this.aIX();
            if (aIX == null) {
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                w(new OAuthException(10004));
                return true;
            }
            aJb.aGZ().a(aIX, null, this);
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
                    b.this.a(new C0483b());
                    aII();
                    return;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        public a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aIG() throws Exception {
            final com.baidu.swan.apps.setting.oauth.e eVar = b.this.duv;
            if (eVar == null) {
                com.baidu.swan.apps.setting.oauth.c.c("Illegal ScopeInfo", true);
                b.this.v(new OAuthException(10001));
                com.baidu.swan.apps.statistic.h.b(10001, null);
                return true;
            } else if (eVar.forbidden) {
                b.this.v(new OAuthException(10005));
                com.baidu.swan.apps.statistic.h.b(10005, eVar);
                return true;
            } else if (b.this.dwW || !b.this.dwQ) {
                return true;
            } else {
                if (!b.this.dwU && eVar.dwl < 0) {
                    b.this.Z(new d(false, null));
                    b.this.v(new OAuthException(10005));
                    return true;
                } else if (eVar.dwl > 0) {
                    b.this.Z(new d(true, null));
                    b.this.finish();
                    return true;
                } else if (b.this.aJb().aiS()) {
                    com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
                    b.this.v(new OAuthException(10005));
                    return true;
                } else {
                    final Activity aIX = b.this.aIX();
                    if (aIX == null) {
                        com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                        b.this.v(new OAuthException(10005));
                        return true;
                    }
                    com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!aIX.isFinishing()) {
                                com.baidu.swan.apps.setting.oauth.c.a(aIX, b.this.aJb(), eVar, null, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.oauth.a.b.a.1.1
                                    @Override // com.baidu.swan.apps.setting.oauth.a
                                    public void onResult(boolean z) {
                                        b.this.dwQ = z;
                                        b.this.dwX = !z;
                                        a.this.aII();
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

    protected Activity aIX() {
        if (this.mContext instanceof Activity) {
            return (Activity) this.mContext;
        }
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        if (aGN == null) {
            return null;
        }
        return aGN.aGG();
    }

    /* loaded from: classes7.dex */
    public static class d {
        public final String code;
        public final boolean dwh;

        public d(boolean z, String str) {
            this.code = str == null ? "" : str;
            this.dwh = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.dwh), this.code);
        }
    }
}
