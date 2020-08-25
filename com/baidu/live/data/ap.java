package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ap {
    public int aIn;
    public int aIo;
    public long aIp;
    public long aIq;
    public long aIr;
    public long aIs;
    public long aIt;
    public int aIu;
    public int aIv;
    public String aIw;
    public bj aIx;
    public long challengeId;
    public int challengeResult;
    public long endTime;
    public long startTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.challengeId = jSONObject.optLong("challenge_id");
            this.aIn = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.aIo = jSONObject.optInt("challenge_ret_type");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.aIp = jSONObject.optLong("stage_start_time");
            this.aIq = jSONObject.optLong("stage_end_time");
            this.aIr = jSONObject.optLong("now_time");
            this.aIs = jSONObject.optLong("anchor_score");
            this.aIt = jSONObject.optLong("rival_score");
            this.aIu = jSONObject.optInt("winning_num");
            this.aIv = jSONObject.optInt("anchor_rank");
            this.aIw = jSONObject.optString("rank_url");
            this.aIx = new bj();
            JSONObject optJSONObject = jSONObject.optJSONObject("punish_stage_close_info");
            if (optJSONObject != null) {
                this.aIx.parseJson(optJSONObject);
            }
        }
    }
}
