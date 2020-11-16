package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cs {
    public int aQI;
    public int aQJ;
    public int aQK;
    public int aQL;
    public int aQM;
    public String aQN;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aQI = optJSONObject.optInt("android_tieba_type");
                this.aQJ = optJSONObject.optInt("android_haokan_type");
                this.aQK = optJSONObject.optInt("android_quanmin_type");
                this.aQL = optJSONObject.optInt("android_yinbo_type");
            }
            this.aQM = jSONObject.optInt("display_limit", 3);
            this.aQN = jSONObject.optString("client_wishlist_tips");
        }
    }
}
