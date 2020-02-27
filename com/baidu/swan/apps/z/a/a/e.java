package com.baidu.swan.apps.z.a.a;

import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e implements com.baidu.swan.apps.model.a {
    public ArrayList<c> bAt;
    public int strokeWidth = 1;
    public int hx = ViewCompat.MEASURED_STATE_MASK;
    public int bAj = 0;
    public int bAp = 0;

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
                this.strokeWidth = (int) Math.abs(com.baidu.swan.apps.z.a.d.f(jSONObject.optInt("strokeWidth", 1)));
                this.hx = com.baidu.swan.apps.z.a.d.B(jSONObject.optString("strokeColor"), ViewCompat.MEASURED_STATE_MASK);
                this.bAj = com.baidu.swan.apps.z.a.d.B(jSONObject.optString("fillColor"), 0);
                this.bAp = jSONObject.optInt("zIndex", 0);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.bAt == null || this.bAt.isEmpty()) ? false : true;
    }
}
