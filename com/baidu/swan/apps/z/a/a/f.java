package com.baidu.swan.apps.z.a.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();
    public ArrayList<c> bAt;
    public int color = 0;
    public float width = 0.0f;
    public boolean bAu = false;
    public boolean bAv = false;
    public String bAw = "";
    public int borderColor = 0;
    public float bAq = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.bAt = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.bAt.add(cVar);
                        }
                    }
                }
            }
            if (this.bAt != null && this.bAt.size() > 0) {
                this.color = com.baidu.swan.apps.z.a.d.B(jSONObject.optString("color"), 0);
                this.width = Math.abs(com.baidu.swan.apps.z.a.d.f(jSONObject.optDouble("width", 0.0d)));
                this.bAu = jSONObject.optBoolean("dottedLine", false);
                this.bAv = jSONObject.optBoolean("arrowLine", false);
                this.bAw = jSONObject.optString("arrowIconPath");
                this.borderColor = com.baidu.swan.apps.z.a.d.B(jSONObject.optString("borderColor"), 0);
                this.bAq = Math.abs(com.baidu.swan.apps.z.a.d.f(jSONObject.optDouble("borderWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.bAt != null && this.bAt.size() > 0;
    }
}
