package com.baidu.live.data;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaPersonChallengeData implements Serializable {
    public int challengeId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.challengeId = jSONObject.optInt("challenge_id");
            } catch (Exception e) {
            }
        }
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("challenge_id", this.challengeId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
