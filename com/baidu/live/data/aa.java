package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class aa {
    public int ayK;
    public String ayL;
    public int ayM;
    public int ayN;
    public ac ayO;
    public int ayP;
    public String ayQ;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.ayK = jSONObject.optInt("taskid");
        this.ayL = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.ayM = jSONObject.optInt("cur_step");
        this.ayN = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.ayO = new ac();
            this.ayO.parseJson(optJSONObject);
        }
        this.ayP = jSONObject.optInt("award_num");
        this.ayQ = jSONObject.optString("taskdetail");
    }

    public boolean wj() {
        return this.ayK == 1;
    }

    public boolean wk() {
        return this.ayK == 6;
    }

    public boolean wl() {
        return this.status == 2;
    }
}
