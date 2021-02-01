package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class dc {
    public int aSY;
    public int aSZ;
    public int aTa;
    public int aTb;
    public int aTc;
    public String aTd;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aSY = optJSONObject.optInt("android_tieba_type");
                this.aSZ = optJSONObject.optInt("android_haokan_type");
                this.aTa = optJSONObject.optInt("android_quanmin_type");
                this.aTb = optJSONObject.optInt("android_yinbo_type");
            }
            this.aTc = jSONObject.optInt("display_limit", 3);
            this.aTd = jSONObject.optString("client_wishlist_tips");
        }
    }
}
