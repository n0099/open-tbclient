package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cp {
    public int aRn;
    public int aRo;
    public int aRp;
    public int aRq;
    public String aRr;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aRn = optJSONObject.optInt("android_tieba_type");
                this.aRo = optJSONObject.optInt("android_haokan_type");
                this.aRp = optJSONObject.optInt("android_quanmin_type");
            }
            this.aRq = jSONObject.optInt("display_limit", 3);
            this.aRr = jSONObject.optString("client_wishlist_tips");
        }
    }
}
