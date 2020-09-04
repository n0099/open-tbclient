package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public int aCn;
    public String aCo;
    public long aCp;
    public String aCq;
    public String aCr;
    public long aCs;
    public AlaAvtsData aCt;
    public AlaAvtsConfigInfo aCu;
    public AlaLiveInfoData aCv;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aCn = jSONObject.optInt("match_status");
            this.aCo = jSONObject.optString("status_text");
            this.aCp = jSONObject.optLong("match_user_id");
            this.aCq = jSONObject.optString("match_user_name");
            this.aCr = jSONObject.optString("match_avatar");
            this.aCs = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.aCt = new AlaAvtsData();
                this.aCt.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.aCu = new AlaAvtsConfigInfo();
                this.aCu.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.aCv = new AlaLiveInfoData();
                this.aCv.parserJson(optJSONObject);
            }
        }
    }

    public boolean BD() {
        return this.aCn == 1;
    }

    public boolean isTimeout() {
        return this.aCn == 2;
    }

    public boolean isValid() {
        return this.aCp > 0 && this.challengeId > 0 && this.aCv.getLiveID() > 0 && this.aCt.isValid();
    }
}
