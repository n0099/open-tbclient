package com.baidu.searchbox.ng.ai.apps.impl.map.model.element;

import com.baidu.searchbox.ng.ai.apps.model.IModel;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CoordinateModel implements IModel {
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public double latitude = -200.0d;
    public double longitude = -200.0d;

    @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has(LONGITUDE) && jSONObject.has(LATITUDE)) {
            this.latitude = jSONObject.optDouble(LATITUDE, this.latitude);
            this.longitude = jSONObject.optDouble(LONGITUDE, this.longitude);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return this.latitude >= -90.0d && this.latitude <= 90.0d && this.longitude >= -180.0d && this.longitude <= 180.0d;
    }

    public String toString() {
        return "[latitude：" + this.latitude + "longitude：" + this.longitude + "]";
    }
}
