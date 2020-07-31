package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bz {
    public String aGA;
    public int aGw;
    public int aGx;
    public int aGy;
    public int aGz;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aGw = optJSONObject.optInt("android_tieba_type");
                this.aGx = optJSONObject.optInt("android_haokan_type");
                this.aGy = optJSONObject.optInt("android_quanmin_type");
            }
            this.aGz = jSONObject.optInt("display_limit", 3);
            this.aGA = jSONObject.optString("client_wishlist_tips");
        }
    }
}
