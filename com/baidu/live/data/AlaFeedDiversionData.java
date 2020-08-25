package com.baidu.live.data;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaFeedDiversionData implements Serializable {
    public AlaFrequencyData frequencyData;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.frequencyData = new AlaFrequencyData();
                this.frequencyData.parserJson(jSONObject.optJSONObject("frequency"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.frequencyData != null) {
                jSONObject.put("frequency", this.frequencyData.toJsonObject());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
