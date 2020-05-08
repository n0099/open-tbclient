package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import okhttp3.Request;
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
    protected boolean amn() {
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        if (akM != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", akM.id);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            bu("data", jSONObject.toString());
            return true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bf */
    public JSONObject aY(JSONObject jSONObject) throws JSONException {
        return com.baidu.swan.apps.setting.oauth.c.ba(jSONObject);
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.w.a.abZ().h(this.mActivity, gVar.amI());
    }
}
