package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class dc {
    public int aUA;
    public int aUB;
    public int aUC;
    public String aUD;
    public int aUy;
    public int aUz;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aUy = optJSONObject.optInt("android_tieba_type");
                this.aUz = optJSONObject.optInt("android_haokan_type");
                this.aUA = optJSONObject.optInt("android_quanmin_type");
                this.aUB = optJSONObject.optInt("android_yinbo_type");
            }
            this.aUC = jSONObject.optInt("display_limit", 3);
            this.aUD = jSONObject.optString("client_wishlist_tips");
        }
    }
}
