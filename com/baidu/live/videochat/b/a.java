package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public long aIu;
    public String aIv;
    public String aIw;
    public AlaAvtsData aIy;
    public AlaAvtsConfigInfo aIz;
    public AlaLiveInfoData aQM;
    public int bPX;
    public String bPY;
    public long bPZ;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bPX = jSONObject.optInt("match_status");
            this.bPY = jSONObject.optString("status_text");
            this.aIu = jSONObject.optLong("match_user_id");
            this.aIv = jSONObject.optString("match_user_name");
            this.aIw = jSONObject.optString("match_avatar");
            this.bPZ = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.aIy = new AlaAvtsData();
                this.aIy.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.aIz = new AlaAvtsConfigInfo();
                this.aIz.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.aQM = new AlaLiveInfoData();
                this.aQM.parserJson(optJSONObject3);
            }
        }
    }
}
