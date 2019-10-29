package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ar {
    public int Vp;
    public String Vq;
    public String Vr;
    public String appKey;

    public ar(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Vp = jSONObject.optInt("goods_timeout");
            this.appKey = jSONObject.optString("app_key");
            this.Vq = jSONObject.optString("live_goods_url");
            this.Vr = jSONObject.optString("add_goods_url");
        }
    }
}
