package com.baidu.swan.apps.q.a.b.a;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
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
    public boolean Cc() {
        a(new C0156a());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.b
    protected boolean Cd() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Jl().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", Jl().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject2.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, this.mStoken);
            String vC = com.baidu.swan.apps.u.a.CI().vC();
            if (!TextUtils.isEmpty(vC)) {
                jSONObject2.put("host_api_key", vC);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.aRw));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ay("data", jSONObject.toString());
        if (this.aRw) {
            Kk();
            return true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.b
    /* renamed from: B */
    public a.C0171a C(JSONObject jSONObject) throws JSONException {
        com.baidu.tieba.aiapps.apps.a.a.a(this.mActivity, jSONObject);
        return super.C(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.a.g
    public void Ce() {
        super.Ce();
        com.baidu.swan.apps.network.c.b.a.Fk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.q.a.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0156a extends com.baidu.swan.apps.setting.oauth.d {
        private C0156a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean Cf() throws Exception {
            com.baidu.tieba.aiapps.apps.a.a.a(a.this.mActivity, new com.baidu.swan.apps.an.c.a<Bundle>() { // from class: com.baidu.swan.apps.q.a.b.a.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: o */
                public void D(Bundle bundle) {
                    if (bundle == null) {
                        C0156a.this.m(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        a.this.mStoken = string;
                        C0156a.this.Ke();
                        return;
                    }
                    C0156a.this.m(new OAuthException("empty stoken", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
