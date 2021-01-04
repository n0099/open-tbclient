package com.baidu.live.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class dd {
    public int aVA;
    public int aVB;
    public a aVC;
    public int aVD;
    public String aVu;
    public String aVv;
    public String aVw;
    public String aVx;
    public String aVy;
    public boolean aVz;
    public String bg_cover;
    public String cover;
    public String croom_id;
    public boolean is_followed;
    public String live_id;
    public String room_name;

    /* loaded from: classes11.dex */
    public static class a {
        public String content;
        public String title;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.croom_id = jSONObject.optString("croom_id");
            this.aVu = jSONObject.optString("room_id");
            this.aVv = jSONObject.optString("rtc_room_id");
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.bg_cover = jSONObject.optString("bg_cover");
            this.live_id = jSONObject.optString("live_id");
            this.aVA = jSONObject.optInt("phone_host_num");
            this.aVB = jSONObject.optInt("phone_normal_num");
            this.is_followed = jSONObject.optInt("is_followed") == 1;
            this.aVD = jSONObject.optInt("room_daily_rank");
            this.aVw = jSONObject.optString("cover_mp4");
            this.aVx = jSONObject.optString("cover_mp4_zip");
            this.aVy = jSONObject.optString("background_md5");
            this.aVz = jSONObject.optInt("is_dynamic_cover", 0) == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("play_rules");
            if (optJSONObject != null) {
                this.aVC = new a();
                this.aVC.title = optJSONObject.optString("game_title");
                this.aVC.content = optJSONObject.optString("game_content");
            }
        }
    }
}
