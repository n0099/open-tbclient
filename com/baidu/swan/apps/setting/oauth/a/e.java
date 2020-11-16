package com.baidu.swan.apps.setting.oauth.a;

import android.content.Context;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e extends h<JSONObject> {
    protected final Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aIB() {
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", aGM.id);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            cu("data", jSONObject.toString());
            return true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bV */
    public JSONObject bO(JSONObject jSONObject) throws JSONException {
        return com.baidu.swan.apps.setting.oauth.c.bQ(jSONObject);
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.awe().i(this.mContext, hVar.aJc());
    }
}
