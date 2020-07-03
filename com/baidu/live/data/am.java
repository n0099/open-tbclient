package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class am {
    public int aBI;
    public int aBJ;
    public long aBK;
    public long aBL;
    public long aBM;
    public long aBN;
    public long aBO;
    public int aBP;
    public int aBQ;
    public String aBR;
    public bg aBS;
    public long challengeId;
    public int challengeResult;
    public long endTime;
    public long startTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.challengeId = jSONObject.optLong("challenge_id");
            this.aBI = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.aBJ = jSONObject.optInt("challenge_ret_type");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.aBK = jSONObject.optLong("stage_start_time");
            this.aBL = jSONObject.optLong("stage_end_time");
            this.aBM = jSONObject.optLong("now_time");
            this.aBN = jSONObject.optLong("anchor_score");
            this.aBO = jSONObject.optLong("rival_score");
            this.aBP = jSONObject.optInt("winning_num");
            this.aBQ = jSONObject.optInt("anchor_rank");
            this.aBR = jSONObject.optString("rank_url");
            this.aBS = new bg();
            JSONObject optJSONObject = jSONObject.optJSONObject("punish_stage_close_info");
            if (optJSONObject != null) {
                this.aBS.parseJson(optJSONObject);
            }
        }
    }
}
