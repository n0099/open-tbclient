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
/* loaded from: classes11.dex */
public class o extends com.baidu.swan.apps.setting.oauth.a.b {
    private String mStoken;

    public o(Context context, boolean z, boolean z2, String[] strArr, boolean z3) {
        super(context, z, z2, strArr, null, z3);
        if (z2) {
            arT();
        }
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.b
    protected boolean arv() {
        if (aqk().apZ().isLogin(this.mContext)) {
            a(new c());
            return true;
        }
        a(new a());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.b
    protected boolean arw() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aqk().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aqk().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject2.put("stoken", this.mStoken);
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bR("data", jSONObject.toString());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bu */
    public b.d bo(JSONObject jSONObject) throws JSONException {
        if (this.mContext instanceof Activity) {
            com.baidu.swan.bdprivate.a.a.b((Activity) this.mContext, jSONObject);
        }
        return super.bo(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.b, com.baidu.swan.apps.setting.oauth.a.g
    public void arO() {
        super.arO();
        com.baidu.swan.apps.network.c.b.a.alT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean arB() throws Exception {
            if (o.this.cJF.length <= 1) {
                com.baidu.swan.apps.network.c.b.a.a(o.this.cJF[0], new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.bdprivate.a.o.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: c */
                    public void H(com.baidu.swan.apps.setting.oauth.e eVar) {
                        if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                            Log.i("aiapps-oauth", "ListPreparation result: " + (eVar == null ? "null" : eVar));
                        }
                        o.this.cHs = eVar;
                        if (eVar == null) {
                            a.this.t(new Exception("no such scope"));
                            return;
                        }
                        if (eVar.arG() && !o.this.cJH) {
                            o.this.a(new b());
                        } else {
                            o.this.a(new b.a());
                        }
                        a.this.arD();
                    }
                });
            } else {
                arD();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private b() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean arB() throws Exception {
            o.this.cJH = true;
            if (!o.this.aqk().apZ().isLogin(o.this.mContext)) {
                if (o.this.mContext instanceof Activity) {
                    o.this.aqk().apZ().a((Activity) o.this.mContext, null, this);
                    return false;
                }
                com.baidu.swan.apps.setting.oauth.c.c("login error context is not activity.", true);
                t(new OAuthException(10004));
                return true;
            }
            com.baidu.swan.apps.setting.oauth.c.c("LoginPreparation: isLogin true", false);
            o.this.a(new c());
            return true;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
            switch (i) {
                case -2:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                    t(new OAuthException("login cancel by user", 10004));
                    return;
                case -1:
                default:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                    t(new OAuthException("system login error", 10004));
                    return;
                case 0:
                    com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                    o.this.a(new c());
                    arD();
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c extends com.baidu.swan.apps.setting.oauth.d {
        private c() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean arB() throws Exception {
            com.baidu.swan.bdprivate.a.a.a(o.this.mContext, new com.baidu.swan.apps.aq.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.a.o.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: C */
                public void H(Bundle bundle) {
                    if (bundle == null) {
                        c.this.t(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        o.this.mStoken = string;
                        o.this.a(new a());
                        c.this.arD();
                        return;
                    }
                    c.this.t(new OAuthException("empty stoken", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
