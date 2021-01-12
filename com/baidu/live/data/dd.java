package com.baidu.live.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class dd {
    public String aQH;
    public String aQI;
    public String aQJ;
    public String aQK;
    public String aQL;
    public boolean aQM;
    public int aQN;
    public int aQO;
    public a aQP;
    public int aQQ;
    public String bg_cover;
    public String cover;
    public String croom_id;
    public boolean is_followed;
    public String live_id;
    public String room_name;

    /* loaded from: classes10.dex */
    public static class a {
        public String content;
        public String title;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.croom_id = jSONObject.optString("croom_id");
            this.aQH = jSONObject.optString("room_id");
            this.aQI = jSONObject.optString("rtc_room_id");
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.bg_cover = jSONObject.optString("bg_cover");
            this.live_id = jSONObject.optString("live_id");
            this.aQN = jSONObject.optInt("phone_host_num");
            this.aQO = jSONObject.optInt("phone_normal_num");
            this.is_followed = jSONObject.optInt("is_followed") == 1;
            this.aQQ = jSONObject.optInt("room_daily_rank");
            this.aQJ = jSONObject.optString("cover_mp4");
            this.aQK = jSONObject.optString("cover_mp4_zip");
            this.aQL = jSONObject.optString("background_md5");
            this.aQM = jSONObject.optInt("is_dynamic_cover", 0) == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("play_rules");
            if (optJSONObject != null) {
                this.aQP = new a();
                this.aQP.title = optJSONObject.optString("game_title");
                this.aQP.content = optJSONObject.optString("game_content");
            }
        }
    }
}
