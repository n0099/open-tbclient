package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public long aHY;
    public String aHZ;
    public String aIa;
    public AlaAvtsData aIc;
    public AlaAvtsConfigInfo aId;
    public AlaLiveInfoData aPX;
    public int bLk;
    public String bLl;
    public long bLm;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bLk = jSONObject.optInt("match_status");
            this.bLl = jSONObject.optString("status_text");
            this.aHY = jSONObject.optLong("match_user_id");
            this.aHZ = jSONObject.optString("match_user_name");
            this.aIa = jSONObject.optString("match_avatar");
            this.bLm = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.aIc = new AlaAvtsData();
                this.aIc.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.aId = new AlaAvtsConfigInfo();
                this.aId.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.aPX = new AlaLiveInfoData();
                this.aPX.parserJson(optJSONObject3);
            }
        }
    }
}
