package com.baidu.swan.apps.w.a.a;

import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e implements com.baidu.swan.apps.model.a {
    public ArrayList<c> djO;
    public int strokeWidth = 1;
    public int strokeColor = ViewCompat.MEASURED_STATE_MASK;
    public int djD = 0;
    public int azd = 0;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.djO = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.djO.add(cVar);
                        }
                    }
                }
            }
            if (this.djO != null && this.djO.size() > 0) {
                this.strokeWidth = (int) Math.abs(com.baidu.swan.apps.w.a.d.o(jSONObject.optInt("strokeWidth", 1)));
                this.strokeColor = com.baidu.swan.apps.w.a.d.Y(jSONObject.optString("strokeColor"), ViewCompat.MEASURED_STATE_MASK);
                this.djD = com.baidu.swan.apps.w.a.d.Y(jSONObject.optString("fillColor"), 0);
                this.azd = jSONObject.optInt("zIndex", 0);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.djO == null || this.djO.isEmpty()) ? false : true;
    }
}
