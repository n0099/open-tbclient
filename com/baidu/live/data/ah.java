package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ah {
    public long aLX;
    public String aLY;
    public int aLZ;
    public int aMa;
    public boolean aMb;

    public void parse(JSONObject jSONObject) {
        try {
            if (jSONObject != null) {
                this.aLX = jSONObject.optLong("stay_interval_ms", 7000L);
                this.aLY = jSONObject.optString("rec_title");
                this.aLZ = jSONObject.optInt("rec_daily_num", 1);
                this.aMa = jSONObject.optInt("rec_hide_limit_num", 3);
                this.aMb = jSONObject.optInt("switch", 0) == 1;
            } else {
                this.aLX = 7000L;
                this.aLZ = 1;
                this.aMa = 3;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.aLX = 7000L;
            this.aLZ = 1;
            this.aMa = 3;
        }
    }
}
