package com.baidu.swan.apps.w.a.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f implements com.baidu.swan.apps.model.a {
    public ArrayList<c> cMp;
    public int color = 0;
    public float width = 0.0f;
    public boolean cMq = false;
    public boolean cMr = false;
    public String cMs = "";
    public int borderColor = 0;
    public float cMm = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.cMp = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.cMp.add(cVar);
                        }
                    }
                }
            }
            if (this.cMp != null && this.cMp.size() > 0) {
                this.color = com.baidu.swan.apps.w.a.d.Q(jSONObject.optString("color"), 0);
                this.width = Math.abs(com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("width", 0.0d)));
                this.cMq = jSONObject.optBoolean("dottedLine", false);
                this.cMr = jSONObject.optBoolean("arrowLine", false);
                this.cMs = jSONObject.optString("arrowIconPath");
                this.borderColor = com.baidu.swan.apps.w.a.d.Q(jSONObject.optString("borderColor"), 0);
                this.cMm = Math.abs(com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("borderWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.cMp != null && this.cMp.size() > 0;
    }
}
