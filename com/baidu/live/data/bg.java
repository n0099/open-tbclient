package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bg {
    public int aOK;
    public int aOL;
    public int aOM;
    public int aON;
    public String aOO;
    public cg aOP;
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
            this.aOK = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.aOL = jSONObject.optInt("challenge_ret_type");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.stageStartTime = jSONObject.optLong("stage_start_time");
            this.stageEndTime = jSONObject.optLong("stage_end_time");
            this.nowTime = jSONObject.optLong("now_time");
            this.anchorScore = jSONObject.optLong("anchor_score");
            this.rivalScore = jSONObject.optLong("rival_score");
            this.aOM = jSONObject.optInt("winning_num");
            this.aON = jSONObject.optInt("anchor_rank");
            this.aOO = jSONObject.optString("rank_url");
            this.aOP = new cg();
            JSONObject optJSONObject = jSONObject.optJSONObject("punish_stage_close_info");
            if (optJSONObject != null) {
                this.aOP.parseJson(optJSONObject);
            }
        }
    }
}
