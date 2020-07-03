package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class by {
    public int aFb;
    public int aFc;
    public int aFd;
    public int aFe;
    public String aFf;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aFb = optJSONObject.optInt("android_tieba_type");
                this.aFc = optJSONObject.optInt("android_haokan_type");
                this.aFd = optJSONObject.optInt("android_quanmin_type");
            }
            this.aFe = jSONObject.optInt("display_limit", 3);
            this.aFf = jSONObject.optString("client_wishlist_tips");
        }
    }
}
