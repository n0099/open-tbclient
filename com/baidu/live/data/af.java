package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class af {
    public long aLt;
    public String aLu;
    public int aLv;
    public int aLw;
    public boolean aLx;

    public void parse(JSONObject jSONObject) {
        try {
            if (jSONObject != null) {
                this.aLt = jSONObject.optLong("stay_interval_ms", 7000L);
                this.aLu = jSONObject.optString("rec_title");
                this.aLv = jSONObject.optInt("rec_daily_num", 1);
                this.aLw = jSONObject.optInt("rec_hide_limit_num", 3);
                this.aLx = jSONObject.optInt("switch", 0) == 1;
            } else {
                this.aLt = 7000L;
                this.aLv = 1;
                this.aLw = 3;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.aLt = 7000L;
            this.aLv = 1;
            this.aLw = 3;
        }
    }
}
