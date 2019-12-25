package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bf {
    public int acA;
    public int acB;
    public int acC;
    public String acD;
    public int acz;

    public void o(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.acz = optJSONObject.optInt("android_tieba_type");
                this.acA = optJSONObject.optInt("android_haokan_type");
                this.acB = optJSONObject.optInt("android_quanmin_type");
            }
            this.acC = jSONObject.optInt("display_limit", 3);
            this.acD = jSONObject.optString("client_wishlist_tips");
        }
    }
}
