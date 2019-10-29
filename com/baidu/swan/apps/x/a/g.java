package com.baidu.swan.apps.x.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends c {
    public com.baidu.swan.apps.x.a.a.c aUu;
    public String callBack = "";
    public String aUv = "";
    public String aUw = "";

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.callBack = jSONObject.optString("cb");
            double optDouble = jSONObject.optDouble("latitude");
            double optDouble2 = jSONObject.optDouble("longitude");
            this.aUv = jSONObject.optString("guideKey");
            this.aUw = jSONObject.optString("guideIcon");
            if (!Double.isNaN(optDouble) && !Double.isNaN(optDouble2) && optDouble >= -90.0d && optDouble <= 90.0d && optDouble2 >= -180.0d && optDouble2 <= 180.0d) {
                this.aUu = new com.baidu.swan.apps.x.a.a.c();
                this.aUu.parseFromJson(jSONObject);
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.aUu != null;
    }
}
