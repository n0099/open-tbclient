package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class o extends com.baidu.swan.apps.setting.oauth.a.b {
    private String mStoken;

    public o(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        super(context, z, z2, strArr, str, z3);
        if (z2) {
            aJL();
        }
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.b
    protected boolean aJi() {
        if (aJJ().aHH().isLogin(this.mContext)) {
            a(new c());
            return true;
        }
        a(new a());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.b
    protected boolean aJj() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aJJ().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aJJ().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject2.put("stoken", this.mStoken);
            String aia = com.baidu.swan.apps.t.a.awM().aia();
            if (!TextUtils.isEmpty(aia)) {
                jSONObject2.put("host_api_key", aia);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.dyA) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.dyx));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.dyy)) {
                jSONObject.put("provider_appkey", this.dyy);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cv("data", jSONObject.toString());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.b
    /* renamed from: ca */
    public b.d bU(JSONObject jSONObject) throws JSONException {
        if (this.mContext instanceof Activity) {
            com.baidu.swan.bdprivate.a.a.b((Activity) this.mContext, jSONObject);
        } else if (DEBUG) {
            Log.d("SearchBoxAuthorize", Log.getStackTraceString(new Exception("context is not activity.")));
        }
        return super.bU(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.a.h
    public void aJE() {
        super.aJE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aJo() throws Exception {
            if (TextUtils.isEmpty(o.this.dyy)) {
                if (o.this.dyA.length <= 1) {
                    com.baidu.swan.apps.network.c.b.a.b(o.this.dyA[0], new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.bdprivate.a.o.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: c */
                        public void M(com.baidu.swan.apps.setting.oauth.e eVar) {
                            if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                                Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                            }
                            o.this.dwc = eVar;
                            if (eVar == null) {
                                a.this.w(new Exception("no such scope"));
                                return;
                            }
                            if (eVar.aJt() && !o.this.dyC) {
                                o.this.a(new b());
                            } else {
                                o.this.a(new b.a());
                            }
                            a.this.aJq();
                        }
                    });
                } else {
                    aJq();
                }
            } else {
                aJq();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aJo() throws Exception {
            o.this.dyC = true;
            if (o.this.aJJ().aHH().isLogin(o.this.mContext)) {
                com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
                o.this.a(new c());
                return true;
            }
            com.baidu.swan.apps.runtime.e aJJ = o.this.aJJ();
            if (!aJJ.ajA()) {
                if (o.this.mContext instanceof Activity) {
                    aJJ.aHH().a((Activity) o.this.mContext, null, this);
                    return false;
                }
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                w(new OAuthException(10004));
                return true;
            }
            com.baidu.swan.apps.setting.oauth.c.c("this operation does not supported when app is invisible.", true);
            w(new OAuthException(10004));
            return true;
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
                    o.this.a(new c());
                    aJq();
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c extends com.baidu.swan.apps.setting.oauth.d {
        private c() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aJo() throws Exception {
            com.baidu.swan.bdprivate.a.a.a(o.this.mContext, new com.baidu.swan.apps.ap.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.a.o.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: B */
                public void M(Bundle bundle) {
                    if (bundle == null) {
                        c.this.w(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        o.this.mStoken = string;
                        o.this.a(new a());
                        c.this.aJq();
                        return;
                    }
                    c.this.w(new OAuthException("empty stoken", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
