package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class an {
    public int aOS;
    public String aOT;
    public int aOU;
    public int aOV;
    public ap aOW;
    public int aOX;
    public String aOY;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.aOS = jSONObject.optInt("taskid");
        this.aOT = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.aOU = jSONObject.optInt("cur_step");
        this.aOV = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.aOW = new ap();
            this.aOW.parseJson(optJSONObject);
        }
        this.aOX = jSONObject.optInt("award_num");
        this.aOY = jSONObject.optString("taskdetail");
    }

    public boolean FG() {
        return this.aOS == 1;
    }

    public boolean FH() {
        return this.aOS == 6;
    }

    public boolean FI() {
        return this.status == 2;
    }
}
