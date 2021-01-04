package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cw {
    public int aUI;
    public int aUJ;
    public int aUK;
    public int aUL;
    public int aUM;
    public String aUN;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aUI = optJSONObject.optInt("android_tieba_type");
                this.aUJ = optJSONObject.optInt("android_haokan_type");
                this.aUK = optJSONObject.optInt("android_quanmin_type");
                this.aUL = optJSONObject.optInt("android_yinbo_type");
            }
            this.aUM = jSONObject.optInt("display_limit", 3);
            this.aUN = jSONObject.optString("client_wishlist_tips");
        }
    }
}
