package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int awe;
    public String awf;
    public long awg;
    public String awh;
    public String awi;
    public long awj;
    public AlaAvtsData awk;
    public AlaAvtsConfigInfo awl;
    public AlaLiveInfoData awm;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.awe = jSONObject.optInt("match_status");
            this.awf = jSONObject.optString("status_text");
            this.awg = jSONObject.optLong("match_user_id");
            this.awh = jSONObject.optString("match_user_name");
            this.awi = jSONObject.optString("match_avatar");
            this.awj = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.awk = new AlaAvtsData();
                this.awk.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.awl = new AlaAvtsConfigInfo();
                this.awl.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.awm = new AlaLiveInfoData();
                this.awm.parserJson(optJSONObject);
            }
        }
    }

    public boolean vJ() {
        return this.awe == 1;
    }

    public boolean isTimeout() {
        return this.awe == 2;
    }

    public boolean isValid() {
        return this.awg > 0 && this.challengeId > 0 && this.awm.getLiveID() > 0 && this.awk.isValid();
    }
}
