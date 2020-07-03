package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.api.module.a.b;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class r extends com.baidu.swan.apps.setting.oauth.a.e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String mStoken;

    public r(Activity activity, b.a aVar, Bundle bundle) {
        super(activity, aVar, bundle);
        arU();
        arT();
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.e
    @NonNull
    protected com.baidu.swan.apps.setting.oauth.d arP() {
        return new a();
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.e, com.baidu.swan.apps.setting.oauth.b
    protected boolean arw() {
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.cJS = jSONObject;
        bR("data", jSONObject.toString());
        return true;
    }

    /* loaded from: classes11.dex */
    private class a extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean arB() throws Exception {
            boolean bb = com.baidu.swan.apps.u.a.agc().bb(r.this.mActivity);
            if (r.DEBUG) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + bb + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!bb) {
                r.this.aqk().apZ().a(r.this.mActivity, r.this.cJR, this);
                return false;
            }
            r.this.a(new b());
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
                    t(new OAuthException("system login error :" + i, 10004));
                    return;
                case 0:
                    com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                    r.this.a(new b());
                    arD();
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends com.baidu.swan.apps.setting.oauth.d {
        private b() {
            if (r.this.cJQ != null && r.this.cJP != null && r.this.cJP.bOJ) {
                long j = r.this.cJP.bOK;
                if (r.DEBUG) {
                    Log.d("LoginRequest", "send timeout " + j + "ms msg");
                }
                r.this.cJQ.sendEmptyMessageDelayed(1, j >= 0 ? j : 0L);
            }
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean arB() throws Exception {
            com.baidu.swan.bdprivate.a.a.a(r.this.mActivity, new com.baidu.swan.apps.aq.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.a.r.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: C */
                public void H(Bundle bundle) {
                    if (bundle == null) {
                        b.this.t(new OAuthException("null bundle stoken", 10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        r.this.mStoken = string;
                        b.this.arD();
                        return;
                    }
                    b.this.t(new OAuthException("dev is empty", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
