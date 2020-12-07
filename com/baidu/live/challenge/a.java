package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int aHW;
    public String aHX;
    public long aHY;
    public String aHZ;
    public String aIa;
    public long aIb;
    public AlaAvtsData aIc;
    public AlaAvtsConfigInfo aId;
    public AlaLiveInfoData aIe;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHW = jSONObject.optInt("match_status");
            this.aHX = jSONObject.optString("status_text");
            this.aHY = jSONObject.optLong("match_user_id");
            this.aHZ = jSONObject.optString("match_user_name");
            this.aIa = jSONObject.optString("match_avatar");
            this.aIb = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.aIc = new AlaAvtsData();
                this.aIc.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.aId = new AlaAvtsConfigInfo();
                this.aId.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.aIe = new AlaLiveInfoData();
                this.aIe.parserJson(optJSONObject);
            }
        }
    }

    public boolean Ep() {
        return this.aHW == 1;
    }

    public boolean isTimeout() {
        return this.aHW == 2;
    }

    public boolean isValid() {
        return this.aHY > 0 && this.challengeId > 0 && this.aIe.getLiveID() > 0 && this.aIc.isValid();
    }
}
