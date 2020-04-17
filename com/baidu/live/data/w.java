package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class w {
    public int atB;
    public String atC;
    public int atD;
    public int atE;
    public y atF;
    public int atG;
    public String atH;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.atB = jSONObject.optInt("taskid");
        this.atC = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.atD = jSONObject.optInt("cur_step");
        this.atE = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.atF = new y();
            this.atF.parseJson(optJSONObject);
        }
        this.atG = jSONObject.optInt("award_num");
        this.atH = jSONObject.optString("taskdetail");
    }

    public boolean uV() {
        return this.atB == 1;
    }

    public boolean uW() {
        return this.atB == 6;
    }

    public boolean uX() {
        return this.status == 2;
    }
}
