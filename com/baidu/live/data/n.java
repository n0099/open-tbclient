package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n {
    public int Pw;
    public int Px;
    public String Py;
    public int mOpenType;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("live_type", Integer.valueOf(this.Pw));
            jSONObject.putOpt("open_type", Integer.valueOf(this.mOpenType));
            jSONObject.putOpt("screen_direction", Integer.valueOf(this.Px));
            jSONObject.putOpt("appid", this.Py);
            return jSONObject.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
