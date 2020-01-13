package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public int Vk;
    public String Vl;
    public long Vm;
    public String Vn;
    public String Vo;
    public long Vp;
    public AlaAvtsData Vq;
    public AlaAvtsConfigInfo Vr;
    public AlaLiveInfoData Vs;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Vk = jSONObject.optInt("match_status");
            this.Vl = jSONObject.optString("status_text");
            this.Vm = jSONObject.optLong("match_user_id");
            this.Vn = jSONObject.optString("match_user_name");
            this.Vo = jSONObject.optString("match_avatar");
            this.Vp = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.Vq = new AlaAvtsData();
                this.Vq.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.Vr = new AlaAvtsConfigInfo();
                this.Vr.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.Vs = new AlaLiveInfoData();
                this.Vs.parserJson(optJSONObject);
            }
        }
    }

    public boolean pb() {
        return this.Vk == 1;
    }

    public boolean isTimeout() {
        return this.Vk == 2;
    }

    public boolean isValid() {
        return this.Vm > 0 && this.challengeId > 0 && this.Vs.getLiveID() > 0 && this.Vq.isValid();
    }
}
