package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {
    public int abh;
    public String abi;
    public int abj;
    public int abk;
    public w abl;
    public int abm;
    public String abn;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.abh = jSONObject.optInt("taskid");
        this.abi = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.abj = jSONObject.optInt("cur_step");
        this.abk = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.abl = new w();
            this.abl.parseJson(optJSONObject);
        }
        this.abm = jSONObject.optInt("award_num");
        this.abn = jSONObject.optString("taskdetail");
    }

    public boolean qE() {
        return this.abh == 1;
    }

    public boolean qF() {
        return this.abh == 6;
    }

    public boolean qG() {
        return this.status == 2;
    }
}
