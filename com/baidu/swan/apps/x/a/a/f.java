package com.baidu.swan.apps.x.a.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();
    public ArrayList<c> azm;
    public int color = 0;
    public float width = 0.0f;
    public boolean azo = false;
    public boolean azp = false;
    public String azq = "";
    public int borderColor = 0;
    public float azk = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.azm = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.azm.add(cVar);
                        }
                    }
                }
            }
            if (this.azm != null && this.azm.size() > 0) {
                this.color = com.baidu.swan.apps.x.a.d.E(jSONObject.optString("color"), 0);
                this.width = Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("width", 0.0d)));
                this.azo = jSONObject.optBoolean("dottedLine", false);
                this.azp = jSONObject.optBoolean("arrowLine", false);
                this.azq = jSONObject.optString("arrowIconPath");
                this.borderColor = com.baidu.swan.apps.x.a.d.E(jSONObject.optString("borderColor"), 0);
                this.azk = Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("borderWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.azm != null && this.azm.size() > 0;
    }
}
