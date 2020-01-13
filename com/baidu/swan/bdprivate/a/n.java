package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.a.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class n extends com.baidu.swan.apps.setting.oauth.a.a {
    private String mStoken;

    public n(Activity activity, boolean z, String str) {
        super(activity, z, str, null);
        if (z) {
            acm();
        }
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean abP() {
        a(new a());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.b
    protected boolean abQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aaL().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aaL().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject2.put("stoken", this.mStoken);
            String FL = com.baidu.swan.apps.w.a.RS().FL();
            if (!TextUtils.isEmpty(FL)) {
                jSONObject2.put("host_api_key", FL);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.bPJ));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bc("data", jSONObject.toString());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.b
    /* renamed from: aS */
    public a.C0284a aN(JSONObject jSONObject) throws JSONException {
        com.baidu.swan.bdprivate.a.a.b(this.mActivity, jSONObject);
        return super.aN(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.a.g
    public void aci() {
        super.aci();
        com.baidu.swan.apps.network.c.b.a.WW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean abV() throws Exception {
            com.baidu.swan.bdprivate.a.a.a(n.this.mActivity, new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.bdprivate.a.n.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: z */
                public void B(Bundle bundle) {
                    if (bundle == null) {
                        a.this.l(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        n.this.mStoken = string;
                        a.this.abX();
                        return;
                    }
                    a.this.l(new OAuthException("empty stoken", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
