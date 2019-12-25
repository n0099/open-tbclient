package com.baidu.live.data;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaLiveCloseData implements Serializable {
    public String actionScheme;
    public String actionText;
    public String tips;
    public String title;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.title = jSONObject.optString("title");
                this.tips = jSONObject.optString("tips");
                this.actionText = jSONObject.optString("action_txt");
                this.actionScheme = jSONObject.optString("action_scheme");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static JSONObject toJson(AlaLiveCloseData alaLiveCloseData) {
        if (alaLiveCloseData != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", alaLiveCloseData.title);
                jSONObject.put("tips", alaLiveCloseData.tips);
                jSONObject.put("action_txt", alaLiveCloseData.actionText);
                jSONObject.put("action_scheme", alaLiveCloseData.actionScheme);
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
