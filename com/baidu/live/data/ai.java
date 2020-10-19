package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ai {
    public int aLZ;
    public String aMa;
    public int aMb;
    public int aMc;
    public ak aMd;
    public int aMe;
    public String aMf;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.aLZ = jSONObject.optInt("taskid");
        this.aMa = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.aMb = jSONObject.optInt("cur_step");
        this.aMc = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.aMd = new ak();
            this.aMd.parseJson(optJSONObject);
        }
        this.aMe = jSONObject.optInt("award_num");
        this.aMf = jSONObject.optString("taskdetail");
    }

    public boolean DZ() {
        return this.aLZ == 1;
    }

    public boolean Ea() {
        return this.aLZ == 6;
    }

    public boolean Eb() {
        return this.status == 2;
    }
}
