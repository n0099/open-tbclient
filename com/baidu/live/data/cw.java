package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cw {
    public int aPV;
    public int aPW;
    public int aPX;
    public int aPY;
    public int aPZ;
    public String aQa;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aPV = optJSONObject.optInt("android_tieba_type");
                this.aPW = optJSONObject.optInt("android_haokan_type");
                this.aPX = optJSONObject.optInt("android_quanmin_type");
                this.aPY = optJSONObject.optInt("android_yinbo_type");
            }
            this.aPZ = jSONObject.optInt("display_limit", 3);
            this.aQa = jSONObject.optString("client_wishlist_tips");
        }
    }
}
