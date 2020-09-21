package com.baidu.live.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cl {
    public int aNA;
    public int aNB;
    public boolean aNC;
    public a aND;
    public int aNE;
    public String aNw;
    public String aNx;
    public String aNy;
    public String aNz;
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
            this.aNw = jSONObject.optString("croom_id");
            this.aNx = jSONObject.optString("room_id");
            this.aNy = jSONObject.optString("rtc_room_id");
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.aNz = jSONObject.optString("bg_cover");
            this.live_id = jSONObject.optString("live_id");
            this.aNA = jSONObject.optInt("phone_host_num");
            this.aNB = jSONObject.optInt("phone_normal_num");
            this.aNC = jSONObject.optInt("is_followed") == 1;
            this.aNE = jSONObject.optInt("room_daily_rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("play_rules");
            if (optJSONObject != null) {
                this.aND = new a();
                this.aND.title = optJSONObject.optString("game_title");
                this.aND.content = optJSONObject.optString("game_content");
            }
        }
    }
}
