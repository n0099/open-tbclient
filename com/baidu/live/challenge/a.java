package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public int NW;
    public String NX;
    public long NY;
    public String NZ;
    public String Oa;
    public long Ob;
    public AlaAvtsData Oc;
    public AlaAvtsConfigInfo Od;
    public AlaLiveInfoData Oe;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.NW = jSONObject.optInt("match_status");
            this.NX = jSONObject.optString("status_text");
            this.NY = jSONObject.optLong("match_user_id");
            this.NZ = jSONObject.optString("match_user_name");
            this.Oa = jSONObject.optString("match_avatar");
            this.Ob = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.Oc = new AlaAvtsData();
                this.Oc.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.Od = new AlaAvtsConfigInfo();
                this.Od.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.Oe = new AlaLiveInfoData();
                this.Oe.parserJson(optJSONObject);
            }
        }
    }

    public boolean nC() {
        return this.NW == 1;
    }

    public boolean isTimeout() {
        return this.NW == 2;
    }

    public boolean isValid() {
        return this.NY > 0 && this.challengeId > 0 && this.Oe.getLiveID() > 0 && this.Oc.isValid();
    }
}
