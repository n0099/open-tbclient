package com.baidu.swan.apps.w.a.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();
    public ArrayList<c> cqp;
    public int color = 0;
    public float width = 0.0f;
    public boolean cqq = false;
    public boolean cqr = false;
    public String cqs = "";
    public int borderColor = 0;
    public float cqm = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.cqp = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.cqp.add(cVar);
                        }
                    }
                }
            }
            if (this.cqp != null && this.cqp.size() > 0) {
                this.color = com.baidu.swan.apps.w.a.d.N(jSONObject.optString("color"), 0);
                this.width = Math.abs(com.baidu.swan.apps.w.a.d.k(jSONObject.optDouble("width", 0.0d)));
                this.cqq = jSONObject.optBoolean("dottedLine", false);
                this.cqr = jSONObject.optBoolean("arrowLine", false);
                this.cqs = jSONObject.optString("arrowIconPath");
                this.borderColor = com.baidu.swan.apps.w.a.d.N(jSONObject.optString("borderColor"), 0);
                this.cqm = Math.abs(com.baidu.swan.apps.w.a.d.k(jSONObject.optDouble("borderWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.cqp != null && this.cqp.size() > 0;
    }
}
