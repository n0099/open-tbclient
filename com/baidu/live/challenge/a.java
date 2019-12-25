package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public int UT;
    public String UU;
    public long UV;
    public String UW;
    public String UX;
    public long UY;
    public AlaAvtsData UZ;
    public AlaAvtsConfigInfo Va;
    public AlaLiveInfoData Vb;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.UT = jSONObject.optInt("match_status");
            this.UU = jSONObject.optString("status_text");
            this.UV = jSONObject.optLong("match_user_id");
            this.UW = jSONObject.optString("match_user_name");
            this.UX = jSONObject.optString("match_avatar");
            this.UY = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.UZ = new AlaAvtsData();
                this.UZ.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.Va = new AlaAvtsConfigInfo();
                this.Va.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.Vb = new AlaLiveInfoData();
                this.Vb.parserJson(optJSONObject);
            }
        }
    }

    public boolean oU() {
        return this.UT == 1;
    }

    public boolean isTimeout() {
        return this.UT == 2;
    }

    public boolean isValid() {
        return this.UV > 0 && this.challengeId > 0 && this.Vb.getLiveID() > 0 && this.UZ.isValid();
    }
}
