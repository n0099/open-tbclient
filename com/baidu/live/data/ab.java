package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ab {
    public int aCo;
    public String aCp;
    public int aCq;
    public int aCr;
    public ad aCs;
    public int aCt;
    public String aCu;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.aCo = jSONObject.optInt("taskid");
        this.aCp = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.aCq = jSONObject.optInt("cur_step");
        this.aCr = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.aCs = new ad();
            this.aCs.parseJson(optJSONObject);
        }
        this.aCt = jSONObject.optInt("award_num");
        this.aCu = jSONObject.optString("taskdetail");
    }

    public boolean xj() {
        return this.aCo == 1;
    }

    public boolean xk() {
        return this.aCo == 6;
    }

    public boolean xl() {
        return this.status == 2;
    }
}
