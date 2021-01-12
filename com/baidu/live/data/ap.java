package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ap {
    public int aKM;
    public String aKN;
    public int aKO;
    public int aKP;
    public ar aKQ;
    public int aKR;
    public String aKS;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.aKM = jSONObject.optInt("taskid");
        this.aKN = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.aKO = jSONObject.optInt("cur_step");
        this.aKP = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.aKQ = new ar();
            this.aKQ.parseJson(optJSONObject);
        }
        this.aKR = jSONObject.optInt("award_num");
        this.aKS = jSONObject.optString("taskdetail");
    }

    public boolean Bb() {
        return this.aKM == 1;
    }

    public boolean Bc() {
        return this.aKM == 6;
    }

    public boolean Bd() {
        return this.status == 2;
    }
}
