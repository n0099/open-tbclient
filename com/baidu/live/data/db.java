package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class db {
    public int aQA;
    public int aQB;
    public int aQC;
    public int aQD;
    public int aQE;
    public int aQF;
    public int aQu;
    public int aQv;
    public int aQw;
    public int aQx;
    public int aQy;
    public int aQz;

    public db F(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        db dbVar = new db();
        dbVar.aQu = jSONObject.optInt("pk_add_time_max", 300);
        dbVar.aQv = jSONObject.optInt("pk_add_time_step", 5);
        dbVar.aQw = jSONObject.optInt("pk_time_default", 20);
        dbVar.aQx = jSONObject.optInt("pk_time_max", 30);
        dbVar.aQy = jSONObject.optInt("pk_time_min", 5);
        dbVar.aQz = jSONObject.optInt("punish_add_time_max", 300);
        dbVar.aQA = jSONObject.optInt("punish_add_time_step", 5);
        dbVar.aQB = jSONObject.optInt("punish_time_default", 20);
        dbVar.aQC = jSONObject.optInt("punish_time_max", 30);
        dbVar.aQD = jSONObject.optInt("punish_time_min", 5);
        dbVar.aQE = jSONObject.optInt("settle_loading_time", 3);
        dbVar.aQF = jSONObject.optInt("show_settle_loading", 1);
        return dbVar;
    }
}
