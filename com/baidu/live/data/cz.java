package com.baidu.live.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cz {
    public String aUg;
    public String aUh;
    public int aUi;
    public int aUj;
    public a aUk;
    public int aUl;
    public String bg_cover;
    public String cover;
    public String croom_id;
    public boolean is_followed;
    public String live_id;
    public String room_name;

    /* loaded from: classes4.dex */
    public static class a {
        public String content;
        public String title;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.croom_id = jSONObject.optString("croom_id");
            this.aUg = jSONObject.optString("room_id");
            this.aUh = jSONObject.optString("rtc_room_id");
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.bg_cover = jSONObject.optString("bg_cover");
            this.live_id = jSONObject.optString("live_id");
            this.aUi = jSONObject.optInt("phone_host_num");
            this.aUj = jSONObject.optInt("phone_normal_num");
            this.is_followed = jSONObject.optInt("is_followed") == 1;
            this.aUl = jSONObject.optInt("room_daily_rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("play_rules");
            if (optJSONObject != null) {
                this.aUk = new a();
                this.aUk.title = optJSONObject.optString("game_title");
                this.aUk.content = optJSONObject.optString("game_content");
            }
        }
    }
}
