package com.baidu.swan.apps.z.a.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();
    public ArrayList<c> bAu;
    public int color = 0;
    public float width = 0.0f;
    public boolean bAv = false;
    public boolean bAw = false;
    public String bAx = "";
    public int borderColor = 0;
    public float bAr = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.bAu = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.bAu.add(cVar);
                        }
                    }
                }
            }
            if (this.bAu != null && this.bAu.size() > 0) {
                this.color = com.baidu.swan.apps.z.a.d.B(jSONObject.optString("color"), 0);
                this.width = Math.abs(com.baidu.swan.apps.z.a.d.f(jSONObject.optDouble("width", 0.0d)));
                this.bAv = jSONObject.optBoolean("dottedLine", false);
                this.bAw = jSONObject.optBoolean("arrowLine", false);
                this.bAx = jSONObject.optString("arrowIconPath");
                this.borderColor = com.baidu.swan.apps.z.a.d.B(jSONObject.optString("borderColor"), 0);
                this.bAr = Math.abs(com.baidu.swan.apps.z.a.d.f(jSONObject.optDouble("borderWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.bAu != null && this.bAu.size() > 0;
    }
}
