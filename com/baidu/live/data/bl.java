package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bl {
    public int aeX;
    public int aeY;
    public int aeZ;
    public int afa;
    public String afb;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aeX = optJSONObject.optInt("android_tieba_type");
                this.aeY = optJSONObject.optInt("android_haokan_type");
                this.aeZ = optJSONObject.optInt("android_quanmin_type");
            }
            this.afa = jSONObject.optInt("display_limit", 3);
            this.afb = jSONObject.optString("client_wishlist_tips");
        }
    }
}
