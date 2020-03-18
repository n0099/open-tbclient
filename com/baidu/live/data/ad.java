package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ad {
    public int abJ;
    public int abK;
    public long abL;
    public long abM;
    public long abN;
    public long abO;
    public long abP;
    public int abQ;
    public int abR;
    public String abS;
    public long challengeId;
    public int challengeResult;
    public long endTime;
    public long startTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.challengeId = jSONObject.optLong("challenge_id");
            this.abJ = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.abK = jSONObject.optInt("challenge_ret_type");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.abL = jSONObject.optLong("stage_start_time");
            this.abM = jSONObject.optLong("stage_end_time");
            this.abN = jSONObject.optLong("now_time");
            this.abO = jSONObject.optLong("anchor_score");
            this.abP = jSONObject.optLong("rival_score");
            this.abQ = jSONObject.optInt("winning_num");
            this.abR = jSONObject.optInt("anchor_rank");
            this.abS = jSONObject.optString("rank_url");
        }
    }
}
