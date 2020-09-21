package com.baidu.swan.apps.w.a.a;

import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements com.baidu.swan.apps.model.a {
    public ArrayList<c> cAk;
    public int strokeWidth = 1;
    public int strokeColor = ViewCompat.MEASURED_STATE_MASK;
    public int fillColor = 0;
    public int cAg = 0;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.cAk = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.cAk.add(cVar);
                        }
                    }
                }
            }
            if (this.cAk != null && this.cAk.size() > 0) {
                this.strokeWidth = (int) Math.abs(com.baidu.swan.apps.w.a.d.r(jSONObject.optInt("strokeWidth", 1)));
                this.strokeColor = com.baidu.swan.apps.w.a.d.P(jSONObject.optString("strokeColor"), ViewCompat.MEASURED_STATE_MASK);
                this.fillColor = com.baidu.swan.apps.w.a.d.P(jSONObject.optString("fillColor"), 0);
                this.cAg = jSONObject.optInt("zIndex", 0);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.cAk == null || this.cAk.isEmpty()) ? false : true;
    }
}
