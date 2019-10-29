package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public String OA;
    public long OB;
    public AlaAvtsData OC;
    public AlaAvtsConfigInfo OD;
    public AlaLiveInfoData OE;
    public int Ow;
    public String Ox;
    public long Oy;
    public String Oz;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Ow = jSONObject.optInt("match_status");
            this.Ox = jSONObject.optString("status_text");
            this.Oy = jSONObject.optLong("match_user_id");
            this.Oz = jSONObject.optString("match_user_name");
            this.OA = jSONObject.optString("match_avatar");
            this.OB = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.OC = new AlaAvtsData();
                this.OC.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.OD = new AlaAvtsConfigInfo();
                this.OD.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.OE = new AlaLiveInfoData();
                this.OE.parserJson(optJSONObject);
            }
        }
    }

    public boolean nC() {
        return this.Ow == 1;
    }

    public boolean isTimeout() {
        return this.Ow == 2;
    }

    public boolean isValid() {
        return this.Oy > 0 && this.challengeId > 0 && this.OE.getLiveID() > 0 && this.OC.isValid();
    }
}
