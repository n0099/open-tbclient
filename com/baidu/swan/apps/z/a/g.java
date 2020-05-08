package com.baidu.swan.apps.z.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g extends c {
    public com.baidu.swan.apps.z.a.a.c bYF;
    public String callBack = "";
    public String bYG = "";
    public String bYH = "";

    @Override // com.baidu.swan.apps.z.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.callBack = jSONObject.optString("cb");
            double optDouble = jSONObject.optDouble("latitude");
            double optDouble2 = jSONObject.optDouble("longitude");
            this.bYG = jSONObject.optString("guideKey");
            this.bYH = jSONObject.optString("guideIcon");
            if (!Double.isNaN(optDouble) && !Double.isNaN(optDouble2) && optDouble >= -90.0d && optDouble <= 90.0d && optDouble2 >= -180.0d && optDouble2 <= 180.0d) {
                this.bYF = new com.baidu.swan.apps.z.a.a.c();
                this.bYF.parseFromJson(jSONObject);
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.bYF != null;
    }
}
