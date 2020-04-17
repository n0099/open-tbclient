package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ag {
    public int aug;
    public int auh;
    public long aui;
    public long auj;
    public long auk;
    public long aul;
    public long aum;
    public int aun;
    public int auo;
    public String aup;
    public long challengeId;
    public int challengeResult;
    public long endTime;
    public long startTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.challengeId = jSONObject.optLong("challenge_id");
            this.aug = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.auh = jSONObject.optInt("challenge_ret_type");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.aui = jSONObject.optLong("stage_start_time");
            this.auj = jSONObject.optLong("stage_end_time");
            this.auk = jSONObject.optLong("now_time");
            this.aul = jSONObject.optLong("anchor_score");
            this.aum = jSONObject.optLong("rival_score");
            this.aun = jSONObject.optInt("winning_num");
            this.auo = jSONObject.optInt("anchor_rank");
            this.aup = jSONObject.optString("rank_url");
        }
    }
}
