package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ad {
    public int abA;
    public long abB;
    public long abC;
    public long abD;
    public long abE;
    public long abF;
    public int abG;
    public int abH;
    public String abI;
    public int abz;
    public long challengeId;
    public int challengeResult;
    public long endTime;
    public long startTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.challengeId = jSONObject.optLong("challenge_id");
            this.abz = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.abA = jSONObject.optInt("challenge_ret_type");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.abB = jSONObject.optLong("stage_start_time");
            this.abC = jSONObject.optLong("stage_end_time");
            this.abD = jSONObject.optLong("now_time");
            this.abE = jSONObject.optLong("anchor_score");
            this.abF = jSONObject.optLong("rival_score");
            this.abG = jSONObject.optInt("winning_num");
            this.abH = jSONObject.optInt("anchor_rank");
            this.abI = jSONObject.optString("rank_url");
        }
    }
}
