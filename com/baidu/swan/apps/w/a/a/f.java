package com.baidu.swan.apps.w.a.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f implements com.baidu.swan.apps.model.a {
    public ArrayList<c> dil;
    public int color = 0;
    public float width = 0.0f;
    public boolean dim = false;
    public boolean din = false;
    public String dio = "";
    public int borderColor = 0;
    public float borderWidth = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.dil = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.dil.add(cVar);
                        }
                    }
                }
            }
            if (this.dil != null && this.dil.size() > 0) {
                this.color = com.baidu.swan.apps.w.a.d.X(jSONObject.optString("color"), 0);
                this.width = Math.abs(com.baidu.swan.apps.w.a.d.o(jSONObject.optDouble("width", 0.0d)));
                this.dim = jSONObject.optBoolean("dottedLine", false);
                this.din = jSONObject.optBoolean("arrowLine", false);
                this.dio = jSONObject.optString("arrowIconPath");
                this.borderColor = com.baidu.swan.apps.w.a.d.X(jSONObject.optString("borderColor"), 0);
                this.borderWidth = Math.abs(com.baidu.swan.apps.w.a.d.o(jSONObject.optDouble("borderWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.dil != null && this.dil.size() > 0;
    }
}
