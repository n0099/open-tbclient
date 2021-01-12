package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public int aDF;
    public String aDG;
    public long aDH;
    public String aDI;
    public String aDJ;
    public long aDK;
    public AlaAvtsData aDL;
    public AlaAvtsConfigInfo aDM;
    public AlaLiveInfoData aDN;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aDF = jSONObject.optInt("match_status");
            this.aDG = jSONObject.optString("status_text");
            this.aDH = jSONObject.optLong("match_user_id");
            this.aDI = jSONObject.optString("match_user_name");
            this.aDJ = jSONObject.optString("match_avatar");
            this.aDK = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.aDL = new AlaAvtsData();
                this.aDL.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.aDM = new AlaAvtsConfigInfo();
                this.aDM.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.aDN = new AlaLiveInfoData();
                this.aDN.parserJson(optJSONObject);
            }
        }
    }

    public boolean zJ() {
        return this.aDF == 1;
    }

    public boolean isTimeout() {
        return this.aDF == 2;
    }

    public boolean isValid() {
        return this.aDH > 0 && this.challengeId > 0 && this.aDN.getLiveID() > 0 && this.aDL.isValid();
    }
}
