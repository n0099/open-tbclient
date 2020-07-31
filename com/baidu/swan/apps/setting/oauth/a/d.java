package com.baidu.swan.apps.setting.oauth.a;

import android.content.Context;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends g<JSONObject> {
    protected final Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean ato() {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", arv.id);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            bS("data", jSONObject.toString());
            return true;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bA */
    public JSONObject bt(JSONObject jSONObject) throws JSONException {
        return com.baidu.swan.apps.setting.oauth.c.bv(jSONObject);
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected HttpRequest a(g gVar) {
        return com.baidu.swan.apps.t.a.ahv().h(this.mContext, gVar.atO());
    }
}
