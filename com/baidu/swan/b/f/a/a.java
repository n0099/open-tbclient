package com.baidu.swan.b.f.a;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.b.d.a {
    public static final boolean DEBUG = b.DEBUG;

    public a() {
        super("getSid");
    }

    @Override // com.baidu.swan.b.d.a
    public com.baidu.swan.apps.api.b.b b(JSONObject jSONObject, com.baidu.swan.apps.p.b bVar) {
        String OW = com.baidu.swan.apps.w.a.abR().OW();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(UbcStatConstant.KEY_CONTENT_EXT_SID, OW);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        bVar.V(jSONObject2);
        return null;
    }
}
