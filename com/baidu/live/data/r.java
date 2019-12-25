package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r {
    public int YQ;
    public String YR;
    public int YS;
    public int YT;
    public t YU;
    public int YV;
    public String YW;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.YQ = jSONObject.optInt("taskid");
        this.YR = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.YS = jSONObject.optInt("cur_step");
        this.YT = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.YU = new t();
            this.YU.parseJson(optJSONObject);
        }
        this.YV = jSONObject.optInt("award_num");
        this.YW = jSONObject.optString("taskdetail");
    }

    public boolean pK() {
        return this.YQ == 1;
    }

    public boolean pL() {
        return this.YQ == 6;
    }

    public boolean pM() {
        return this.status == 2;
    }
}
