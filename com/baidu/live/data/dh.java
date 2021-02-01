package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class dh {
    public int aTA;
    public int aTB;
    public int aTC;
    public int aTD;
    public int aTE;
    public int aTF;
    public int aTG;
    public int aTH;
    public int aTI;
    public int aTx;
    public int aTy;
    public int aTz;

    public dh F(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        dh dhVar = new dh();
        dhVar.aTx = jSONObject.optInt("pk_add_time_max", 300);
        dhVar.aTy = jSONObject.optInt("pk_add_time_step", 5);
        dhVar.aTz = jSONObject.optInt("pk_time_default", 20);
        dhVar.aTA = jSONObject.optInt("pk_time_max", 30);
        dhVar.aTB = jSONObject.optInt("pk_time_min", 5);
        dhVar.aTC = jSONObject.optInt("punish_add_time_max", 300);
        dhVar.aTD = jSONObject.optInt("punish_add_time_step", 5);
        dhVar.aTE = jSONObject.optInt("punish_time_default", 20);
        dhVar.aTF = jSONObject.optInt("punish_time_max", 30);
        dhVar.aTG = jSONObject.optInt("punish_time_min", 5);
        dhVar.aTH = jSONObject.optInt("settle_loading_time", 3);
        dhVar.aTI = jSONObject.optInt("show_settle_loading", 1);
        return dhVar;
    }
}
