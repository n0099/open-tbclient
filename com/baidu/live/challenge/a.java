package com.baidu.live.challenge;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int Xa;
    public String Xb;
    public long Xc;
    public String Xd;
    public String Xe;
    public long Xf;
    public AlaAvtsData Xg;
    public AlaAvtsConfigInfo Xh;
    public AlaLiveInfoData Xi;
    public long challengeId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Xa = jSONObject.optInt("match_status");
            this.Xb = jSONObject.optString("status_text");
            this.Xc = jSONObject.optLong("match_user_id");
            this.Xd = jSONObject.optString("match_user_name");
            this.Xe = jSONObject.optString("match_avatar");
            this.Xf = jSONObject.optLong("match_time");
            this.challengeId = jSONObject.optLong("challenge_id");
            if (jSONObject.optJSONObject("avts_addr") != null) {
                this.Xg = new AlaAvtsData();
                this.Xg.parserJson(jSONObject.optJSONObject("avts_addr"));
            }
            if (jSONObject.optJSONObject("avts_conf") != null) {
                this.Xh = new AlaAvtsConfigInfo();
                this.Xh.parserJson(jSONObject.optJSONObject("avts_conf"));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject != null) {
                this.Xi = new AlaLiveInfoData();
                this.Xi.parserJson(optJSONObject);
            }
        }
    }

    public boolean pR() {
        return this.Xa == 1;
    }

    public boolean isTimeout() {
        return this.Xa == 2;
    }

    public boolean isValid() {
        return this.Xc > 0 && this.challengeId > 0 && this.Xi.getLiveID() > 0 && this.Xg.isValid();
    }
}
