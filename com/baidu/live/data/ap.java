package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ap {
    public int aIp;
    public int aIq;
    public long aIr;
    public long aIs;
    public long aIt;
    public long aIu;
    public long aIv;
    public int aIw;
    public int aIx;
    public String aIy;
    public bj aIz;
    public long challengeId;
    public int challengeResult;
    public long endTime;
    public long startTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.challengeId = jSONObject.optLong("challenge_id");
            this.aIp = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.aIq = jSONObject.optInt("challenge_ret_type");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.aIr = jSONObject.optLong("stage_start_time");
            this.aIs = jSONObject.optLong("stage_end_time");
            this.aIt = jSONObject.optLong("now_time");
            this.aIu = jSONObject.optLong("anchor_score");
            this.aIv = jSONObject.optLong("rival_score");
            this.aIw = jSONObject.optInt("winning_num");
            this.aIx = jSONObject.optInt("anchor_rank");
            this.aIy = jSONObject.optString("rank_url");
            this.aIz = new bj();
            JSONObject optJSONObject = jSONObject.optJSONObject("punish_stage_close_info");
            if (optJSONObject != null) {
                this.aIz.parseJson(optJSONObject);
            }
        }
    }
}
