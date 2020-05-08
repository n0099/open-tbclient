package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class w {
    public int atH;
    public String atI;
    public int atJ;
    public int atK;
    public y atL;
    public int atM;
    public String atN;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.atH = jSONObject.optInt("taskid");
        this.atI = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.atJ = jSONObject.optInt("cur_step");
        this.atK = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.atL = new y();
            this.atL.parseJson(optJSONObject);
        }
        this.atM = jSONObject.optInt("award_num");
        this.atN = jSONObject.optString("taskdetail");
    }

    public boolean uU() {
        return this.atH == 1;
    }

    public boolean uV() {
        return this.atH == 6;
    }

    public boolean uW() {
        return this.status == 2;
    }
}
