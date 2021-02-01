package com.baidu.ala.gift;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaDynamicGiftConfigInfo implements Serializable {
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
            this.frame_count = jSONObject.optInt("frame_count");
            this.isBottomMargin = jSONObject.optInt("is_bottom_margin");
            this.width = jSONObject.optInt("width");
            this.height = jSONObject.optInt("height");
            this.oppositeX = jSONObject.optDouble("opposite_x");
            this.oppositeY = jSONObject.optDouble("opposite_y");
            this.repeatCount = jSONObject.optInt("repeat_count");
            this.userInfoX = jSONObject.optDouble("user_info_x");
            this.userInfoY = jSONObject.optDouble("user_info_y");
        }
    }

    public boolean isBottomMargin() {
        return this.isBottomMargin == 1;
    }
}
