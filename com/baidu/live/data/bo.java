package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bo {
    public int axt;
    public int axu;
    public int axv;
    public int axw;
    public String axx;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.axt = optJSONObject.optInt("android_tieba_type");
                this.axu = optJSONObject.optInt("android_haokan_type");
                this.axv = optJSONObject.optInt("android_quanmin_type");
            }
            this.axw = jSONObject.optInt("display_limit", 3);
            this.axx = jSONObject.optString("client_wishlist_tips");
        }
    }
}
