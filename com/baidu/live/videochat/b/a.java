package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public long aCn;
    public String aCo;
    public String aCp;
    public AlaAvtsData aCr;
    public AlaAvtsConfigInfo aCs;
    public AlaLiveInfoData aIE;
    public int brr;
    public String brs;
    public long brt;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.brr = jSONObject.optInt("match_status");
            this.brs = jSONObject.optString("status_text");
            this.aCn = jSONObject.optLong("match_user_id");
            this.aCo = jSONObject.optString("match_user_name");
            this.aCp = jSONObject.optString("match_avatar");
            this.brt = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.aCr = new AlaAvtsData();
                this.aCr.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.aCs = new AlaAvtsConfigInfo();
                this.aCs.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.aIE = new AlaLiveInfoData();
                this.aIE.parserJson(optJSONObject3);
            }
        }
    }
}
