package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.a.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class n extends com.baidu.swan.apps.setting.oauth.a.a {
    private String mStoken;

    public n(Activity activity, boolean z, String str) {
        super(activity, z, str, null);
        if (z) {
            aqN();
        }
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aqp() {
        a(new a());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.b
    protected boolean aqq() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", apd().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", apd().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject2.put("stoken", this.mStoken);
            String SG = com.baidu.swan.apps.u.a.afd().SG();
            if (!TextUtils.isEmpty(SG)) {
                jSONObject2.put("host_api_key", SG);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.cES));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bP("data", jSONObject.toString());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bm */
    public a.C0387a bh(JSONObject jSONObject) throws JSONException {
        com.baidu.swan.bdprivate.a.a.b(this.mActivity, jSONObject);
        return super.bh(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.a.g
    public void aqI() {
        super.aqI();
        com.baidu.swan.apps.network.c.b.a.akN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aqv() throws Exception {
            com.baidu.swan.bdprivate.a.a.a(n.this.mActivity, new com.baidu.swan.apps.aq.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.a.n.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: C */
                public void H(Bundle bundle) {
                    if (bundle == null) {
                        a.this.t(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        n.this.mStoken = string;
                        a.this.aqx();
                        return;
                    }
                    a.this.t(new OAuthException("empty stoken", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
