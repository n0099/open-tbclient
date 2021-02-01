package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public long aFu;
    public String aFv;
    public String aFw;
    public AlaAvtsData aFy;
    public AlaAvtsConfigInfo aFz;
    public AlaLiveInfoData aOW;
    public int bOV;
    public String bOW;
    public long bOX;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bOV = jSONObject.optInt("match_status");
            this.bOW = jSONObject.optString("status_text");
            this.aFu = jSONObject.optLong("match_user_id");
            this.aFv = jSONObject.optString("match_user_name");
            this.aFw = jSONObject.optString("match_avatar");
            this.bOX = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.aFy = new AlaAvtsData();
                this.aFy.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.aFz = new AlaAvtsConfigInfo();
                this.aFz.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.aOW = new AlaLiveInfoData();
                this.aOW.parserJson(optJSONObject3);
            }
        }
    }
}
