package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ag {
    public int aum;
    public int aun;
    public long auo;
    public long aup;
    public long auq;
    public long aur;
    public long aus;
    public int aut;
    public int auu;
    public String auv;
    public long challengeId;
    public int challengeResult;
    public long endTime;
    public long startTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.challengeId = jSONObject.optLong("challenge_id");
            this.aum = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.aun = jSONObject.optInt("challenge_ret_type");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.auo = jSONObject.optLong("stage_start_time");
            this.aup = jSONObject.optLong("stage_end_time");
            this.auq = jSONObject.optLong("now_time");
            this.aur = jSONObject.optLong("anchor_score");
            this.aus = jSONObject.optLong("rival_score");
            this.aut = jSONObject.optInt("winning_num");
            this.auu = jSONObject.optInt("anchor_rank");
            this.auv = jSONObject.optString("rank_url");
        }
    }
}
