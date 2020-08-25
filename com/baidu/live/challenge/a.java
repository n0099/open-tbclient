package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public int aCl;
    public String aCm;
    public long aCn;
    public String aCo;
    public String aCp;
    public long aCq;
    public AlaAvtsData aCr;
    public AlaAvtsConfigInfo aCs;
    public AlaLiveInfoData aCt;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aCl = jSONObject.optInt("match_status");
            this.aCm = jSONObject.optString("status_text");
            this.aCn = jSONObject.optLong("match_user_id");
            this.aCo = jSONObject.optString("match_user_name");
            this.aCp = jSONObject.optString("match_avatar");
            this.aCq = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.aCr = new AlaAvtsData();
                this.aCr.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.aCs = new AlaAvtsConfigInfo();
                this.aCs.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.aCt = new AlaLiveInfoData();
                this.aCt.parserJson(optJSONObject);
            }
        }
    }

    public boolean BD() {
        return this.aCl == 1;
    }

    public boolean isTimeout() {
        return this.aCl == 2;
    }

    public boolean isValid() {
        return this.aCn > 0 && this.challengeId > 0 && this.aCt.getLiveID() > 0 && this.aCr.isValid();
    }
}
