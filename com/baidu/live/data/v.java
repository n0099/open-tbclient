package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class v {
    public int SO;
    public int SQ;
    public int SR;
    public long SS;
    public long ST;
    public long SU;
    public long SV;
    public long SW;
    public long SX;
    public int SY;
    public int SZ;
    public String Ta;
    public long challengeId;
    public int challengeResult;
    public long endTime;
    public long startTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.challengeId = jSONObject.optLong("challenge_id");
            this.SO = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.SQ = jSONObject.optInt("challenge_ret_type");
            this.SR = jSONObject.optInt("allin");
            this.SS = jSONObject.optLong("allin_start_user");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.ST = jSONObject.optLong("stage_start_time");
            this.SU = jSONObject.optLong("stage_end_time");
            this.SV = jSONObject.optLong("now_time");
            this.SW = jSONObject.optLong("anchor_score");
            this.SX = jSONObject.optLong("rival_score");
            this.SY = jSONObject.optInt("winning_num");
            this.SZ = jSONObject.optInt("anchor_rank");
            this.Ta = jSONObject.optString("rank_url");
        }
    }
}
