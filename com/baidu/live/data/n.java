package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n {
    public int Qc;
    public int Qd;
    public String Qe;
    public int mOpenType;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("live_type", Integer.valueOf(this.Qc));
            jSONObject.putOpt("open_type", Integer.valueOf(this.mOpenType));
            jSONObject.putOpt("screen_direction", Integer.valueOf(this.Qd));
            jSONObject.putOpt("appid", this.Qe);
            return jSONObject.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
