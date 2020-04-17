package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bo {
    public int axn;
    public int axo;
    public int axp;
    public int axq;
    public String axr;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.axn = optJSONObject.optInt("android_tieba_type");
                this.axo = optJSONObject.optInt("android_haokan_type");
                this.axp = optJSONObject.optInt("android_quanmin_type");
            }
            this.axq = jSONObject.optInt("display_limit", 3);
            this.axr = jSONObject.optString("client_wishlist_tips");
        }
    }
}
