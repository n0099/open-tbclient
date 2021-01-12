package com.baidu.live.data;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaPersonPkData implements Serializable {
    public int pk_status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.pk_status = jSONObject.optInt("pk_status");
            } catch (Exception e) {
            }
        }
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pk_status", this.pk_status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
