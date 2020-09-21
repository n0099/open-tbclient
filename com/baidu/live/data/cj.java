package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cj {
    public int aNr;
    public int aNs;
    public int aNt;
    public int aNu;
    public String aNv;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aNr = optJSONObject.optInt("android_tieba_type");
                this.aNs = optJSONObject.optInt("android_haokan_type");
                this.aNt = optJSONObject.optInt("android_quanmin_type");
            }
            this.aNu = jSONObject.optInt("display_limit", 3);
            this.aNv = jSONObject.optString("client_wishlist_tips");
        }
    }
}
