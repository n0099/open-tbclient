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
    public boolean IL() {
        a(new C0205a());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.b
    protected boolean IM() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Rq().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", Rq().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject2.put("stoken", this.mStoken);
            String BQ = com.baidu.swan.apps.u.a.Ju().BQ();
            if (!TextUtils.isEmpty(BQ)) {
                jSONObject2.put("host_api_key", BQ);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.box));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aI("data", jSONObject.toString());
        if (this.box) {
            St();
            return true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.b
    /* renamed from: W */
    public a.C0221a X(JSONObject jSONObject) throws JSONException {
        com.baidu.tieba.aiapps.apps.a.c.b(this.mActivity, jSONObject);
        return super.X(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.a, com.baidu.swan.apps.setting.oauth.a.g
    public void IN() {
        super.IN();
        com.baidu.swan.apps.network.c.b.a.MZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.q.a.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0205a extends com.baidu.swan.apps.setting.oauth.d {
        private C0205a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean IO() throws Exception {
            com.baidu.tieba.aiapps.apps.a.c.a(a.this.mActivity, new com.baidu.swan.apps.an.d.a<Bundle>() { // from class: com.baidu.swan.apps.q.a.b.a.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: o */
                public void B(Bundle bundle) {
                    if (bundle == null) {
                        C0205a.this.m(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString("dev", "");
                    if (!TextUtils.isEmpty(string)) {
                        a.this.mStoken = string;
                        C0205a.this.Sn();
                        return;
                    }
                    C0205a.this.m(new OAuthException("empty stoken", 10001));
                }
            }, "dev");
            return false;
        }
    }
}
