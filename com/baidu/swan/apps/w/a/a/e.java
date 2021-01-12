package com.baidu.swan.apps.w.a.a;

import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e implements com.baidu.swan.apps.model.a {
    public ArrayList<c> dfZ;
    public int strokeWidth = 1;
    public int strokeColor = ViewCompat.MEASURED_STATE_MASK;
    public int dfO = 0;
    public int axq = 0;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.dfZ = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.dfZ.add(cVar);
                        }
                    }
                }
            }
            if (this.dfZ != null && this.dfZ.size() > 0) {
                this.strokeWidth = (int) Math.abs(com.baidu.swan.apps.w.a.d.o(jSONObject.optInt("strokeWidth", 1)));
                this.strokeColor = com.baidu.swan.apps.w.a.d.V(jSONObject.optString("strokeColor"), ViewCompat.MEASURED_STATE_MASK);
                this.dfO = com.baidu.swan.apps.w.a.d.V(jSONObject.optString("fillColor"), 0);
                this.axq = jSONObject.optInt("zIndex", 0);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.dfZ == null || this.dfZ.isEmpty()) ? false : true;
    }
}
