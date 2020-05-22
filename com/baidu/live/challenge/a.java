package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int auc;
    public String aud;
    public long aue;
    public String auf;
    public String aug;
    public long auh;
    public AlaAvtsData aui;
    public AlaAvtsConfigInfo auj;
    public AlaLiveInfoData auk;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.auc = jSONObject.optInt("match_status");
            this.aud = jSONObject.optString("status_text");
            this.aue = jSONObject.optLong("match_user_id");
            this.auf = jSONObject.optString("match_user_name");
            this.aug = jSONObject.optString("match_avatar");
            this.auh = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.aui = new AlaAvtsData();
                this.aui.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.auj = new AlaAvtsConfigInfo();
                this.auj.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.auk = new AlaLiveInfoData();
                this.auk.parserJson(optJSONObject);
            }
        }
    }

    public boolean vo() {
        return this.auc == 1;
    }

    public boolean isTimeout() {
        return this.auc == 2;
    }

    public boolean isValid() {
        return this.aue > 0 && this.challengeId > 0 && this.auk.getLiveID() > 0 && this.aui.isValid();
    }
}
