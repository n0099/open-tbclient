package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public long aFq;
    public String aFr;
    public String aFs;
    public AlaAvtsData aFu;
    public AlaAvtsConfigInfo aFv;
    public AlaLiveInfoData aMY;
    public int bGc;
    public String bGd;
    public long bGe;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bGc = jSONObject.optInt("match_status");
            this.bGd = jSONObject.optString("status_text");
            this.aFq = jSONObject.optLong("match_user_id");
            this.aFr = jSONObject.optString("match_user_name");
            this.aFs = jSONObject.optString("match_avatar");
            this.bGe = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.aFu = new AlaAvtsData();
                this.aFu.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.aFv = new AlaAvtsConfigInfo();
                this.aFv.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.aMY = new AlaLiveInfoData();
                this.aMY.parserJson(optJSONObject3);
            }
        }
    }
}
