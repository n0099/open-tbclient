package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class cb {
    public int aLG;
    public int aLH;
    public int aLI;
    public int aLJ;
    public String aLK;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aLG = optJSONObject.optInt("android_tieba_type");
                this.aLH = optJSONObject.optInt("android_haokan_type");
                this.aLI = optJSONObject.optInt("android_quanmin_type");
            }
            this.aLJ = jSONObject.optInt("display_limit", 3);
            this.aLK = jSONObject.optString("client_wishlist_tips");
        }
    }
}
