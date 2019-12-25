package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class y {
    public int Zo;
    public int Zp;
    public int Zq;
    public long Zr;
    public long Zs;
    public long Zt;
    public long Zu;
    public long Zv;
    public long Zw;
    public int Zx;
    public int Zy;
    public String Zz;
    public long challengeId;
    public int challengeResult;
    public long endTime;
    public long startTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.challengeId = jSONObject.optLong("challenge_id");
            this.Zo = jSONObject.optInt("challenge_status");
            this.challengeResult = jSONObject.optInt("challenge_ret");
            this.Zp = jSONObject.optInt("challenge_ret_type");
            this.Zq = jSONObject.optInt("allin");
            this.Zr = jSONObject.optLong("allin_start_user");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.Zs = jSONObject.optLong("stage_start_time");
            this.Zt = jSONObject.optLong("stage_end_time");
            this.Zu = jSONObject.optLong("now_time");
            this.Zv = jSONObject.optLong("anchor_score");
            this.Zw = jSONObject.optLong("rival_score");
            this.Zx = jSONObject.optInt("winning_num");
            this.Zy = jSONObject.optInt("anchor_rank");
            this.Zz = jSONObject.optString("rank_url");
        }
    }
}
