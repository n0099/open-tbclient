package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public int aGS;
    public String aGT;
    public long aGU;
    public String aGV;
    public String aGW;
    public long aGX;
    public AlaAvtsData aGY;
    public AlaAvtsConfigInfo aGZ;
    public AlaLiveInfoData aHa;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aGS = jSONObject.optInt("match_status");
            this.aGT = jSONObject.optString("status_text");
            this.aGU = jSONObject.optLong("match_user_id");
            this.aGV = jSONObject.optString("match_user_name");
            this.aGW = jSONObject.optString("match_avatar");
            this.aGX = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.aGY = new AlaAvtsData();
                this.aGY.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.aGZ = new AlaAvtsConfigInfo();
                this.aGZ.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.aHa = new AlaLiveInfoData();
                this.aHa.parserJson(optJSONObject);
            }
        }
    }

    public boolean Aw() {
        return this.aGS == 1;
    }

    public boolean isTimeout() {
        return this.aGS == 2;
    }

    public boolean isValid() {
        return this.aGU > 0 && this.challengeId > 0 && this.aHa.getLiveID() > 0 && this.aGY.isValid();
    }
}
