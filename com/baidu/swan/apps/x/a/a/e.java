package com.baidu.swan.apps.x.a.a;

import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e implements com.baidu.swan.apps.model.a {
    public ArrayList<c> cok;
    public int strokeWidth = 1;
    public int DD = ViewCompat.MEASURED_STATE_MASK;
    public int cnZ = 0;
    public int cog = 0;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.cok = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.parseFromJson(optJSONObject);
                        if (cVar.isValid()) {
                            this.cok.add(cVar);
                        }
                    }
                }
            }
            if (this.cok != null && this.cok.size() > 0) {
                this.strokeWidth = (int) Math.abs(com.baidu.swan.apps.x.a.d.k(jSONObject.optInt("strokeWidth", 1)));
                this.DD = com.baidu.swan.apps.x.a.d.N(jSONObject.optString("strokeColor"), ViewCompat.MEASURED_STATE_MASK);
                this.cnZ = com.baidu.swan.apps.x.a.d.N(jSONObject.optString("fillColor"), 0);
                this.cog = jSONObject.optInt("zIndex", 0);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.cok == null || this.cok.isEmpty()) ? false : true;
    }
}
