package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int aFo;
    public String aFp;
    public long aFq;
    public String aFr;
    public String aFs;
    public long aFt;
    public AlaAvtsData aFu;
    public AlaAvtsConfigInfo aFv;
    public AlaLiveInfoData aFw;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aFo = jSONObject.optInt("match_status");
            this.aFp = jSONObject.optString("status_text");
            this.aFq = jSONObject.optLong("match_user_id");
            this.aFr = jSONObject.optString("match_user_name");
            this.aFs = jSONObject.optString("match_avatar");
            this.aFt = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.aFu = new AlaAvtsData();
                this.aFu.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.aFv = new AlaAvtsConfigInfo();
                this.aFv.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.aFw = new AlaLiveInfoData();
                this.aFw.parserJson(optJSONObject);
            }
        }
    }

    public boolean CF() {
        return this.aFo == 1;
    }

    public boolean isTimeout() {
        return this.aFo == 2;
    }

    public boolean isValid() {
        return this.aFq > 0 && this.challengeId > 0 && this.aFw.getLiveID() > 0 && this.aFu.isValid();
    }
}
