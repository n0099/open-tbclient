package com.baidu.swan.apps.w.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class g extends c {
    public com.baidu.swan.apps.w.a.a.c dfG;
    public String callBack = "";
    public String dfH = "";
    public String dfI = "";

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.callBack = jSONObject.optString("cb");
            double optDouble = jSONObject.optDouble("latitude");
            double optDouble2 = jSONObject.optDouble("longitude");
            this.dfH = jSONObject.optString("guideKey");
            this.dfI = jSONObject.optString("guideIcon");
            if (!Double.isNaN(optDouble) && !Double.isNaN(optDouble2) && optDouble >= -90.0d && optDouble <= 90.0d && optDouble2 >= -180.0d && optDouble2 <= 180.0d) {
                this.dfG = new com.baidu.swan.apps.w.a.a.c();
                this.dfG.parseFromJson(jSONObject);
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.dfG != null;
    }
}
