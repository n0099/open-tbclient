package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class al {
    public long aJP;
    public String aJQ;
    public int aJR;
    public int aJS;
    public boolean aJT;

    public void parse(JSONObject jSONObject) {
        try {
            if (jSONObject != null) {
                this.aJP = jSONObject.optLong("stay_interval_ms", 7000L);
                this.aJQ = jSONObject.optString("rec_title");
                this.aJR = jSONObject.optInt("rec_daily_num", 1);
                this.aJS = jSONObject.optInt("rec_hide_limit_num", 3);
                this.aJT = jSONObject.optInt("switch", 0) == 1;
            } else {
                this.aJP = 7000L;
                this.aJR = 1;
                this.aJS = 3;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.aJP = 7000L;
            this.aJR = 1;
            this.aJS = 3;
        }
    }
}
