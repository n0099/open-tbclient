package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class az {
    public int aOA;
    public String aOB;
    public bv aOC;
    public int aOx;
    public int aOy;
    public int aOz;
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
            this.aOx = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.aOy = jSONObject.optInt("challenge_ret_type");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.stageStartTime = jSONObject.optLong("stage_start_time");
            this.stageEndTime = jSONObject.optLong("stage_end_time");
            this.nowTime = jSONObject.optLong("now_time");
            this.anchorScore = jSONObject.optLong("anchor_score");
            this.rivalScore = jSONObject.optLong("rival_score");
            this.aOz = jSONObject.optInt("winning_num");
            this.aOA = jSONObject.optInt("anchor_rank");
            this.aOB = jSONObject.optString("rank_url");
            this.aOC = new bv();
            JSONObject optJSONObject = jSONObject.optJSONObject("punish_stage_close_info");
            if (optJSONObject != null) {
                this.aOC.parseJson(optJSONObject);
            }
        }
    }
}
