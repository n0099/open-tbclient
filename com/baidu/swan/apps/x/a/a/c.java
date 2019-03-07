package com.baidu.swan.apps.x.a.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements com.baidu.swan.apps.model.a {
    public double latitude = -200.0d;
    public double longitude = -200.0d;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("longitude") && jSONObject.has("latitude")) {
            this.latitude = jSONObject.optDouble("latitude", this.latitude);
            this.longitude = jSONObject.optDouble("longitude", this.longitude);
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.latitude >= -90.0d && this.latitude <= 90.0d && this.longitude >= -180.0d && this.longitude <= 180.0d;
    }

    public String toString() {
        return "[latitude：" + this.latitude + "longitude：" + this.longitude + "]";
    }
}
