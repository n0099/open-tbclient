package com.baidu.swan.apps.z.a.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();
    public ArrayList<c> bYN;
    public int color = 0;
    public float width = 0.0f;
    public boolean bYO = false;
    public boolean bYP = false;
    public String bYQ = "";
    public int borderColor = 0;
    public float bYK = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.bYN = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.bYN.add(cVar);
                        }
                    }
                }
            }
            if (this.bYN != null && this.bYN.size() > 0) {
                this.color = com.baidu.swan.apps.z.a.d.J(jSONObject.optString("color"), 0);
                this.width = Math.abs(com.baidu.swan.apps.z.a.d.k(jSONObject.optDouble("width", 0.0d)));
                this.bYO = jSONObject.optBoolean("dottedLine", false);
                this.bYP = jSONObject.optBoolean("arrowLine", false);
                this.bYQ = jSONObject.optString("arrowIconPath");
                this.borderColor = com.baidu.swan.apps.z.a.d.J(jSONObject.optString("borderColor"), 0);
                this.bYK = Math.abs(com.baidu.swan.apps.z.a.d.k(jSONObject.optDouble("borderWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.bYN != null && this.bYN.size() > 0;
    }
}
