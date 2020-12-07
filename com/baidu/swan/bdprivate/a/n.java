package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.a.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class n extends com.baidu.swan.apps.setting.oauth.a.a {
    private String mStoken;

    public n(Activity activity, boolean z, String str, String str2) {
        super(activity, z, str, str2);
        if (z) {
            aMl();
        }
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aLI() {
        a(new a());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.b
    protected boolean aLJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aMj().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aMj().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject2.put("stoken", this.mStoken);
            String akA = com.baidu.swan.apps.t.a.azm().akA();
            if (!TextUtils.isEmpty(akA)) {
                jSONObject2.put("host_api_key", akA);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.dDP));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cB("data", jSONObject.toString());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bV */
    public a.C0493a bQ(JSONObject jSONObject) throws JSONException {
        com.baidu.swan.bdprivate.a.a.b(this.mActivity, jSONObject);
        return super.bQ(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.a.h
    public void aMe() {
        super.aMe();
        com.baidu.swan.apps.network.c.b.a.aFu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aLO() throws Exception {
            com.baidu.swan.bdprivate.a.a.a(n.this.mActivity, new com.baidu.swan.apps.ap.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.a.n.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: B */
                public void M(Bundle bundle) {
                    if (bundle == null) {
                        a.this.w(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        n.this.mStoken = string;
                        a.this.aLQ();
                        return;
                    }
                    a.this.w(new OAuthException("empty stoken", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
