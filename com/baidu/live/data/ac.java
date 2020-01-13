package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ac {
    public int ZE;
    public int ZF;
    public long ZG;
    public long ZH;
    public long ZI;
    public long ZJ;
    public long ZK;
    public int ZL;
    public int ZM;
    public String ZN;
    public long challengeId;
    public int challengeResult;
    public long endTime;
    public long startTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.challengeId = jSONObject.optLong("challenge_id");
            this.ZE = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.ZF = jSONObject.optInt("challenge_ret_type");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.ZG = jSONObject.optLong("stage_start_time");
            this.ZH = jSONObject.optLong("stage_end_time");
            this.ZI = jSONObject.optLong("now_time");
            this.ZJ = jSONObject.optLong("anchor_score");
            this.ZK = jSONObject.optLong("rival_score");
            this.ZL = jSONObject.optInt("winning_num");
            this.ZM = jSONObject.optInt("anchor_rank");
            this.ZN = jSONObject.optString("rank_url");
        }
    }
}
