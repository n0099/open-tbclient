package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ah {
    public long aHk;
    public String aHl;
    public int aHm;
    public int aHn;
    public boolean aHo;

    public void parse(JSONObject jSONObject) {
        try {
            if (jSONObject != null) {
                this.aHk = jSONObject.optLong("stay_interval_ms", 7000L);
                this.aHl = jSONObject.optString("rec_title");
                this.aHm = jSONObject.optInt("rec_daily_num", 1);
                this.aHn = jSONObject.optInt("rec_hide_limit_num", 3);
                this.aHo = jSONObject.optInt("switch", 0) == 1;
            } else {
                this.aHk = 7000L;
                this.aHm = 1;
                this.aHn = 3;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.aHk = 7000L;
            this.aHm = 1;
            this.aHn = 3;
        }
    }
}
