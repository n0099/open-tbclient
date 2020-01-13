package com.baidu.ala.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SdkLiveInfoData {
    public static final int TYPE_CHUSHOU_GAME_LIVE = 1;
    public static final int TYPE_TIEBA_GAME_LIVE = 2;
    public long createTime;
    public int from = 1;
    public LiveAuthor liveAuthor;
    public AlaLiveInfo liveInfo;
    public String recom_extra_img;
    public String recom_extra_img_dark;
    public int recom_extra_img_height;
    public String recom_extra_img_night;
    public int recom_extra_img_width;
    public String roomId;
    public int routerType;
    public String title;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.roomId = jSONObject.optString("room_id");
            this.routerType = jSONObject.optInt("routerType");
            this.title = jSONObject.optString("title");
            this.createTime = jSONObject.optLong("create_time");
            this.from = jSONObject.optInt("from");
            this.recom_extra_img = jSONObject.optString("recom_extra_img");
            this.recom_extra_img_night = jSONObject.optString("recom_extra_img_night");
            this.recom_extra_img_dark = jSONObject.optString("recom_extra_img_dark");
            this.recom_extra_img_width = jSONObject.optInt("recom_extra_img_width");
            this.recom_extra_img_height = jSONObject.optInt("recom_extra_img_height");
            this.liveAuthor = new LiveAuthor();
            JSONObject optJSONObject = jSONObject.optJSONObject("author");
            if (optJSONObject != null) {
                this.liveAuthor.fromJson(optJSONObject);
            }
            this.liveInfo = new AlaLiveInfo();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ala_info");
            if (optJSONObject2 != null) {
                this.liveInfo.fromJson(optJSONObject2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class LiveAuthor {
        public int gender;
        public String name;
        public String open_id;
        public String portrait;

        public void fromJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.name = jSONObject.optString("name");
                this.gender = jSONObject.optInt("gender");
                this.portrait = jSONObject.optString("portrait");
                this.open_id = jSONObject.optString("open_id");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class AlaLiveInfo {
        public long audienceCount;
        public String cover;
        public String hlsUrl;
        public int liveType;
        public String rtmpUrl;
        public int screenDirection;

        public void fromJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.cover = jSONObject.optString("cover");
                this.rtmpUrl = jSONObject.optString("rtmp_url");
                this.hlsUrl = jSONObject.optString("hls_url");
                this.audienceCount = jSONObject.optLong("audience_count");
                this.liveType = jSONObject.optInt("live_type");
                this.screenDirection = jSONObject.optInt("screen_direction");
            }
        }
    }

    public boolean shouldJumpChushouLiveRoom() {
        return this.from != 2;
    }
}
