package com.baidu.live.data;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaFrequencyData implements Serializable {
    public int startEveryLive = 0;
    public int everyDayUser = 0;
    public int everyDayDevice = 0;
    public int deviceNotClick = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.startEveryLive = jSONObject.optInt("start_every_live");
                this.everyDayUser = jSONObject.optInt("every_day_user");
                this.everyDayDevice = jSONObject.optInt("every_day_device");
                this.deviceNotClick = jSONObject.optInt("device_not_click");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("start_every_live", this.startEveryLive);
            jSONObject.put("every_day_user", this.everyDayUser);
            jSONObject.put("every_day_device", this.everyDayDevice);
            jSONObject.put("device_not_click", this.deviceNotClick);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
