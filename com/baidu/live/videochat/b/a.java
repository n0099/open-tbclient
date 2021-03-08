package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public long aGU;
    public String aGV;
    public String aGW;
    public AlaAvtsData aGY;
    public AlaAvtsConfigInfo aGZ;
    public AlaLiveInfoData aQw;
    public int bQv;
    public String bQw;
    public long bQx;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bQv = jSONObject.optInt("match_status");
            this.bQw = jSONObject.optString("status_text");
            this.aGU = jSONObject.optLong("match_user_id");
            this.aGV = jSONObject.optString("match_user_name");
            this.aGW = jSONObject.optString("match_avatar");
            this.bQx = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.aGY = new AlaAvtsData();
                this.aGY.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.aGZ = new AlaAvtsConfigInfo();
                this.aGZ.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.aQw = new AlaLiveInfoData();
                this.aQw.parserJson(optJSONObject3);
            }
        }
    }
}
