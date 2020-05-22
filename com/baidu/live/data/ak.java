package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ak {
    public int azq;
    public int azr;
    public long azs;
    public long azt;
    public long azu;
    public long azv;
    public long azw;
    public int azx;
    public int azy;
    public String azz;
    public long challengeId;
    public int challengeResult;
    public long endTime;
    public long startTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.challengeId = jSONObject.optLong("challenge_id");
            this.azq = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.azr = jSONObject.optInt("challenge_ret_type");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.azs = jSONObject.optLong("stage_start_time");
            this.azt = jSONObject.optLong("stage_end_time");
            this.azu = jSONObject.optLong("now_time");
            this.azv = jSONObject.optLong("anchor_score");
            this.azw = jSONObject.optLong("rival_score");
            this.azx = jSONObject.optInt("winning_num");
            this.azy = jSONObject.optInt("anchor_rank");
            this.azz = jSONObject.optString("rank_url");
        }
    }
}
