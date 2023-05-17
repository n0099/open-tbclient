package com.baidu.searchbox.crius.ui.swiper;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwiperAttrs {
    public int autoPlay = 3000;
    public String id;

    public static SwiperAttrs parse(JSONObject jSONObject) {
        SwiperAttrs swiperAttrs = new SwiperAttrs();
        if (jSONObject == null) {
            return swiperAttrs;
        }
        swiperAttrs.id = jSONObject.optString("swiper-id", "");
        swiperAttrs.autoPlay = jSONObject.optInt("autoplay-duration", 3000);
        return swiperAttrs;
    }
}
