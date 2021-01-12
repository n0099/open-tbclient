package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class t extends com.baidu.swan.apps.setting.oauth.a.g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean mIsLogin;
    private String mStoken;

    public t(Activity activity, String str, String str2, boolean z, boolean z2) {
        super(activity, str, str2, z);
        this.mIsLogin = z2;
        aKI();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aKf() {
        a(new a());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public JSONObject aKE() {
        JSONObject aKE = super.aKE();
        if (!TextUtils.isEmpty(this.mStoken)) {
            try {
                aKE.put("stoken", this.mStoken);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return aKE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aKl() throws Exception {
            if (!t.this.mIsLogin) {
                t.this.mStoken = null;
                if (t.DEBUG) {
                    Log.w("MaOpenDataRequest", "user not login");
                    return true;
                }
                return true;
            }
            com.baidu.swan.bdprivate.a.a.a(t.this.mActivity, new com.baidu.swan.apps.ao.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.a.t.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: B */
                public void L(Bundle bundle) {
                    if (bundle == null) {
                        a.this.x(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        t.this.mStoken = string;
                        a.this.aKn();
                        return;
                    }
                    a.this.x(new OAuthException("empty stoken", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
