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
/* loaded from: classes3.dex */
public class s extends com.baidu.swan.apps.setting.oauth.a.f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String mStoken;

    public s(Activity activity, b.a aVar, Bundle bundle) {
        super(activity, aVar, bundle);
        aCJ();
        aCI();
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.f
    @NonNull
    protected com.baidu.swan.apps.setting.oauth.d aCD() {
        return new a();
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.f, com.baidu.swan.apps.setting.oauth.b
    protected boolean aCg() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean isEmpty = TextUtils.isEmpty(this.cXU);
            jSONObject.put("ma_id", isEmpty ? aCG().id : this.cXU);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", isEmpty ? aCG().getAppKey() : this.cXU);
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject2.put("stoken", this.mStoken);
            String aaU = com.baidu.swan.apps.t.a.apG().aaU();
            if (!TextUtils.isEmpty(aaU)) {
                jSONObject2.put("host_api_key", aaU);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        this.cYj = jSONObject;
        cj("data", jSONObject.toString());
        return true;
    }

    /* loaded from: classes3.dex */
    private class a extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aCl() throws Exception {
            boolean bi = com.baidu.swan.apps.t.a.apz().bi(s.this.mActivity);
            if (s.DEBUG) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + bi + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!bi) {
                s.this.aCG().aAE().a(s.this.mActivity, s.this.cYi, this);
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
                    aCn();
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends com.baidu.swan.apps.setting.oauth.d {
        private b() {
            if (s.this.cYh != null && s.this.cYg != null && s.this.cYg.bXg) {
                long j = s.this.cYg.bXh;
                if (s.DEBUG) {
                    Log.d("LoginRequest", "send timeout " + j + "ms msg");
                }
                s.this.cYh.sendEmptyMessageDelayed(1, j >= 0 ? j : 0L);
            }
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aCl() throws Exception {
            com.baidu.swan.bdprivate.a.a.a(s.this.mActivity, new com.baidu.swan.apps.ap.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.a.s.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: B */
                public void J(Bundle bundle) {
                    if (bundle == null) {
                        com.baidu.swan.apps.setting.oauth.c.c("null stoken", true);
                        b.this.w(new OAuthException(10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        s.this.mStoken = string;
                        b.this.aCn();
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
