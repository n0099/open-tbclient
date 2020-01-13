package com.baidu.swan.apps.z.a.a;

import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e implements com.baidu.swan.apps.model.a {
    public ArrayList<c> bwk;
    public int strokeWidth = 1;
    public int ht = ViewCompat.MEASURED_STATE_MASK;
    public int bwa = 0;
    public int bwg = 0;

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
                this.strokeWidth = (int) Math.abs(com.baidu.swan.apps.z.a.d.f(jSONObject.optInt("strokeWidth", 1)));
                this.ht = com.baidu.swan.apps.z.a.d.D(jSONObject.optString("strokeColor"), ViewCompat.MEASURED_STATE_MASK);
                this.bwa = com.baidu.swan.apps.z.a.d.D(jSONObject.optString("fillColor"), 0);
                this.bwg = jSONObject.optInt("zIndex", 0);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.bwk == null || this.bwk.isEmpty()) ? false : true;
    }
}
