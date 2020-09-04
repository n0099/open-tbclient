package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ad {
    public int aHA;
    public String aHB;
    public int aHC;
    public int aHD;
    public af aHE;
    public int aHF;
    public String aHG;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.aHA = jSONObject.optInt("taskid");
        this.aHB = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.aHC = jSONObject.optInt("cur_step");
        this.aHD = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.aHE = new af();
            this.aHE.parseJson(optJSONObject);
        }
        this.aHF = jSONObject.optInt("award_num");
        this.aHG = jSONObject.optString("taskdetail");
    }

    public boolean CM() {
        return this.aHA == 1;
    }

    public boolean CN() {
        return this.aHA == 6;
    }

    public boolean CO() {
        return this.status == 2;
    }
}
