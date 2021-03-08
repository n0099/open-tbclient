package com.baidu.live.im.data;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    public String bg_color;
    public String bqV;
    public String bqW;
    public String bqX;
    public String bqY;
    public long bqZ;
    public String bra;
    public int live_type;
    public String user_name;

    public void W(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.live_type = jSONObject.optInt(UbcStatConstant.KEY_LIVE_TYPE);
            this.bqV = jSONObject.optString("tips_1_content");
            this.bqW = jSONObject.optString("tips_2_content");
            this.user_name = jSONObject.optString("user_name");
            this.bra = jSONObject.optString("foot_color");
            this.bg_color = jSONObject.optString("bg_color");
        }
    }

    public void X(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bqX = jSONObject.optString("user_name");
            this.bqY = jSONObject.optString("portrait");
            this.bqZ = jSONObject.optLong("user_id");
        }
    }
}
