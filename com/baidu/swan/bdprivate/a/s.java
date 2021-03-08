package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
        aLf();
        aLe();
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.f
    @NonNull
    protected com.baidu.swan.apps.setting.oauth.d aKZ() {
        return new a();
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.f, com.baidu.swan.apps.setting.oauth.b
    protected boolean aKC() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean isEmpty = TextUtils.isEmpty(this.dLn);
            jSONObject.put("ma_id", isEmpty ? aLc().id : this.dLn);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", isEmpty ? aLc().getAppKey() : this.dLn);
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject2.put("stoken", this.mStoken);
            String ais = com.baidu.swan.apps.t.a.axl().ais();
            if (!TextUtils.isEmpty(ais)) {
                jSONObject2.put("host_api_key", ais);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        this.dLC = jSONObject;
        ct("data", jSONObject.toString());
        return true;
    }

    /* loaded from: classes8.dex */
    private class a extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aKH() throws Exception {
            boolean bY = com.baidu.swan.apps.t.a.axe().bY(s.this.mActivity);
            if (s.DEBUG) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + bY + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!bY) {
                s.this.aLc().aJa().a(s.this.mActivity, s.this.dLB, this);
                return false;
            }
            s.this.a(new b());
            return true;
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
                    s.this.a(new b());
                    aKJ();
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends com.baidu.swan.apps.setting.oauth.d {
        private b() {
            if (s.this.dLA != null && s.this.dLz != null && s.this.dLz.cHb) {
                long j = s.this.dLz.cHc;
                if (s.DEBUG) {
                    Log.d("LoginRequest", "send timeout " + j + "ms msg");
                }
                s.this.dLA.sendEmptyMessageDelayed(1, j >= 0 ? j : 0L);
            }
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aKH() throws Exception {
            com.baidu.swan.bdprivate.a.a.a(s.this.mActivity, new com.baidu.swan.apps.ao.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.a.s.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: B */
                public void N(Bundle bundle) {
                    if (bundle == null) {
                        com.baidu.swan.apps.setting.oauth.c.d("null stoken", true);
                        b.this.x(new OAuthException(10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        s.this.mStoken = string;
                        b.this.aKJ();
                        return;
                    }
                    com.baidu.swan.apps.setting.oauth.c.d("empty stoken", true);
                    b.this.x(new OAuthException(10001));
                }
            }, "dev");
            return false;
        }
    }
}
