package com.baidu.swan.apps.w.a.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f implements com.baidu.swan.apps.model.a {
    public ArrayList<c> cYV;
    public int color = 0;
    public float width = 0.0f;
    public boolean cYW = false;
    public boolean cYX = false;
    public String cYY = "";
    public int borderColor = 0;
    public float cYR = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.cYV = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.cYV.add(cVar);
                        }
                    }
                }
            }
            if (this.cYV != null && this.cYV.size() > 0) {
                this.color = com.baidu.swan.apps.w.a.d.S(jSONObject.optString("color"), 0);
                this.width = Math.abs(com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("width", 0.0d)));
                this.cYW = jSONObject.optBoolean("dottedLine", false);
                this.cYX = jSONObject.optBoolean("arrowLine", false);
                this.cYY = jSONObject.optString("arrowIconPath");
                this.borderColor = com.baidu.swan.apps.w.a.d.S(jSONObject.optString("borderColor"), 0);
                this.cYR = Math.abs(com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("borderWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.cYV != null && this.cYV.size() > 0;
    }
}
