package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int api;
    public String apj;
    public long apk;
    public String apl;
    public String apm;
    public long apn;
    public AlaAvtsData apo;
    public AlaAvtsConfigInfo apq;
    public AlaLiveInfoData apr;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.api = jSONObject.optInt("match_status");
            this.apj = jSONObject.optString("status_text");
            this.apk = jSONObject.optLong("match_user_id");
            this.apl = jSONObject.optString("match_user_name");
            this.apm = jSONObject.optString("match_avatar");
            this.apn = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.apo = new AlaAvtsData();
                this.apo.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.apq = new AlaAvtsConfigInfo();
                this.apq.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.apr = new AlaLiveInfoData();
                this.apr.parserJson(optJSONObject);
            }
        }
    }

    public boolean uh() {
        return this.api == 1;
    }

    public boolean isTimeout() {
        return this.api == 2;
    }

    public boolean isValid() {
        return this.apk > 0 && this.challengeId > 0 && this.apr.getLiveID() > 0 && this.apo.isValid();
    }
}
