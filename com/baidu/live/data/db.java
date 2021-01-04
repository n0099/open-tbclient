package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class db {
    public int aVh;
    public int aVi;
    public int aVj;
    public int aVk;
    public int aVl;
    public int aVm;
    public int aVn;
    public int aVo;
    public int aVp;
    public int aVq;
    public int aVr;
    public int aVs;

    public db F(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        db dbVar = new db();
        dbVar.aVh = jSONObject.optInt("pk_add_time_max", 300);
        dbVar.aVi = jSONObject.optInt("pk_add_time_step", 5);
        dbVar.aVj = jSONObject.optInt("pk_time_default", 20);
        dbVar.aVk = jSONObject.optInt("pk_time_max", 30);
        dbVar.aVl = jSONObject.optInt("pk_time_min", 5);
        dbVar.aVm = jSONObject.optInt("punish_add_time_max", 300);
        dbVar.aVn = jSONObject.optInt("punish_add_time_step", 5);
        dbVar.aVo = jSONObject.optInt("punish_time_default", 20);
        dbVar.aVp = jSONObject.optInt("punish_time_max", 30);
        dbVar.aVq = jSONObject.optInt("punish_time_min", 5);
        dbVar.aVr = jSONObject.optInt("settle_loading_time", 3);
        dbVar.aVs = jSONObject.optInt("show_settle_loading", 1);
        return dbVar;
    }
}
