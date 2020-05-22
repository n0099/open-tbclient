package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public long aue;
    public String auf;
    public String aug;
    public AlaAvtsData aui;
    public AlaAvtsConfigInfo auj;
    public AlaLiveInfoData azA;
    public int bgk;
    public String bgl;
    public long bgm;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bgk = jSONObject.optInt("match_status");
            this.bgl = jSONObject.optString("status_text");
            this.aue = jSONObject.optLong("match_user_id");
            this.auf = jSONObject.optString("match_user_name");
            this.aug = jSONObject.optString("match_avatar");
            this.bgm = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.aui = new AlaAvtsData();
                this.aui.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.auj = new AlaAvtsConfigInfo();
                this.auj.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.azA = new AlaLiveInfoData();
                this.azA.parserJson(optJSONObject3);
            }
        }
    }
}
