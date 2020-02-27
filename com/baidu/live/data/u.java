package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {
    public int aaW;
    public String aaX;
    public int aaY;
    public int aaZ;
    public w aba;
    public int abb;
    public String abd;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.aaW = jSONObject.optInt("taskid");
        this.aaX = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.aaY = jSONObject.optInt("cur_step");
        this.aaZ = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.aba = new w();
            this.aba.parseJson(optJSONObject);
        }
        this.abb = jSONObject.optInt("award_num");
        this.abd = jSONObject.optString("taskdetail");
    }

    public boolean qz() {
        return this.aaW == 1;
    }

    public boolean qA() {
        return this.aaW == 6;
    }

    public boolean qB() {
        return this.status == 2;
    }
}
