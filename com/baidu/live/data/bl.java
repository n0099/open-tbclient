package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bl {
    public int aeN;
    public int aeO;
    public int aeP;
    public int aeQ;
    public String aeR;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aeN = optJSONObject.optInt("android_tieba_type");
                this.aeO = optJSONObject.optInt("android_haokan_type");
                this.aeP = optJSONObject.optInt("android_quanmin_type");
            }
            this.aeQ = jSONObject.optInt("display_limit", 3);
            this.aeR = jSONObject.optString("client_wishlist_tips");
        }
    }
}
