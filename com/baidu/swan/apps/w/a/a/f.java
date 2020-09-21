package com.baidu.swan.apps.w.a.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f implements com.baidu.swan.apps.model.a {
    public ArrayList<c> cAk;
    public int color = 0;
    public float width = 0.0f;
    public boolean cAl = false;
    public boolean cAm = false;
    public String cAn = "";
    public int borderColor = 0;
    public float cAh = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.cAk = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.cAk.add(cVar);
                        }
                    }
                }
            }
            if (this.cAk != null && this.cAk.size() > 0) {
                this.color = com.baidu.swan.apps.w.a.d.P(jSONObject.optString("color"), 0);
                this.width = Math.abs(com.baidu.swan.apps.w.a.d.r(jSONObject.optDouble("width", 0.0d)));
                this.cAl = jSONObject.optBoolean("dottedLine", false);
                this.cAm = jSONObject.optBoolean("arrowLine", false);
                this.cAn = jSONObject.optString("arrowIconPath");
                this.borderColor = com.baidu.swan.apps.w.a.d.P(jSONObject.optString("borderColor"), 0);
                this.cAh = Math.abs(com.baidu.swan.apps.w.a.d.r(jSONObject.optDouble("borderWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.cAk != null && this.cAk.size() > 0;
    }
}
