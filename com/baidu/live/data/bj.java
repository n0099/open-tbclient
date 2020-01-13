package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bj {
    public int acL;
    public int acM;
    public int acN;
    public int acO;
    public String acP;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.acL = optJSONObject.optInt("android_tieba_type");
                this.acM = optJSONObject.optInt("android_haokan_type");
                this.acN = optJSONObject.optInt("android_quanmin_type");
            }
            this.acO = jSONObject.optInt("display_limit", 3);
            this.acP = jSONObject.optString("client_wishlist_tips");
        }
    }
}
