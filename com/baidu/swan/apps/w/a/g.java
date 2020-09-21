package com.baidu.swan.apps.w.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends c {
    public com.baidu.swan.apps.w.a.a.c czX;
    public String callBack = "";
    public String czY = "";
    public String czZ = "";

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.callBack = jSONObject.optString("cb");
            double optDouble = jSONObject.optDouble("latitude");
            double optDouble2 = jSONObject.optDouble("longitude");
            this.czY = jSONObject.optString("guideKey");
            this.czZ = jSONObject.optString("guideIcon");
            if (!Double.isNaN(optDouble) && !Double.isNaN(optDouble2) && optDouble >= -90.0d && optDouble <= 90.0d && optDouble2 >= -180.0d && optDouble2 <= 180.0d) {
                this.czX = new com.baidu.swan.apps.w.a.a.c();
                this.czX.parseFromJson(jSONObject);
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.czX != null;
    }
}
