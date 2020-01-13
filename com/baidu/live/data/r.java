package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r {
    public int WL;
    public int WM;
    public String mAppid;
    public int mOpenType;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("live_type", Integer.valueOf(this.WL));
            jSONObject.putOpt("open_type", Integer.valueOf(this.mOpenType));
            jSONObject.putOpt("screen_direction", Integer.valueOf(this.WM));
            jSONObject.putOpt("appid", this.mAppid);
            return jSONObject.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
