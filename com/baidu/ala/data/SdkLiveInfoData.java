package com.baidu.ala.data;

import androidx.core.app.NotificationCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaChallengeInfoData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SdkLiveInfoData {
    public static final int TYPE_CHUSHOU_GAME_LIVE = 1;
    public static final int TYPE_TIEBA_GAME_LIVE = 2;
    public long createTime;
    public int from = 1;
    public String labelUrl;
    public LiveAuthor liveAuthor;
    public String liveId;
    public AlaLiveInfo liveInfo;
    public String location;
    public SdkMiddleStrategyInfo middleStrategyInfo;
    public String modeUrl;
    public String nid;
    public String recom_extra_img;
    public String recom_extra_img_dark;
    public int recom_extra_img_height;
    public String recom_extra_img_night;
    public int recom_extra_img_width;
    public String roomId;
    public int routerType;
    public String source;
    public String tid;
    public String title;
    public UiTransParam uiTransParam;

    /* loaded from: classes.dex */
    public static class AlaLiveInfo {
        public long audienceCount;
        public AlaChallengeInfoData challengeInfoData;
        public String cover;
        public boolean haveRedpkg;
        public String hlsUrl;
        public int liveType;
        public int roomStatus;
        public String rtmpUrl;
        public int screenDirection;
        public String sessionId;

        public void fromJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.cover = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
            this.sessionId = jSONObject.optString(ETAG.KEY_STATISTICS_SEESIONID);
            this.rtmpUrl = jSONObject.optString("rtmp_url");
            this.hlsUrl = jSONObject.optString("hls_url");
            this.audienceCount = jSONObject.optLong("audience_count");
            this.liveType = jSONObject.optInt("live_type");
            this.screenDirection = jSONObject.optInt("screen_direction");
            this.roomStatus = jSONObject.optInt("room_status");
            JSONObject optJSONObject = jSONObject.optJSONObject("challenge_info");
            if (optJSONObject != null) {
                AlaChallengeInfoData alaChallengeInfoData = new AlaChallengeInfoData();
                this.challengeInfoData = alaChallengeInfoData;
                alaChallengeInfoData.parserJson(optJSONObject);
            }
            this.haveRedpkg = "1".equals(jSONObject.optString("red_packet", ""));
        }
    }

    /* loaded from: classes.dex */
    public static class LiveAuthor {
        public int gender;
        public String name;
        public String nameShow;
        public String open_id;
        public String portrait;

        public void fromJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.name = jSONObject.optString("name");
            this.nameShow = jSONObject.optString("name_show");
            this.gender = jSONObject.optInt("gender");
            this.portrait = jSONObject.optString("portrait");
            this.open_id = jSONObject.optString("open_id");
        }

        public String getName_show() {
            if (!StringUtils.isNull(this.nameShow)) {
                return this.nameShow;
            }
            return this.name;
        }
    }

    /* loaded from: classes.dex */
    public static class UiTransParam {
        public String abTag;
        public String extra;
        public String sourceFrom;
        public String starId;

        public void fromJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.abTag = jSONObject.optString("ab_tag");
            this.starId = jSONObject.optString(TiebaStatic.Params.STAR_ID);
            this.extra = jSONObject.optString("extra");
            this.sourceFrom = jSONObject.optString("source_from");
        }
    }

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.liveId = jSONObject.optString("live_id");
        this.roomId = jSONObject.optString("room_id");
        this.tid = jSONObject.optString("tid");
        this.nid = jSONObject.optString("nid");
        this.routerType = jSONObject.optInt("routerType");
        this.title = jSONObject.optString("title");
        this.createTime = jSONObject.optLong("create_time");
        this.from = jSONObject.optInt("from");
        this.source = jSONObject.optString("source");
        this.recom_extra_img = jSONObject.optString("recom_extra_img");
        this.recom_extra_img_night = jSONObject.optString("recom_extra_img_night");
        this.recom_extra_img_dark = jSONObject.optString("recom_extra_img_dark");
        this.recom_extra_img_width = jSONObject.optInt("recom_extra_img_width");
        this.recom_extra_img_height = jSONObject.optInt("recom_extra_img_height");
        this.labelUrl = jSONObject.optString("label_url");
        this.modeUrl = jSONObject.optString("mode_url");
        this.location = jSONObject.optString("location");
        this.liveAuthor = new LiveAuthor();
        JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
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

    public boolean shouldJumpChushouLiveRoom() {
        return this.from != 2;
    }
}
