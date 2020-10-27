package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int aGj;
    public String aGk;
    public long aGl;
    public String aGm;
    public String aGn;
    public long aGo;
    public AlaAvtsData aGp;
    public AlaAvtsConfigInfo aGq;
    public AlaLiveInfoData aGr;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aGj = jSONObject.optInt("match_status");
            this.aGk = jSONObject.optString("status_text");
            this.aGl = jSONObject.optLong("match_user_id");
            this.aGm = jSONObject.optString("match_user_name");
            this.aGn = jSONObject.optString("match_avatar");
            this.aGo = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.aGp = new AlaAvtsData();
                this.aGp.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.aGq = new AlaAvtsConfigInfo();
                this.aGq.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.aGr = new AlaLiveInfoData();
                this.aGr.parserJson(optJSONObject);
            }
        }
    }

    public boolean CV() {
        return this.aGj == 1;
    }

    public boolean isTimeout() {
        return this.aGj == 2;
    }

    public boolean isValid() {
        return this.aGl > 0 && this.challengeId > 0 && this.aGr.getLiveID() > 0 && this.aGp.isValid();
    }
}
