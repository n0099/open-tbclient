package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public long aDH;
    public String aDI;
    public String aDJ;
    public AlaAvtsData aDL;
    public AlaAvtsConfigInfo aDM;
    public AlaLiveInfoData aLZ;
    public int bLl;
    public String bLm;
    public long bLn;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bLl = jSONObject.optInt("match_status");
            this.bLm = jSONObject.optString("status_text");
            this.aDH = jSONObject.optLong("match_user_id");
            this.aDI = jSONObject.optString("match_user_name");
            this.aDJ = jSONObject.optString("match_avatar");
            this.bLn = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.aDL = new AlaAvtsData();
                this.aDL.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.aDM = new AlaAvtsConfigInfo();
                this.aDM.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.aLZ = new AlaLiveInfoData();
                this.aLZ.parserJson(optJSONObject3);
            }
        }
    }
}
