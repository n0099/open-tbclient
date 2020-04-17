package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int apc;
    public String apd;
    public long ape;
    public String apf;
    public String apg;
    public long aph;
    public AlaAvtsData api;
    public AlaAvtsConfigInfo apj;
    public AlaLiveInfoData apk;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.apc = jSONObject.optInt("match_status");
            this.apd = jSONObject.optString("status_text");
            this.ape = jSONObject.optLong("match_user_id");
            this.apf = jSONObject.optString("match_user_name");
            this.apg = jSONObject.optString("match_avatar");
            this.aph = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.api = new AlaAvtsData();
                this.api.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.apj = new AlaAvtsConfigInfo();
                this.apj.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.apk = new AlaLiveInfoData();
                this.apk.parserJson(optJSONObject);
            }
        }
    }

    public boolean ui() {
        return this.apc == 1;
    }

    public boolean isTimeout() {
        return this.apc == 2;
    }

    public boolean isValid() {
        return this.ape > 0 && this.challengeId > 0 && this.apk.getLiveID() > 0 && this.api.isValid();
    }
}
