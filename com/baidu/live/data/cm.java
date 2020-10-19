package com.baidu.live.data;

import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cm {
    public String aQH;
    public String aQI;
    public String aQJ;
    public String aQK;
    public int aQL;
    public int aQM;
    public boolean aQN;
    public a aQO;
    public int aQP;
    public String cover;
    public String live_id;
    public String room_name;

    /* loaded from: classes4.dex */
    public static class a {
        public String content;
        public String title;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQH = jSONObject.optString("croom_id");
            this.aQI = jSONObject.optString("room_id");
            this.aQJ = jSONObject.optString(RtcConstants.EXTRA_RTC_ROOM_ID);
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.aQK = jSONObject.optString("bg_cover");
            this.live_id = jSONObject.optString("live_id");
            this.aQL = jSONObject.optInt("phone_host_num");
            this.aQM = jSONObject.optInt("phone_normal_num");
            this.aQN = jSONObject.optInt("is_followed") == 1;
            this.aQP = jSONObject.optInt("room_daily_rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("play_rules");
            if (optJSONObject != null) {
                this.aQO = new a();
                this.aQO.title = optJSONObject.optString("game_title");
                this.aQO.content = optJSONObject.optString("game_content");
            }
        }
    }
}
