package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class am {
    public int aLV;
    public String aLW;
    public int aLX;
    public int aLY;
    public ao aLZ;
    public int aMa;
    public String aMb;
    public int status;

    public void parseJson(JSONObject jSONObject) {
        this.aLV = jSONObject.optInt("taskid");
        this.aLW = jSONObject.optString("taskname");
        this.status = jSONObject.optInt("status");
        this.aLX = jSONObject.optInt("cur_step");
        this.aLY = jSONObject.optInt("total_step");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        if (optJSONObject != null) {
            this.aLZ = new ao();
            this.aLZ.parseJson(optJSONObject);
        }
        this.aMa = jSONObject.optInt("award_num");
        this.aMb = jSONObject.optString("taskdetail");
    }

    public boolean DV() {
        return this.aLV == 1;
    }

    public boolean DW() {
        return this.aLV == 6;
    }

    public boolean DX() {
        return this.status == 2;
    }
}
