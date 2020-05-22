package com.baidu.live.data;

import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class w {
    public int avX;
    public int avY;
    public String mAppid;
    public int mOpenType;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("live_type", Integer.valueOf(this.avX));
            jSONObject.putOpt("open_type", Integer.valueOf(this.mOpenType));
            jSONObject.putOpt(AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION, Integer.valueOf(this.avY));
            jSONObject.putOpt("appid", this.mAppid);
            return jSONObject.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
