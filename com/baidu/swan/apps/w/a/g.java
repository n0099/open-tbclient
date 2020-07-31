package com.baidu.swan.apps.w.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends c {
    public com.baidu.swan.apps.w.a.a.c cqc;
    public String callBack = "";
    public String cqd = "";
    public String cqe = "";

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.callBack = jSONObject.optString("cb");
            double optDouble = jSONObject.optDouble("latitude");
            double optDouble2 = jSONObject.optDouble("longitude");
            this.cqd = jSONObject.optString("guideKey");
            this.cqe = jSONObject.optString("guideIcon");
            if (!Double.isNaN(optDouble) && !Double.isNaN(optDouble2) && optDouble >= -90.0d && optDouble <= 90.0d && optDouble2 >= -180.0d && optDouble2 <= 180.0d) {
                this.cqc = new com.baidu.swan.apps.w.a.a.c();
                this.cqc.parseFromJson(jSONObject);
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.cqc != null;
    }
}
