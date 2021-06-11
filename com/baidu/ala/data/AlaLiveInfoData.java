package com.baidu.ala.data;

import alaim.LiveInfo;
import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.webkit.internal.ETAG;
import com.yy.gslbsdk.db.ResultTB;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AlaLiveInfoData extends OrmObject implements Serializable {
    public static final int LIVE_SCREEN_DIRECTION_LANDSCAPE = 2;
    public static final int LIVE_SCREEN_DIRECTION_PORTRAIT = 1;
    public static final int LIVE_SESSION_DEFAULT_BACK = 2;
    public static final int LIVE_SESSION_DEFAULT_MAIN = 1;
    public static final int LIVE_STATUS_END = 2;
    public static final int LIVE_STATUS_LIVING = 1;
    public static final int LIVE_STATUS_PLAYBACK = 3;
    public static final int LIVE_STATUS_PLAYBACK_DELETE = 4;
    public static final int LIVE_TYPE_CAMERA = 1;
    public static final int LIVE_TYPE_SCREEN_RECORD = 2;
    public static final long serialVersionUID = 5768965545624138312L;
    public String appId;
    public int audience_count;
    public int backstage_type;
    public String call_path_android;
    public long challengeId;
    public long channel_id;
    public String channel_name;
    public int charm_count;
    public int clarity;
    public String close_reason;
    public int close_type;
    public int comment_count;
    public String cover;
    public String description;
    public long end_time;
    public int flower_count;
    public long forum_id;
    public String forum_name;
    public String game_icon;
    public String game_id;
    public String game_label;
    public long group_id;
    public int isAudioOnPrivate;
    public int isOnPrivate;
    public int join_count;
    public long last_msg_id;
    public long live_duration;
    public long live_id;
    public int live_status;
    public int live_type;
    public String location;
    public String media_pic;
    public int openType;
    public long pkId;
    public int play_count;
    public int screen_direction;
    public String session_id;
    public String share_url;
    public long start_time;
    public long thread_id;
    public long user_id;
    public String user_name;
    public String user_nickname;
    public int zan_count;
    public int session_default = 0;
    public int mCurrentSessionLine = 0;
    public long broadGiftMsgId = 0;
    public long noticeBroadcastMsgId = 0;
    public boolean isPullMode = false;

    public int getAudienceCount() {
        return this.audience_count;
    }

    public String getLocation() {
        return this.location;
    }

    public String getMedia_pic() {
        return this.media_pic;
    }

    public String getNameShow() {
        if (TextUtils.isEmpty(this.user_nickname)) {
            return this.user_name;
        }
        return this.user_nickname;
    }

    public int getPlay_count() {
        return this.play_count;
    }

    public String getUserName() {
        return this.user_name;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void parserProtoBuf(LiveInfo liveInfo) {
        if (liveInfo == null) {
            return;
        }
        this.live_id = liveInfo.live_id.longValue();
        this.user_id = liveInfo.user_id.longValue();
        this.user_name = liveInfo.user_name;
        this.user_nickname = liveInfo.user_nickname;
        this.group_id = liveInfo.group_id.longValue();
        this.last_msg_id = liveInfo.last_msg_id.longValue();
        this.session_id = liveInfo.session_id;
        this.description = liveInfo.description;
        this.cover = liveInfo.cover;
        this.join_count = liveInfo.join_count.intValue();
        this.audience_count = liveInfo.audience_count.intValue();
        this.zan_count = liveInfo.zan_count.intValue();
        this.live_duration = liveInfo.live_duration.longValue();
        this.charm_count = liveInfo.charm_count.intValue();
        this.flower_count = liveInfo.flower_count.intValue();
        this.start_time = liveInfo.start_time.intValue();
        this.end_time = liveInfo.end_time.intValue();
        this.location = liveInfo.location;
        this.channel_id = liveInfo.channel_id.longValue();
        this.channel_name = liveInfo.channel_name;
        this.live_status = liveInfo.live_status.intValue();
        this.close_type = liveInfo.close_type.intValue();
        this.close_reason = liveInfo.close_reason;
        this.backstage_type = liveInfo.backstage_type.intValue();
        this.share_url = liveInfo.share_url;
        this.forum_name = liveInfo.forum_name;
        this.forum_id = liveInfo.forum_id.longValue();
        this.screen_direction = liveInfo.screen_direction.intValue();
        int intValue = liveInfo.live_type.intValue();
        this.live_type = intValue;
        if (intValue != 2) {
            this.live_type = 1;
        }
        this.session_default = liveInfo.session_default.intValue();
        this.appId = liveInfo.third_app_id;
        this.openType = liveInfo.open_type.intValue();
        this.isAudioOnPrivate = liveInfo.on_audio_private.intValue();
        this.isOnPrivate = liveInfo.on_private.intValue();
        this.pkId = liveInfo.pk_id.longValue();
        this.challengeId = liveInfo.challenge_id.intValue();
        this.broadGiftMsgId = liveInfo.gift_broad_msg_id.longValue();
        this.isPullMode = liveInfo.im_pull_mode.intValue() == 1;
        this.noticeBroadcastMsgId = liveInfo.notice_broad_msg_id.intValue();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.live_id = jSONObject.optLong("live_id");
        this.user_id = jSONObject.optLong("user_id");
        this.user_name = jSONObject.optString("user_name");
        this.user_nickname = jSONObject.optString("user_nickname");
        this.group_id = jSONObject.optLong("group_id");
        this.last_msg_id = jSONObject.optLong("last_msg_id");
        this.session_id = jSONObject.optString(ETAG.KEY_STATISTICS_SEESIONID);
        this.description = jSONObject.optString("description");
        this.cover = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
        this.join_count = jSONObject.optInt("join_count");
        this.play_count = jSONObject.optInt("play_count");
        this.audience_count = jSONObject.optInt("audience_count");
        this.zan_count = jSONObject.optInt("zan_count");
        this.live_duration = jSONObject.optLong("live_duration");
        this.charm_count = jSONObject.optInt("charm_count");
        this.flower_count = jSONObject.optInt("flower_count");
        this.start_time = jSONObject.optInt("start_time");
        this.end_time = jSONObject.optInt(ResultTB.ENDTIME);
        this.location = jSONObject.optString("location");
        this.channel_id = jSONObject.optLong("channel_id");
        this.channel_name = jSONObject.optString("channel_name");
        this.live_status = jSONObject.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
        this.close_type = jSONObject.optInt("close_type");
        this.close_reason = jSONObject.optString("close_reason");
        this.backstage_type = jSONObject.optInt("backstage_type");
        this.share_url = jSONObject.optString(PbChosenActivityConfig.KEY_SHARE_URL);
        this.forum_id = jSONObject.optLong("forum_id");
        this.forum_name = jSONObject.optString("forum_name");
        this.media_pic = jSONObject.optString("media_pic");
        this.thread_id = jSONObject.optLong("thread_id");
        this.comment_count = jSONObject.optInt("comment_count");
        this.screen_direction = jSONObject.optInt("screen_direction");
        int optInt = jSONObject.optInt("live_type", 1);
        this.live_type = optInt;
        if (optInt != 2) {
            this.live_type = 1;
        }
        this.session_default = jSONObject.optInt("session_default");
        this.clarity = jSONObject.optInt("clarity");
        this.game_id = jSONObject.optString("game_id");
        this.game_label = jSONObject.optString("game_label");
        this.game_icon = jSONObject.optString("game_icon");
        this.call_path_android = jSONObject.optString("call_path_android");
        this.appId = jSONObject.optString("third_app_id");
        this.openType = jSONObject.optInt("open_type");
        this.isAudioOnPrivate = jSONObject.optInt("on_audio_private");
        this.isOnPrivate = jSONObject.optInt("on_private");
        this.pkId = jSONObject.optLong("pk_id", 0L);
        this.challengeId = jSONObject.optLong("challenge_id", 0L);
        this.broadGiftMsgId = jSONObject.optLong("gift_broad_msg_id", 0L);
        this.isPullMode = jSONObject.optInt("im_pull_mode") == 1;
        this.noticeBroadcastMsgId = jSONObject.optLong("notice_broad_msg_id", 0L);
    }
}
