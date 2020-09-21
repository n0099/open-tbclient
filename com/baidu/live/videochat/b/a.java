package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public long aCY;
    public String aCZ;
    public String aDa;
    public AlaAvtsData aDc;
    public AlaAvtsConfigInfo aDd;
    public AlaLiveInfoData aJW;
    public int buJ;
    public String buK;
    public long buL;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.buJ = jSONObject.optInt("match_status");
            this.buK = jSONObject.optString("status_text");
            this.aCY = jSONObject.optLong("match_user_id");
            this.aCZ = jSONObject.optString("match_user_name");
            this.aDa = jSONObject.optString("match_avatar");
            this.buL = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.aDc = new AlaAvtsData();
                this.aDc.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.aDd = new AlaAvtsConfigInfo();
                this.aDd.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.aJW = new AlaLiveInfoData();
                this.aJW.parserJson(optJSONObject3);
            }
        }
    }
}
