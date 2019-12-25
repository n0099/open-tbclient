package com.baidu.swan.b.f.a;

import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.b.d.a {
    public static final boolean DEBUG = b.DEBUG;

    public a() {
        super("getSid");
    }

    @Override // com.baidu.swan.b.d.a
    public com.baidu.swan.apps.api.b.b b(JSONObject jSONObject, com.baidu.swan.apps.p.b bVar) {
        String Er = com.baidu.swan.apps.w.a.Rn().Er();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("sid", Er);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        bVar.K(jSONObject2);
        return null;
    }
}
