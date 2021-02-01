package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public AlaLiveInfoData aFA;
    public int aFs;
    public String aFt;
    public long aFu;
    public String aFv;
    public String aFw;
    public long aFx;
    public AlaAvtsData aFy;
    public AlaAvtsConfigInfo aFz;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aFs = jSONObject.optInt("match_status");
            this.aFt = jSONObject.optString("status_text");
            this.aFu = jSONObject.optLong("match_user_id");
            this.aFv = jSONObject.optString("match_user_name");
            this.aFw = jSONObject.optString("match_avatar");
            this.aFx = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.aFy = new AlaAvtsData();
                this.aFy.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.aFz = new AlaAvtsConfigInfo();
                this.aFz.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.aFA = new AlaLiveInfoData();
                this.aFA.parserJson(optJSONObject);
            }
        }
    }

    public boolean At() {
        return this.aFs == 1;
    }

    public boolean isTimeout() {
        return this.aFs == 2;
    }

    public boolean isValid() {
        return this.aFu > 0 && this.challengeId > 0 && this.aFA.getLiveID() > 0 && this.aFy.isValid();
    }
}
