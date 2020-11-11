package com.baidu.swan.gamecenter.e.b;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.baidu.swan.gamecenter.c.a {
    public static final boolean DEBUG = b.DEBUG;

    public a() {
        super("getSid");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(JSONObject jSONObject, com.baidu.swan.apps.o.b bVar) {
        String agn = com.baidu.swan.apps.t.a.awD().agn();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(UbcStatConstant.KEY_CONTENT_EXT_SID, agn);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        bVar.aE(jSONObject2);
        return null;
    }
}
