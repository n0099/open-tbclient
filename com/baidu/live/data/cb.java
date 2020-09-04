package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class cb {
    public int aLI;
    public int aLJ;
    public int aLK;
    public int aLL;
    public String aLM;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aLI = optJSONObject.optInt("android_tieba_type");
                this.aLJ = optJSONObject.optInt("android_haokan_type");
                this.aLK = optJSONObject.optInt("android_quanmin_type");
            }
            this.aLL = jSONObject.optInt("display_limit", 3);
            this.aLM = jSONObject.optString("client_wishlist_tips");
        }
    }
}
