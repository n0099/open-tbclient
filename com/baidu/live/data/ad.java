package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ad {
    public int aHA;
    public int aHB;
    public af aHC;
    public int aHD;
    public String aHE;
    public int aHy;
    public String aHz;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.aHy = jSONObject.optInt("taskid");
        this.aHz = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.aHA = jSONObject.optInt("cur_step");
        this.aHB = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.aHC = new af();
            this.aHC.parseJson(optJSONObject);
        }
        this.aHD = jSONObject.optInt("award_num");
        this.aHE = jSONObject.optString("taskdetail");
    }

    public boolean CM() {
        return this.aHy == 1;
    }

    public boolean CN() {
        return this.aHy == 6;
    }

    public boolean CO() {
        return this.status == 2;
    }
}
