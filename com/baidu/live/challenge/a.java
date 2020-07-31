package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int axj;
    public String axk;
    public long axl;
    public String axm;
    public String axn;
    public long axo;
    public AlaAvtsData axp;
    public AlaAvtsConfigInfo axq;
    public AlaLiveInfoData axr;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axj = jSONObject.optInt("match_status");
            this.axk = jSONObject.optString("status_text");
            this.axl = jSONObject.optLong("match_user_id");
            this.axm = jSONObject.optString("match_user_name");
            this.axn = jSONObject.optString("match_avatar");
            this.axo = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.axp = new AlaAvtsData();
                this.axp.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.axq = new AlaAvtsConfigInfo();
                this.axq.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.axr = new AlaLiveInfoData();
                this.axr.parserJson(optJSONObject);
            }
        }
    }

    public boolean wf() {
        return this.axj == 1;
    }

    public boolean isTimeout() {
        return this.axj == 2;
    }

    public boolean isValid() {
        return this.axl > 0 && this.challengeId > 0 && this.axr.getLiveID() > 0 && this.axp.isValid();
    }
}
