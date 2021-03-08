package com.baidu.live.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class dj {
    public String aVk;
    public String aVl;
    public String aVm;
    public String aVn;
    public String aVo;
    public boolean aVp;
    public int aVq;
    public int aVr;
    public a aVs;
    public int aVt;
    public int aVu;
    public int aVv;
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
            this.aVk = jSONObject.optString("room_id");
            this.aVl = jSONObject.optString("rtc_room_id");
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.bg_cover = jSONObject.optString("bg_cover");
            this.live_id = jSONObject.optString("live_id");
            this.aVq = jSONObject.optInt("phone_host_num");
            this.aVr = jSONObject.optInt("phone_normal_num");
            this.is_followed = jSONObject.optInt("is_followed") == 1;
            this.aVt = jSONObject.optInt("room_daily_rank");
            this.aVu = jSONObject.optInt("is_host");
            this.aVm = jSONObject.optString("cover_mp4");
            this.aVn = jSONObject.optString("cover_mp4_zip");
            this.aVo = jSONObject.optString("background_md5");
            this.aVp = jSONObject.optInt("is_dynamic_cover", 0) == 1;
            this.aVv = jSONObject.optInt("audio_yy_sdk", 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("play_rules");
            if (optJSONObject != null) {
                this.aVs = new a();
                this.aVs.title = optJSONObject.optString("game_title");
                this.aVs.content = optJSONObject.optString("game_content");
            }
        }
    }
}
