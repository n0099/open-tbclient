package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int WQ;
    public String WR;
    public long WS;
    public String WT;
    public String WU;
    public long WV;
    public AlaAvtsData WW;
    public AlaAvtsConfigInfo WX;
    public AlaLiveInfoData WY;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.WQ = jSONObject.optInt("match_status");
            this.WR = jSONObject.optString("status_text");
            this.WS = jSONObject.optLong("match_user_id");
            this.WT = jSONObject.optString("match_user_name");
            this.WU = jSONObject.optString("match_avatar");
            this.WV = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.WW = new AlaAvtsData();
                this.WW.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.WX = new AlaAvtsConfigInfo();
                this.WX.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.WY = new AlaLiveInfoData();
                this.WY.parserJson(optJSONObject);
            }
        }
    }

    public boolean pM() {
        return this.WQ == 1;
    }

    public boolean isTimeout() {
        return this.WQ == 2;
    }

    public boolean isValid() {
        return this.WS > 0 && this.challengeId > 0 && this.WY.getLiveID() > 0 && this.WW.isValid();
    }
}
