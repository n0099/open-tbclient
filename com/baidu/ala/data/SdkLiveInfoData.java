package com.baidu.ala.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaChallengeInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SdkLiveInfoData {
    public static final int TYPE_CHUSHOU_GAME_LIVE = 1;
    public static final int TYPE_TIEBA_GAME_LIVE = 2;
    public long createTime;
    public int from = 1;
    public LiveAuthor liveAuthor;
    public String liveId;
    public AlaLiveInfo liveInfo;
    public SdkMiddleStrategyInfo middleStrategyInfo;
    public String nid;
    public String recom_extra_img;
    public String recom_extra_img_dark;
    public int recom_extra_img_height;
    public String recom_extra_img_night;
    public int recom_extra_img_width;
    public String roomId;
    public int routerType;
    public String tid;
    public String title;
    public UiTransParam uiTransParam;

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.liveId = jSONObject.optString("live_id");
            this.roomId = jSONObject.optString("room_id");
            this.tid = jSONObject.optString("tid");
            this.nid = jSONObject.optString("nid");
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
            this.uiTransParam = new UiTransParam();
            JSONObject optJSONObject3 = jSONObject.optJSONObject("ui_transparam");
            if (optJSONObject3 != null) {
                this.uiTransParam.fromJson(optJSONObject3);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class LiveAuthor {
        public int gender;
        public String name;
        public String nameShow;
        public String open_id;
        public String portrait;

        public void fromJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.name = jSONObject.optString("name");
                this.nameShow = jSONObject.optString("name_show");
                this.gender = jSONObject.optInt("gender");
                this.portrait = jSONObject.optString("portrait");
                this.open_id = jSONObject.optString("open_id");
            }
        }

        public String getName_show() {
            return !StringUtils.isNull(this.nameShow) ? this.nameShow : this.name;
        }
    }

    /* loaded from: classes3.dex */
    public static class AlaLiveInfo {
        public long audienceCount;
        public AlaChallengeInfoData challengeInfoData;
        public String cover;
        public boolean haveRedpkg;
        public String hlsUrl;
        public int liveType;
        public String rtmpUrl;
        public int screenDirection;
        public String sessionId;

        public void fromJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.cover = jSONObject.optString("cover");
                this.sessionId = jSONObject.optString("session_id");
                this.rtmpUrl = jSONObject.optString("rtmp_url");
                this.hlsUrl = jSONObject.optString("hls_url");
                this.audienceCount = jSONObject.optLong("audience_count");
                this.liveType = jSONObject.optInt("live_type");
                this.screenDirection = jSONObject.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION);
                JSONObject optJSONObject = jSONObject.optJSONObject("challenge_info");
                if (optJSONObject != null) {
                    this.challengeInfoData = new AlaChallengeInfoData();
                    this.challengeInfoData.parserJson(optJSONObject);
                }
                this.haveRedpkg = "1".equals(jSONObject.optString("red_packet", ""));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class UiTransParam {
        public String abTag;
        public String extra;
        public String sourceFrom;
        public String starId;

        public void fromJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.abTag = jSONObject.optString("ab_tag");
                this.starId = jSONObject.optString("star_id");
                this.extra = jSONObject.optString("extra");
                this.sourceFrom = jSONObject.optString("source_from");
            }
        }
    }

    public boolean shouldJumpChushouLiveRoom() {
        return this.from != 2;
    }
}
