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
/* loaded from: classes8.dex */
public class s extends com.baidu.swan.apps.setting.oauth.a.f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String mStoken;

    public s(Activity activity, b.a aVar, Bundle bundle) {
        super(activity, aVar, bundle);
        aJM();
        aJL();
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.f
    @NonNull
    protected com.baidu.swan.apps.setting.oauth.d aJG() {
        return new a();
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.f, com.baidu.swan.apps.setting.oauth.b
    protected boolean aJj() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean isEmpty = TextUtils.isEmpty(this.dyy);
            jSONObject.put("ma_id", isEmpty ? aJJ().id : this.dyy);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", isEmpty ? aJJ().getAppKey() : this.dyy);
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject2.put("stoken", this.mStoken);
            String aia = com.baidu.swan.apps.t.a.awM().aia();
            if (!TextUtils.isEmpty(aia)) {
                jSONObject2.put("host_api_key", aia);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        this.dyN = jSONObject;
        cv("data", jSONObject.toString());
        return true;
    }

    /* loaded from: classes8.dex */
    private class a extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aJo() throws Exception {
            boolean bo = com.baidu.swan.apps.t.a.awF().bo(s.this.mActivity);
            if (s.DEBUG) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + bo + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!bo) {
                s.this.aJJ().aHH().a(s.this.mActivity, s.this.dyM, this);
                return false;
            }
            s.this.a(new b());
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
                    s.this.a(new b());
                    aJq();
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends com.baidu.swan.apps.setting.oauth.d {
        private b() {
            if (s.this.dyL != null && s.this.dyK != null && s.this.dyK.cxT) {
                long j = s.this.dyK.cxU;
                if (s.DEBUG) {
                    Log.d("LoginRequest", "send timeout " + j + "ms msg");
                }
                s.this.dyL.sendEmptyMessageDelayed(1, j >= 0 ? j : 0L);
            }
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aJo() throws Exception {
            com.baidu.swan.bdprivate.a.a.a(s.this.mActivity, new com.baidu.swan.apps.ap.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.a.s.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: B */
                public void M(Bundle bundle) {
                    if (bundle == null) {
                        com.baidu.swan.apps.setting.oauth.c.c("null stoken", true);
                        b.this.w(new OAuthException(10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        s.this.mStoken = string;
                        b.this.aJq();
                        return;
                    }
                    com.baidu.swan.apps.setting.oauth.c.c("empty stoken", true);
                    b.this.w(new OAuthException(10001));
                }
            }, "dev");
            return false;
        }
    }
}
