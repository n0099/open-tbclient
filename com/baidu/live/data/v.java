package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class v {
    public long SA;
    public int SB;
    public int SC;
    public String SD;
    public int Ss;
    public int St;
    public int Su;
    public long Sv;
    public long Sw;
    public long Sx;
    public long Sy;
    public long Sz;
    public long challengeId;
    public int challengeResult;
    public long endTime;
    public long startTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.challengeId = jSONObject.optLong("challenge_id");
            this.Ss = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.St = jSONObject.optInt("challenge_ret_type");
            this.Su = jSONObject.optInt("allin");
            this.Sv = jSONObject.optLong("allin_start_user");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.Sw = jSONObject.optLong("stage_start_time");
            this.Sx = jSONObject.optLong("stage_end_time");
            this.Sy = jSONObject.optLong("now_time");
            this.Sz = jSONObject.optLong("anchor_score");
            this.SA = jSONObject.optLong("rival_score");
            this.SB = jSONObject.optInt("winning_num");
            this.SC = jSONObject.optInt("anchor_rank");
            this.SD = jSONObject.optString("rank_url");
        }
    }
}
