package com.baidu.swan.apps.x.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends c {
    public com.baidu.swan.apps.x.a.a.c azd;
    public String callBack = "";
    public String aze = "";
    public String azf = "";

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.callBack = jSONObject.optString("cb");
            double optDouble = jSONObject.optDouble("latitude");
            double optDouble2 = jSONObject.optDouble("longitude");
            this.aze = jSONObject.optString("guideKey");
            this.azf = jSONObject.optString("guideIcon");
            if (!Double.isNaN(optDouble) && !Double.isNaN(optDouble2) && optDouble >= -90.0d && optDouble <= 90.0d && optDouble2 >= -180.0d && optDouble2 <= 180.0d) {
                this.azd = new com.baidu.swan.apps.x.a.a.c();
                this.azd.parseFromJson(jSONObject);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.azd != null;
    }
}
