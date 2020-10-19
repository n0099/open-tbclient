package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int aGb;
    public String aGc;
    public long aGd;
    public String aGe;
    public String aGf;
    public long aGg;
    public AlaAvtsData aGh;
    public AlaAvtsConfigInfo aGi;
    public AlaLiveInfoData aGj;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aGb = jSONObject.optInt("match_status");
            this.aGc = jSONObject.optString("status_text");
            this.aGd = jSONObject.optLong("match_user_id");
            this.aGe = jSONObject.optString("match_user_name");
            this.aGf = jSONObject.optString("match_avatar");
            this.aGg = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.aGh = new AlaAvtsData();
                this.aGh.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.aGi = new AlaAvtsConfigInfo();
                this.aGi.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.aGj = new AlaLiveInfoData();
                this.aGj.parserJson(optJSONObject);
            }
        }
    }

    public boolean CP() {
        return this.aGb == 1;
    }

    public boolean isTimeout() {
        return this.aGb == 2;
    }

    public boolean isValid() {
        return this.aGd > 0 && this.challengeId > 0 && this.aGj.getLiveID() > 0 && this.aGh.isValid();
    }
}
