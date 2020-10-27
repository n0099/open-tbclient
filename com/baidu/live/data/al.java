package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class al {
    public int aME;
    public String aMF;
    public int aMG;
    public int aMH;
    public an aMI;
    public int aMJ;
    public String aMK;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.aME = jSONObject.optInt("taskid");
        this.aMF = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.aMG = jSONObject.optInt("cur_step");
        this.aMH = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.aMI = new an();
            this.aMI.parseJson(optJSONObject);
        }
        this.aMJ = jSONObject.optInt("award_num");
        this.aMK = jSONObject.optString("taskdetail");
    }

    public boolean Ei() {
        return this.aME == 1;
    }

    public boolean Ej() {
        return this.aME == 6;
    }

    public boolean Ek() {
        return this.status == 2;
    }
}
