package com.baidu.live.data;

import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class x {
    public int azs;
    public int azt;
    public String mAppid;
    public int mOpenType;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("live_type", Integer.valueOf(this.azs));
            jSONObject.putOpt("open_type", Integer.valueOf(this.mOpenType));
            jSONObject.putOpt(AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION, Integer.valueOf(this.azt));
            jSONObject.putOpt("appid", this.mAppid);
            return jSONObject.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
