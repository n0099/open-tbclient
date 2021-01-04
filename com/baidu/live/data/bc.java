package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bc {
    public int aQA;
    public int aQB;
    public int aQC;
    public int aQD;
    public String aQE;
    public bz aQF;
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
            this.aQA = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.aQB = jSONObject.optInt("challenge_ret_type");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.stageStartTime = jSONObject.optLong("stage_start_time");
            this.stageEndTime = jSONObject.optLong("stage_end_time");
            this.nowTime = jSONObject.optLong("now_time");
            this.anchorScore = jSONObject.optLong("anchor_score");
            this.rivalScore = jSONObject.optLong("rival_score");
            this.aQC = jSONObject.optInt("winning_num");
            this.aQD = jSONObject.optInt("anchor_rank");
            this.aQE = jSONObject.optString("rank_url");
            this.aQF = new bz();
            JSONObject optJSONObject = jSONObject.optJSONObject("punish_stage_close_info");
            if (optJSONObject != null) {
                this.aQF.parseJson(optJSONObject);
            }
        }
    }
}
