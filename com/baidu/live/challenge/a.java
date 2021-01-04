package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public AlaLiveInfoData aIA;
    public int aIs;
    public String aIt;
    public long aIu;
    public String aIv;
    public String aIw;
    public long aIx;
    public AlaAvtsData aIy;
    public AlaAvtsConfigInfo aIz;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIs = jSONObject.optInt("match_status");
            this.aIt = jSONObject.optString("status_text");
            this.aIu = jSONObject.optLong("match_user_id");
            this.aIv = jSONObject.optString("match_user_name");
            this.aIw = jSONObject.optString("match_avatar");
            this.aIx = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.aIy = new AlaAvtsData();
                this.aIy.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.aIz = new AlaAvtsConfigInfo();
                this.aIz.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.aIA = new AlaLiveInfoData();
                this.aIA.parserJson(optJSONObject);
            }
        }
    }

    public boolean DE() {
        return this.aIs == 1;
    }

    public boolean isTimeout() {
        return this.aIs == 2;
    }

    public boolean isValid() {
        return this.aIu > 0 && this.challengeId > 0 && this.aIA.getLiveID() > 0 && this.aIy.isValid();
    }
}
