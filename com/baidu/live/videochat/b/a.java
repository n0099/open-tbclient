package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public long aGl;
    public String aGm;
    public String aGn;
    public AlaAvtsData aGp;
    public AlaAvtsConfigInfo aGq;
    public AlaLiveInfoData aNG;
    public int bBH;
    public String bBI;
    public long bBJ;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bBH = jSONObject.optInt("match_status");
            this.bBI = jSONObject.optString("status_text");
            this.aGl = jSONObject.optLong("match_user_id");
            this.aGm = jSONObject.optString("match_user_name");
            this.aGn = jSONObject.optString("match_avatar");
            this.bBJ = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.aGp = new AlaAvtsData();
                this.aGp.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.aGq = new AlaAvtsConfigInfo();
                this.aGq.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.aNG = new AlaLiveInfoData();
                this.aNG.parserJson(optJSONObject3);
            }
        }
    }
}
