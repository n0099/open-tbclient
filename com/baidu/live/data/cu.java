package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cu {
    public int aTK;
    public int aTL;
    public int aTM;
    public int aTN;
    public int aTO;
    public String aTP;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aTK = optJSONObject.optInt("android_tieba_type");
                this.aTL = optJSONObject.optInt("android_haokan_type");
                this.aTM = optJSONObject.optInt("android_quanmin_type");
                this.aTN = optJSONObject.optInt("android_yinbo_type");
            }
            this.aTO = jSONObject.optInt("display_limit", 3);
            this.aTP = jSONObject.optString("client_wishlist_tips");
        }
    }
}
