package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends g<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected final Activity mActivity;

    public d(Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean IN() {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", Ra.id);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            aI("data", jSONObject.toString());
            return true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: aG */
    public JSONObject Y(JSONObject jSONObject) throws JSONException {
        return com.baidu.swan.apps.setting.oauth.c.aE(jSONObject);
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.u.a.Jv().h(this.mActivity, gVar.Su());
    }
}
