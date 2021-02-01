package com.baidu.live.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class dj {
    public String aTK;
    public String aTL;
    public String aTM;
    public String aTN;
    public String aTO;
    public boolean aTP;
    public int aTQ;
    public int aTR;
    public a aTS;
    public int aTT;
    public int aTU;
    public int aTV;
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
            this.aTK = jSONObject.optString("room_id");
            this.aTL = jSONObject.optString("rtc_room_id");
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.bg_cover = jSONObject.optString("bg_cover");
            this.live_id = jSONObject.optString("live_id");
            this.aTQ = jSONObject.optInt("phone_host_num");
            this.aTR = jSONObject.optInt("phone_normal_num");
            this.is_followed = jSONObject.optInt("is_followed") == 1;
            this.aTT = jSONObject.optInt("room_daily_rank");
            this.aTU = jSONObject.optInt("is_host");
            this.aTM = jSONObject.optString("cover_mp4");
            this.aTN = jSONObject.optString("cover_mp4_zip");
            this.aTO = jSONObject.optString("background_md5");
            this.aTP = jSONObject.optInt("is_dynamic_cover", 0) == 1;
            this.aTV = jSONObject.optInt("audio_yy_sdk", 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("play_rules");
            if (optJSONObject != null) {
                this.aTS = new a();
                this.aTS.title = optJSONObject.optString("game_title");
                this.aTS.content = optJSONObject.optString("game_content");
            }
        }
    }
}
