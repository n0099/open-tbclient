package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cs {
    public int aSt;
    public int aSu;
    public int aSv;
    public int aSw;
    public int aSx;
    public String aSy;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aSt = optJSONObject.optInt("android_tieba_type");
                this.aSu = optJSONObject.optInt("android_haokan_type");
                this.aSv = optJSONObject.optInt("android_quanmin_type");
                this.aSw = optJSONObject.optInt("android_yinbo_type");
            }
            this.aSx = jSONObject.optInt("display_limit", 3);
            this.aSy = jSONObject.optString("client_wishlist_tips");
        }
    }
}
