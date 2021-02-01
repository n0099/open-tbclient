package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class at {
    public int aNI;
    public String aNJ;
    public int aNK;
    public int aNL;
    public av aNM;
    public int aNN;
    public String aNO;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.aNI = jSONObject.optInt("taskid");
        this.aNJ = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.aNK = jSONObject.optInt("cur_step");
        this.aNL = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.aNM = new av();
            this.aNM.parseJson(optJSONObject);
        }
        this.aNN = jSONObject.optInt("award_num");
        this.aNO = jSONObject.optString("taskdetail");
    }

    public boolean Co() {
        return this.aNI == 1;
    }

    public boolean Cp() {
        return this.aNI == 6;
    }

    public boolean Cq() {
        return this.status == 2;
    }
}
