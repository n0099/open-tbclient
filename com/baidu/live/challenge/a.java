package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int aGZ;
    public String aHa;
    public long aHb;
    public String aHc;
    public String aHd;
    public long aHe;
    public AlaAvtsData aHf;
    public AlaAvtsConfigInfo aHg;
    public AlaLiveInfoData aHh;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aGZ = jSONObject.optInt("match_status");
            this.aHa = jSONObject.optString("status_text");
            this.aHb = jSONObject.optLong("match_user_id");
            this.aHc = jSONObject.optString("match_user_name");
            this.aHd = jSONObject.optString("match_avatar");
            this.aHe = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.aHf = new AlaAvtsData();
                this.aHf.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.aHg = new AlaAvtsConfigInfo();
                this.aHg.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.aHh = new AlaLiveInfoData();
                this.aHh.parserJson(optJSONObject);
            }
        }
    }

    public boolean Do() {
        return this.aGZ == 1;
    }

    public boolean isTimeout() {
        return this.aGZ == 2;
    }

    public boolean isValid() {
        return this.aHb > 0 && this.challengeId > 0 && this.aHh.getLiveID() > 0 && this.aHf.isValid();
    }
}
