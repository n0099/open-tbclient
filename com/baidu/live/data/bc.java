package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bc {
    public int aLN;
    public int aLO;
    public int aLP;
    public int aLQ;
    public String aLR;
    public bz aLS;
    public long anchorScore;
    public long challengeId;
    public int challengeResult;
    public long endTime;
    public long nowTime;
    public long rivalScore;
    public long stageEndTime;
    public long stageStartTime;
    public long startTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.challengeId = jSONObject.optLong("challenge_id");
            this.aLN = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.aLO = jSONObject.optInt("challenge_ret_type");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.stageStartTime = jSONObject.optLong("stage_start_time");
            this.stageEndTime = jSONObject.optLong("stage_end_time");
            this.nowTime = jSONObject.optLong("now_time");
            this.anchorScore = jSONObject.optLong("anchor_score");
            this.rivalScore = jSONObject.optLong("rival_score");
            this.aLP = jSONObject.optInt("winning_num");
            this.aLQ = jSONObject.optInt("anchor_rank");
            this.aLR = jSONObject.optString("rank_url");
            this.aLS = new bz();
            JSONObject optJSONObject = jSONObject.optJSONObject("punish_stage_close_info");
            if (optJSONObject != null) {
                this.aLS.parseJson(optJSONObject);
            }
        }
    }
}
