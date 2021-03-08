package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class dh {
    public int aUX;
    public int aUY;
    public int aUZ;
    public int aVa;
    public int aVb;
    public int aVc;
    public int aVd;
    public int aVe;
    public int aVf;
    public int aVg;
    public int aVh;
    public int aVi;

    public dh H(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        dh dhVar = new dh();
        dhVar.aUX = jSONObject.optInt("pk_add_time_max", 300);
        dhVar.aUY = jSONObject.optInt("pk_add_time_step", 5);
        dhVar.aUZ = jSONObject.optInt("pk_time_default", 20);
        dhVar.aVa = jSONObject.optInt("pk_time_max", 30);
        dhVar.aVb = jSONObject.optInt("pk_time_min", 5);
        dhVar.aVc = jSONObject.optInt("punish_add_time_max", 300);
        dhVar.aVd = jSONObject.optInt("punish_add_time_step", 5);
        dhVar.aVe = jSONObject.optInt("punish_time_default", 20);
        dhVar.aVf = jSONObject.optInt("punish_time_max", 30);
        dhVar.aVg = jSONObject.optInt("punish_time_min", 5);
        dhVar.aVh = jSONObject.optInt("settle_loading_time", 3);
        dhVar.aVi = jSONObject.optInt("show_settle_loading", 1);
        return dhVar;
    }
}
