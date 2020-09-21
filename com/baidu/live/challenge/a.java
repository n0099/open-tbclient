package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int aCW;
    public String aCX;
    public long aCY;
    public String aCZ;
    public String aDa;
    public long aDb;
    public AlaAvtsData aDc;
    public AlaAvtsConfigInfo aDd;
    public AlaLiveInfoData aDe;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aCW = jSONObject.optInt("match_status");
            this.aCX = jSONObject.optString("status_text");
            this.aCY = jSONObject.optLong("match_user_id");
            this.aCZ = jSONObject.optString("match_user_name");
            this.aDa = jSONObject.optString("match_avatar");
            this.aDb = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.aDc = new AlaAvtsData();
                this.aDc.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.aDd = new AlaAvtsConfigInfo();
                this.aDd.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.aDe = new AlaLiveInfoData();
                this.aDe.parserJson(optJSONObject);
            }
        }
    }

    public boolean BS() {
        return this.aCW == 1;
    }

    public boolean isTimeout() {
        return this.aCW == 2;
    }

    public boolean isValid() {
        return this.aCY > 0 && this.challengeId > 0 && this.aDe.getLiveID() > 0 && this.aDc.isValid();
    }
}
