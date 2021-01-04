package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ap {
    public String aPA;
    public int aPB;
    public int aPC;
    public ar aPD;
    public int aPE;
    public String aPF;
    public int aPz;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.aPz = jSONObject.optInt("taskid");
        this.aPA = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.aPB = jSONObject.optInt("cur_step");
        this.aPC = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.aPD = new ar();
            this.aPD.parseJson(optJSONObject);
        }
        this.aPE = jSONObject.optInt("award_num");
        this.aPF = jSONObject.optString("taskdetail");
    }

    public boolean EW() {
        return this.aPz == 1;
    }

    public boolean EX() {
        return this.aPz == 6;
    }

    public boolean EY() {
        return this.status == 2;
    }
}
