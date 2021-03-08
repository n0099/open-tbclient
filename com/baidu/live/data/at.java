package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class at {
    public int aPi;
    public String aPj;
    public int aPk;
    public int aPl;
    public av aPm;
    public int aPn;
    public String aPo;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.aPi = jSONObject.optInt("taskid");
        this.aPj = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.aPk = jSONObject.optInt("cur_step");
        this.aPl = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.aPm = new av();
            this.aPm.parseJson(optJSONObject);
        }
        this.aPn = jSONObject.optInt("award_num");
        this.aPo = jSONObject.optString("taskdetail");
    }

    public boolean Cr() {
        return this.aPi == 1;
    }

    public boolean Cs() {
        return this.aPi == 6;
    }

    public boolean Ct() {
        return this.status == 2;
    }
}
