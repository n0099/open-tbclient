package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class al {
    public long aLp;
    public String aLq;
    public int aLr;
    public int aLs;
    public boolean aLt;

    public void parse(JSONObject jSONObject) {
        try {
            if (jSONObject != null) {
                this.aLp = jSONObject.optLong("stay_interval_ms", 7000L);
                this.aLq = jSONObject.optString("rec_title");
                this.aLr = jSONObject.optInt("rec_daily_num", 1);
                this.aLs = jSONObject.optInt("rec_hide_limit_num", 3);
                this.aLt = jSONObject.optInt("switch", 0) == 1;
            } else {
                this.aLp = 7000L;
                this.aLr = 1;
                this.aLs = 3;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.aLp = 7000L;
            this.aLr = 1;
            this.aLs = 3;
        }
    }
}
