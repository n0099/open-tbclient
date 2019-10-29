package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p {
    public String SA;
    public int Su;
    public String Sv;
    public int Sw;
    public int Sx;
    public r Sy;
    public int Sz;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.Su = jSONObject.optInt("taskid");
        this.Sv = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.Sw = jSONObject.optInt("cur_step");
        this.Sx = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.Sy = new r();
            this.Sy.parseJson(optJSONObject);
        }
        this.Sz = jSONObject.optInt("award_num");
        this.SA = jSONObject.optString("taskdetail");
    }

    public boolean op() {
        return this.Su == 1;
    }

    public boolean oq() {
        return this.Su == 6;
    }

    public boolean or() {
        return this.status == 2;
    }
}
