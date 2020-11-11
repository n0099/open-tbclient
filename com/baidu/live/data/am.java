package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class am {
    public int aNG;
    public String aNH;
    public int aNI;
    public int aNJ;
    public ao aNK;
    public int aNL;
    public String aNM;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.aNG = jSONObject.optInt("taskid");
        this.aNH = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.aNI = jSONObject.optInt("cur_step");
        this.aNJ = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.aNK = new ao();
            this.aNK.parseJson(optJSONObject);
        }
        this.aNL = jSONObject.optInt("award_num");
        this.aNM = jSONObject.optString("taskdetail");
    }

    public boolean EE() {
        return this.aNG == 1;
    }

    public boolean EF() {
        return this.aNG == 6;
    }

    public boolean EG() {
        return this.status == 2;
    }
}
