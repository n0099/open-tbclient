package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class t {
    public int Ze;
    public String Zf;
    public int Zg;
    public int Zh;
    public v Zi;
    public int Zj;
    public String Zk;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.Ze = jSONObject.optInt("taskid");
        this.Zf = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.Zg = jSONObject.optInt("cur_step");
        this.Zh = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.Zi = new v();
            this.Zi.parseJson(optJSONObject);
        }
        this.Zj = jSONObject.optInt("award_num");
        this.Zk = jSONObject.optString("taskdetail");
    }

    public boolean pO() {
        return this.Ze == 1;
    }

    public boolean pP() {
        return this.Ze == 6;
    }

    public boolean pQ() {
        return this.status == 2;
    }
}
