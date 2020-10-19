package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ck {
    public int aQC;
    public int aQD;
    public int aQE;
    public int aQF;
    public String aQG;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aQC = optJSONObject.optInt("android_tieba_type");
                this.aQD = optJSONObject.optInt("android_haokan_type");
                this.aQE = optJSONObject.optInt("android_quanmin_type");
            }
            this.aQF = jSONObject.optInt("display_limit", 3);
            this.aQG = jSONObject.optString("client_wishlist_tips");
        }
    }
}
