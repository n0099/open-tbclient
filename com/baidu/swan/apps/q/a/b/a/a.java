package com.baidu.swan.apps.q.a.b.a;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.a.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.swan.apps.setting.oauth.a.a {
    private String mStoken;

    public a(Activity activity, boolean z, String str) {
        super(activity, z, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    public boolean DN() {
        a(new C0164a());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.b
    protected boolean DO() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Mu().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", Mu().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject2.put("stoken", this.mStoken);
            String wS = com.baidu.swan.apps.u.a.Ew().wS();
            if (!TextUtils.isEmpty(wS)) {
                jSONObject2.put("host_api_key", wS);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.aUV));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aA("data", jSONObject.toString());
        if (this.aUV) {
            Nz();
            return true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.b
    /* renamed from: y */
    public a.C0180a z(JSONObject jSONObject) throws JSONException {
        com.baidu.tieba.aiapps.apps.a.c.b(this.mActivity, jSONObject);
        return super.z(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.a.g
    public void DP() {
        super.DP();
        com.baidu.swan.apps.network.c.b.a.Ib();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.q.a.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0164a extends com.baidu.swan.apps.setting.oauth.d {
        private C0164a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean DQ() throws Exception {
            com.baidu.tieba.aiapps.apps.a.c.a(a.this.mActivity, new com.baidu.swan.apps.an.d.a<Bundle>() { // from class: com.baidu.swan.apps.q.a.b.a.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: o */
                public void D(Bundle bundle) {
                    if (bundle == null) {
                        C0164a.this.m(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        a.this.mStoken = string;
                        C0164a.this.Nt();
                        return;
                    }
                    C0164a.this.m(new OAuthException("empty stoken", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
