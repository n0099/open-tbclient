package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ab {
    public int aBb;
    public String aBc;
    public int aBd;
    public int aBe;
    public ad aBf;
    public int aBg;
    public String aBh;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.aBb = jSONObject.optInt("taskid");
        this.aBc = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.aBd = jSONObject.optInt("cur_step");
        this.aBe = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.aBf = new ad();
            this.aBf.parseJson(optJSONObject);
        }
        this.aBg = jSONObject.optInt("award_num");
        this.aBh = jSONObject.optString("taskdetail");
    }

    public boolean wH() {
        return this.aBb == 1;
    }

    public boolean wI() {
        return this.aBb == 6;
    }

    public boolean wJ() {
        return this.status == 2;
    }
}
