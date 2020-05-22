package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bt {
    public int aCJ;
    public int aCK;
    public int aCL;
    public int aCM;
    public String aCN;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aCJ = optJSONObject.optInt("android_tieba_type");
                this.aCK = optJSONObject.optInt("android_haokan_type");
                this.aCL = optJSONObject.optInt("android_quanmin_type");
            }
            this.aCM = jSONObject.optInt("display_limit", 3);
            this.aCN = jSONObject.optString("client_wishlist_tips");
        }
    }
}
