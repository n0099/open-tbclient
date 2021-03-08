package com.baidu.live.data;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ap {
    public int aLA;
    public int aLB;
    public String mAppid;
    public int mOpenType;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UbcStatConstant.KEY_LIVE_TYPE, Integer.valueOf(this.aLA));
            jSONObject.putOpt("open_type", Integer.valueOf(this.mOpenType));
            jSONObject.putOpt("screen_direction", Integer.valueOf(this.aLB));
            jSONObject.putOpt("appid", this.mAppid);
            return jSONObject.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
