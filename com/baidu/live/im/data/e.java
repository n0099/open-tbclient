package com.baidu.live.im.data;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public String bg_color;
    public String bpA;
    public String bpv;
    public String bpw;
    public String bpx;
    public String bpy;
    public long bpz;
    public int live_type;
    public String user_name;

    public void U(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.live_type = jSONObject.optInt(UbcStatConstant.KEY_LIVE_TYPE);
            this.bpv = jSONObject.optString("tips_1_content");
            this.bpw = jSONObject.optString("tips_2_content");
            this.user_name = jSONObject.optString("user_name");
            this.bpA = jSONObject.optString("foot_color");
            this.bg_color = jSONObject.optString("bg_color");
        }
    }

    public void V(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bpx = jSONObject.optString("user_name");
            this.bpy = jSONObject.optString("portrait");
            this.bpz = jSONObject.optLong("user_id");
        }
    }
}
