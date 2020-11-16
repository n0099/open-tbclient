package com.baidu.live.data;

import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cx {
    public String aRe;
    public String aRf;
    public int aRg;
    public int aRh;
    public a aRi;
    public int aRj;
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
            this.aRe = jSONObject.optString("room_id");
            this.aRf = jSONObject.optString(RtcConstants.EXTRA_RTC_ROOM_ID);
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.bg_cover = jSONObject.optString("bg_cover");
            this.live_id = jSONObject.optString("live_id");
            this.aRg = jSONObject.optInt("phone_host_num");
            this.aRh = jSONObject.optInt("phone_normal_num");
            this.is_followed = jSONObject.optInt("is_followed") == 1;
            this.aRj = jSONObject.optInt("room_daily_rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("play_rules");
            if (optJSONObject != null) {
                this.aRi = new a();
                this.aRi.title = optJSONObject.optString("game_title");
                this.aRi.content = optJSONObject.optString("game_content");
            }
        }
    }
}
