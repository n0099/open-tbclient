package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ai {
    public int aIU;
    public String aIV;
    public int aIW;
    public int aIX;
    public ak aIY;
    public int aIZ;
    public String aJa;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.aIU = jSONObject.optInt("taskid");
        this.aIV = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.aIW = jSONObject.optInt("cur_step");
        this.aIX = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.aIY = new ak();
            this.aIY.parseJson(optJSONObject);
        }
        this.aIZ = jSONObject.optInt("award_num");
        this.aJa = jSONObject.optString("taskdetail");
    }

    public boolean Dc() {
        return this.aIU == 1;
    }

    public boolean Dd() {
        return this.aIU == 6;
    }

    public boolean De() {
        return this.status == 2;
    }
}
