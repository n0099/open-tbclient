package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class s extends com.baidu.swan.apps.setting.oauth.a.f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean mIsLogin;
    private String mStoken;

    public s(Activity activity, String str, boolean z, boolean z2) {
        super(activity, str, null, z);
        this.mIsLogin = z2;
        amK();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean amn() {
        a(new a());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.f
    public JSONObject amI() {
        JSONObject amI = super.amI();
        if (!TextUtils.isEmpty(this.mStoken)) {
            try {
                amI.put("stoken", this.mStoken);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return amI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean amt() throws Exception {
            if (!s.this.mIsLogin) {
                s.this.mStoken = null;
                if (s.DEBUG) {
                    Log.w("MaOpenDataRequest", "user not login");
                    return true;
                }
                return true;
            }
            com.baidu.swan.bdprivate.a.a.a(s.this.mActivity, new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.bdprivate.a.s.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: z */
                public void E(Bundle bundle) {
                    if (bundle == null) {
                        a.this.l(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        s.this.mStoken = string;
                        a.this.amv();
                        return;
                    }
                    a.this.l(new OAuthException("empty stoken", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
