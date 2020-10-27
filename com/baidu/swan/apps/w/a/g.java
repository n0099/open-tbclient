package com.baidu.swan.apps.w.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g extends c {
    public com.baidu.swan.apps.w.a.a.c cUy;
    public String callBack = "";
    public String cUz = "";
    public String cUA = "";

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.callBack = jSONObject.optString("cb");
            double optDouble = jSONObject.optDouble("latitude");
            double optDouble2 = jSONObject.optDouble("longitude");
            this.cUz = jSONObject.optString("guideKey");
            this.cUA = jSONObject.optString("guideIcon");
            if (!Double.isNaN(optDouble) && !Double.isNaN(optDouble2) && optDouble >= -90.0d && optDouble <= 90.0d && optDouble2 >= -180.0d && optDouble2 <= 180.0d) {
                this.cUy = new com.baidu.swan.apps.w.a.a.c();
                this.cUy.parseFromJson(jSONObject);
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.cUy != null;
    }
}
