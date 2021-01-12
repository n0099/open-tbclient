package com.baidu.swan.pms.node.d;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.baidu.swan.pms.node.b {
    @Override // com.baidu.swan.pms.node.b
    public JSONArray bdj() {
        JSONArray jSONArray = new JSONArray();
        com.baidu.swan.pms.b bcc = com.baidu.swan.pms.d.bcc();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "bbasp_core");
            jSONObject.put(SharedPrefConfig.VERSION_NAME, bcc != null ? bcc.axL() : "0");
            jSONArray.put(jSONObject);
        } catch (JSONException e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                e.printStackTrace();
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", "bbasp_game");
            jSONObject2.put(SharedPrefConfig.VERSION_NAME, bcc != null ? bcc.axN() : "0");
            jSONArray.put(jSONObject2);
        } catch (JSONException e2) {
            if (com.baidu.swan.pms.d.DEBUG) {
                e2.printStackTrace();
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("type", ETAG.KEY_EXTENSION);
            jSONObject3.put(SharedPrefConfig.VERSION_NAME, bcc != null ? bcc.axM() : "0");
            jSONArray.put(jSONObject3);
        } catch (JSONException e3) {
            if (com.baidu.swan.pms.d.DEBUG) {
                e3.printStackTrace();
            }
        }
        return jSONArray;
    }
}
