package com.baidu.swan.apps.x.a.a;

import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e implements com.baidu.swan.apps.model.a {
    public ArrayList<c> aUq;
    public int strokeWidth = 1;
    public int fJ = ViewCompat.MEASURED_STATE_MASK;
    public int aUf = 0;
    public int aUr = 0;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.aUq = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.aUq.add(cVar);
                        }
                    }
                }
            }
            if (this.aUq != null && this.aUq.size() > 0) {
                this.strokeWidth = (int) Math.abs(com.baidu.swan.apps.x.a.d.e(jSONObject.optInt("strokeWidth", 1)));
                this.fJ = com.baidu.swan.apps.x.a.d.B(jSONObject.optString("strokeColor"), ViewCompat.MEASURED_STATE_MASK);
                this.aUf = com.baidu.swan.apps.x.a.d.B(jSONObject.optString("fillColor"), 0);
                this.aUr = jSONObject.optInt("zIndex", 0);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.aUq == null || this.aUq.isEmpty()) ? false : true;
    }
}
