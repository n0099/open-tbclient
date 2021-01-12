package com.baidu.swan.apps.w.a.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f implements com.baidu.swan.apps.model.a {
    public ArrayList<c> dfZ;
    public int color = 0;
    public float width = 0.0f;
    public boolean dga = false;
    public boolean dgb = false;
    public String dgc = "";
    public int borderColor = 0;
    public float borderWidth = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.dfZ = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.dfZ.add(cVar);
                        }
                    }
                }
            }
            if (this.dfZ != null && this.dfZ.size() > 0) {
                this.color = com.baidu.swan.apps.w.a.d.V(jSONObject.optString("color"), 0);
                this.width = Math.abs(com.baidu.swan.apps.w.a.d.o(jSONObject.optDouble("width", 0.0d)));
                this.dga = jSONObject.optBoolean("dottedLine", false);
                this.dgb = jSONObject.optBoolean("arrowLine", false);
                this.dgc = jSONObject.optString("arrowIconPath");
                this.borderColor = com.baidu.swan.apps.w.a.d.V(jSONObject.optString("borderColor"), 0);
                this.borderWidth = Math.abs(com.baidu.swan.apps.w.a.d.o(jSONObject.optDouble("borderWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.dfZ != null && this.dfZ.size() > 0;
    }
}
