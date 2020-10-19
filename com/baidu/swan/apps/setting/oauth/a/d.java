package com.baidu.swan.apps.setting.oauth.a;

import android.content.Context;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends h<JSONObject> {
    protected final Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aEP() {
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (aDa != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", aDa.id);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            co("data", jSONObject.toString());
            return true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bS */
    public JSONObject bL(JSONObject jSONObject) throws JSONException {
        return com.baidu.swan.apps.setting.oauth.c.bN(jSONObject);
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.ass().j(this.mContext, hVar.aFq());
    }
}
