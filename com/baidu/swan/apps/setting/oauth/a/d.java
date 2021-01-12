package com.baidu.swan.apps.setting.oauth.a;

import android.content.Context;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends h<JSONObject> {
    protected final Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aKg() {
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", aIr.id);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            cz("data", jSONObject.toString());
            return true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: cf */
    public JSONObject bY(JSONObject jSONObject) throws JSONException {
        return com.baidu.swan.apps.setting.oauth.c.ca(jSONObject);
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.awK().j(this.mContext, hVar.aKH());
    }
}
