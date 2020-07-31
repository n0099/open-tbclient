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

    public s(Activity activity, String str, String str2, boolean z, boolean z2) {
        super(activity, str, str2, z);
        this.mIsLogin = z2;
        atP();
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean atn() {
        a(new a());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.f
    public JSONObject atL() {
        JSONObject atL = super.atL();
        if (!TextUtils.isEmpty(this.mStoken)) {
            try {
                atL.put("stoken", this.mStoken);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return atL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean att() throws Exception {
            if (!s.this.mIsLogin) {
                s.this.mStoken = null;
                if (s.DEBUG) {
                    Log.w("MaOpenDataRequest", "user not login");
                    return true;
                }
                return true;
            }
            com.baidu.swan.bdprivate.a.a.a(s.this.mActivity, new com.baidu.swan.apps.aq.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.a.s.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: D */
                public void H(Bundle bundle) {
                    if (bundle == null) {
                        a.this.t(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        s.this.mStoken = string;
                        a.this.atv();
                        return;
                    }
                    a.this.t(new OAuthException("empty stoken", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
