package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends g<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected final Activity mActivity;

    public d(Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aqq() {
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", aoF.id);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            bP("data", jSONObject.toString());
            return true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bo */
    public JSONObject bh(JSONObject jSONObject) throws JSONException {
        return com.baidu.swan.apps.setting.oauth.c.bj(jSONObject);
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected HttpRequest a(g gVar) {
        return com.baidu.swan.apps.u.a.afd().h(this.mActivity, gVar.aqM());
    }
}
