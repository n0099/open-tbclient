package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ar {
    public int UW;
    public String UX;
    public String UY;
    public String appKey;

    public ar(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.UW = jSONObject.optInt("goods_timeout");
            this.appKey = jSONObject.optString("app_key");
            this.UX = jSONObject.optString("live_goods_url");
            this.UY = jSONObject.optString("add_goods_url");
        }
    }
}
