package com.baidu.swan.apps.w.a.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f implements com.baidu.swan.apps.model.a {
    public ArrayList<c> daF;
    public int color = 0;
    public float width = 0.0f;
    public boolean daG = false;
    public boolean daH = false;
    public String daI = "";
    public int borderColor = 0;
    public float daC = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.daF = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.daF.add(cVar);
                        }
                    }
                }
            }
            if (this.daF != null && this.daF.size() > 0) {
                this.color = com.baidu.swan.apps.w.a.d.S(jSONObject.optString("color"), 0);
                this.width = Math.abs(com.baidu.swan.apps.w.a.d.v(jSONObject.optDouble("width", 0.0d)));
                this.daG = jSONObject.optBoolean("dottedLine", false);
                this.daH = jSONObject.optBoolean("arrowLine", false);
                this.daI = jSONObject.optString("arrowIconPath");
                this.borderColor = com.baidu.swan.apps.w.a.d.S(jSONObject.optString("borderColor"), 0);
                this.daC = Math.abs(com.baidu.swan.apps.w.a.d.v(jSONObject.optDouble("borderWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.daF != null && this.daF.size() > 0;
    }
}
