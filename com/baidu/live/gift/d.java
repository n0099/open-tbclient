package com.baidu.live.gift;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public boolean aVy;
    public int frame_count;
    public int frame_rate;
    public int height;
    public int isBottomMargin = 0;
    public double oppositeX;
    public double oppositeY;
    public int repeatCount;
    public double userInfoX;
    public double userInfoY;
    public int width;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.frame_rate = jSONObject.optInt("frame_rate");
            if (this.frame_rate <= 0) {
                this.frame_rate = 15;
            }
            this.frame_count = jSONObject.optInt("frame_count");
            this.isBottomMargin = jSONObject.optInt("is_bottom_margin");
            this.width = jSONObject.optInt("width");
            this.height = jSONObject.optInt("height");
            this.oppositeX = jSONObject.optDouble("opposite_x");
            this.oppositeY = jSONObject.optDouble("opposite_y");
            this.repeatCount = jSONObject.optInt("repeat_count");
            this.userInfoX = jSONObject.optDouble("user_info_x");
            this.userInfoY = jSONObject.optDouble("user_info_y");
            this.aVy = jSONObject.optInt("relative", 0) == 0;
        }
    }

    public boolean isBottomMargin() {
        return this.isBottomMargin == 1;
    }
}
