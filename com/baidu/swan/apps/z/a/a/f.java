package com.baidu.swan.apps.z.a.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();
    public ArrayList<c> bwk;
    public int color = 0;
    public float width = 0.0f;
    public boolean bwl = false;
    public boolean bwm = false;
    public String bwn = "";
    public int borderColor = 0;
    public float bwh = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.bwk = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.bwk.add(cVar);
                        }
                    }
                }
            }
            if (this.bwk != null && this.bwk.size() > 0) {
                this.color = com.baidu.swan.apps.z.a.d.D(jSONObject.optString("color"), 0);
                this.width = Math.abs(com.baidu.swan.apps.z.a.d.f(jSONObject.optDouble("width", 0.0d)));
                this.bwl = jSONObject.optBoolean("dottedLine", false);
                this.bwm = jSONObject.optBoolean("arrowLine", false);
                this.bwn = jSONObject.optString("arrowIconPath");
                this.borderColor = com.baidu.swan.apps.z.a.d.D(jSONObject.optString("borderColor"), 0);
                this.bwh = Math.abs(com.baidu.swan.apps.z.a.d.f(jSONObject.optDouble("borderWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.bwk != null && this.bwk.size() > 0;
    }
}
