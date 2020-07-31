package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class an {
    public int aDd;
    public int aDe;
    public long aDf;
    public long aDg;
    public long aDh;
    public long aDi;
    public long aDj;
    public int aDk;
    public int aDl;
    public String aDm;
    public bh aDn;
    public long challengeId;
    public int challengeResult;
    public long endTime;
    public long startTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.challengeId = jSONObject.optLong("challenge_id");
            this.aDd = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.aDe = jSONObject.optInt("challenge_ret_type");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.aDf = jSONObject.optLong("stage_start_time");
            this.aDg = jSONObject.optLong("stage_end_time");
            this.aDh = jSONObject.optLong("now_time");
            this.aDi = jSONObject.optLong("anchor_score");
            this.aDj = jSONObject.optLong("rival_score");
            this.aDk = jSONObject.optInt("winning_num");
            this.aDl = jSONObject.optInt("anchor_rank");
            this.aDm = jSONObject.optString("rank_url");
            this.aDn = new bh();
            JSONObject optJSONObject = jSONObject.optJSONObject("punish_stage_close_info");
            if (optJSONObject != null) {
                this.aDn.parseJson(optJSONObject);
            }
        }
    }
}
