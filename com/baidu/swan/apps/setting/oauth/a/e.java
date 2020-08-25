package com.baidu.swan.apps.setting.oauth.a;

import android.content.Context;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends h<JSONObject> {
    protected final Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aBw() {
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", azI.id);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            cj("data", jSONObject.toString());
            return true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bI */
    public JSONObject bB(JSONObject jSONObject) throws JSONException {
        return com.baidu.swan.apps.setting.oauth.c.bD(jSONObject);
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.aoV().i(this.mContext, hVar.aBX());
    }
}
