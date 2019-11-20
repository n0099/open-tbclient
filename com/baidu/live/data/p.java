package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p {
    public int Sb;
    public String Sc;
    public int Sd;
    public int Se;
    public r Sf;
    public int Sg;
    public String Sh;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.Sb = jSONObject.optInt("taskid");
        this.Sc = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.Sd = jSONObject.optInt("cur_step");
        this.Se = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.Sf = new r();
            this.Sf.parseJson(optJSONObject);
        }
        this.Sg = jSONObject.optInt("award_num");
        this.Sh = jSONObject.optString("taskdetail");
    }

    public boolean op() {
        return this.Sb == 1;
    }

    public boolean oq() {
        return this.Sb == 6;
    }

    public boolean or() {
        return this.status == 2;
    }
}
