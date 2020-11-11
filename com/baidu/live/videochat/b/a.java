package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public long aHb;
    public String aHc;
    public String aHd;
    public AlaAvtsData aHf;
    public AlaAvtsConfigInfo aHg;
    public AlaLiveInfoData aOJ;
    public int bHN;
    public String bHO;
    public long bHP;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bHN = jSONObject.optInt("match_status");
            this.bHO = jSONObject.optString("status_text");
            this.aHb = jSONObject.optLong("match_user_id");
            this.aHc = jSONObject.optString("match_user_name");
            this.aHd = jSONObject.optString("match_avatar");
            this.bHP = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.aHf = new AlaAvtsData();
                this.aHf.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.aHg = new AlaAvtsConfigInfo();
                this.aHg.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.aOJ = new AlaLiveInfoData();
                this.aOJ.parserJson(optJSONObject3);
            }
        }
    }
}
