package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.s;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveInfoData implements Serializable {
    public static boolean DEBUG = false;
    public static final int LIVE_SCREEN_DIRECTION_LANDSCAPE = 2;
    public static final int LIVE_SCREEN_DIRECTION_PORTRAIT = 1;
    public static final int LIVE_STATUS_END = 2;
    public static final int LIVE_STATUS_LIVING = 1;
    public static final int LIVE_STATUS_PLAYBACK = 3;
    public static final int LIVE_STATUS_PLAYBACK_DELETE = 4;
    public static final int LIVE_TYPE_CAMERA = 1;
    public static final int LIVE_TYPE_SCREEN_RECORD = 2;
    private static final long serialVersionUID = 5768965545624138312L;
    public int ai_robot_num;
    public String anchorTitle;
    public String appId;
    public int apply_count;
    public int audience_count;
    public int backstage_type;
    public String call_path_android;
    public long challengeId;
    public long channel_id;
    public String channel_name;
    public int charm_count;
    public long chatId;
    public int chat_count;
    public int clarity;
    public String close_reason;
    public int close_type;
    public int comment_count;
    public String cover;
    public String description;
    public long end_time;
    public boolean existChat;
    public JSONObject extraLiveInfo;
    public int familyFansCount;
    public String feed_id;
    public int flower_count;
    public long forum_id;
    public String forum_name;
    public String game_icon;
    public String game_id;
    public String game_label;
    public long group_id;
    public String guardPortrait;
    public boolean hasRead;
    public String[] imEffect;
    public String introducegoods;
    public int isAudioOnPrivate;
    public int isOnPrivate;
    public int join_count;
    public long last_msg_id;
    public long live_duration;
    public long live_id;
    public int live_status;
    public int live_type;
    public String location;
    public List<AlaLiveStickerInfo> mAlaLiveStickerList;
    public AlaLiveSwitchData mAlaLiveSwitchData;
    public String mRecommendTabSwitch;
    public String media_id;
    public String media_pic;
    public String media_subtitle;
    public String media_url;
    public int newFansCount;
    public int openType;
    public long pkId;
    public String playUrl;
    public int play_count;
    public String qrcodeDownloadUrl;
    public String qrcodeUrl;
    public RedPacketCharmInfo redpacketCharmInfo;
    public int rewardUserCount;
    public String roomName;
    public long room_id;
    public String room_name;
    public int screen_direction;
    public String session_id;
    public AlaLiveStreamSessionInfo session_info;
    public AlaLiveStreamSessionInfo session_info_backup;
    public String share_url;
    public long start_time;
    public long thread_id;
    public String user_avatar;
    public long user_id;
    public String user_name;
    public String user_nickname;
    public String user_uk;
    public int zan_count;
    public s.a mCastIds = null;
    public int goodsList = 0;
    public int session_default = 0;
    public long broadGiftMsgId = 0;
    public AlaLiveCloseData mLiveCloseData = new AlaLiveCloseData();
    public boolean hasLogShow = false;

    public long getLiveID() {
        return this.live_id;
    }

    public long getUserID() {
        return this.user_id;
    }

    public String getUserName() {
        return this.user_name;
    }

    public long getGroupID() {
        return this.group_id;
    }

    public long getLastMsgID() {
        return this.last_msg_id;
    }

    public String getLiveTitle() {
        return this.description;
    }

    public String getLiveCover() {
        return this.cover;
    }

    public int getJoinCount() {
        return this.join_count;
    }

    public long getLiveDuration() {
        return this.live_duration;
    }

    public int getCharmCount() {
        return this.charm_count;
    }

    public String getLocation() {
        return this.location;
    }

    public String getMedia_pic() {
        return this.media_pic;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.live_id = jSONObject.optLong("live_id");
            this.room_id = jSONObject.optLong("room_id");
            this.user_id = jSONObject.optLong("user_id");
            this.user_name = jSONObject.optString("user_name");
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.user_avatar = jSONObject.optString("user_avatar");
            this.user_nickname = jSONObject.optString("user_nickname");
            this.group_id = jSONObject.optLong("group_id");
            this.last_msg_id = jSONObject.optLong("last_msg_id");
            this.session_id = jSONObject.optString("session_id");
            this.description = jSONObject.optString("description");
            this.cover = jSONObject.optString("cover");
            this.join_count = jSONObject.optInt("join_count");
            this.play_count = jSONObject.optInt("play_count");
            this.audience_count = jSONObject.optInt("audience_count");
            this.ai_robot_num = jSONObject.optInt("ai_robot_num");
            this.zan_count = jSONObject.optInt("zan_count");
            this.live_duration = jSONObject.optLong("live_duration");
            this.charm_count = jSONObject.optInt("charm_count");
            this.flower_count = jSONObject.optInt("flower_count");
            this.familyFansCount = jSONObject.optInt("family_fans_count");
            this.newFansCount = jSONObject.optInt("new_fans_count");
            this.rewardUserCount = jSONObject.optInt("reward_user_count");
            this.qrcodeDownloadUrl = jSONObject.optString("qrcode_download_url");
            this.qrcodeUrl = jSONObject.optString("qrcode_url");
            this.anchorTitle = jSONObject.optString("anchor_title");
            this.start_time = jSONObject.optInt("start_time");
            this.end_time = jSONObject.optInt("end_time");
            this.location = jSONObject.optString("location");
            this.channel_id = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID);
            this.channel_name = jSONObject.optString("channel_name");
            this.live_status = jSONObject.optInt("live_status");
            this.close_type = jSONObject.optInt("close_type");
            this.close_reason = jSONObject.optString("close_reason");
            this.backstage_type = jSONObject.optInt("backstage_type");
            this.user_uk = jSONObject.optString("user_uk");
            this.apply_count = jSONObject.optInt("apply_count", 0);
            this.share_url = jSONObject.optString(PbChosenActivityConfig.KEY_SHARE_URL);
            this.forum_id = jSONObject.optLong("forum_id");
            this.forum_name = jSONObject.optString("forum_name");
            this.feed_id = jSONObject.optString("feed_id");
            this.media_id = jSONObject.optString("media_id");
            this.media_url = jSONObject.optString("media_url");
            this.media_pic = jSONObject.optString("media_pic");
            this.media_subtitle = jSONObject.optString("media_subtitle");
            JSONObject optJSONObject = jSONObject.optJSONObject("session_info");
            if (optJSONObject != null) {
                this.session_info = new AlaLiveStreamSessionInfo();
                this.session_info.parseJson(optJSONObject);
            } else {
                this.session_info = new AlaLiveStreamSessionInfo();
                this.session_info.rtmpUrl = jSONObject.optString("rtmp_url");
                this.session_info.flvUrl = jSONObject.optString("flv_url");
                this.session_info.hlsUrl = jSONObject.optString("hls_url");
                this.session_info.mSessionId = jSONObject.optString("session_id");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("session_info_backup");
            if (optJSONObject2 != null) {
                this.session_info_backup = new AlaLiveStreamSessionInfo();
                this.session_info_backup.parseJson(optJSONObject2);
            }
            this.thread_id = jSONObject.optLong("thread_id");
            this.comment_count = jSONObject.optInt("comment_count");
            this.screen_direction = jSONObject.optInt("screen_direction");
            if (DEBUG) {
                HashMap hashMap = new HashMap();
                hashMap.put("debug_force_landscape", false);
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                if (process.containsKey("debug_force_landscape") ? ((Boolean) process.get("debug_force_landscape")).booleanValue() : false) {
                    this.screen_direction = 2;
                }
            }
            this.live_type = jSONObject.optInt(UbcStatConstant.KEY_LIVE_TYPE, 1);
            if (this.live_type != 2) {
                this.live_type = 1;
            }
            this.session_default = jSONObject.optInt("session_default");
            this.clarity = jSONObject.optInt("clarity");
            this.goodsList = jSONObject.optInt("goods_list");
            this.introducegoods = jSONObject.optString("introduce_goods");
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
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user_privilege");
            if (optJSONObject3 != null) {
                String optString = optJSONObject3.optString("bubble_effect");
                String optString2 = optJSONObject3.optString("nickname_effect");
                this.imEffect = new String[2];
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                    this.imEffect[0] = optString;
                    this.imEffect[1] = optString2;
                } else if (!TextUtils.isEmpty(optString2)) {
                    this.imEffect[0] = "";
                    this.imEffect[1] = optString2;
                } else if (!TextUtils.isEmpty(optString)) {
                    this.imEffect[0] = optString;
                    this.imEffect[1] = "";
                } else {
                    this.imEffect = null;
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject(Constants.EXTRA_CAST_IDS);
            if (optJSONObject4 != null) {
                this.mCastIds = new s.a();
                this.mCastIds.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("switch");
            if (optJSONObject5 != null) {
                this.mAlaLiveSwitchData = new AlaLiveSwitchData();
                this.mAlaLiveSwitchData.parserJson(optJSONObject5);
                TbadkCoreApplication.sAlaLiveSwitchData = this.mAlaLiveSwitchData;
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("close_data");
            if (optJSONObject6 != null) {
                this.mLiveCloseData = new AlaLiveCloseData();
                this.mLiveCloseData.parserJson(optJSONObject6);
            } else {
                this.mLiveCloseData = null;
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("live_redpacket");
            if (optJSONObject7 != null) {
                this.redpacketCharmInfo = new RedPacketCharmInfo(optJSONObject7);
            }
            this.guardPortrait = jSONObject.optString("guard_portrait");
            this.chatId = jSONObject.optLong("chat_id", 0L);
            this.existChat = jSONObject.optInt("exist_chat", 0) == 1;
            JSONObject optJSONObject8 = jSONObject.optJSONObject("third_special");
            if (optJSONObject8 != null && !TextUtils.isEmpty(TbConfig.getSubappType())) {
                this.extraLiveInfo = optJSONObject8.optJSONObject(TbConfig.getSubappType() + "_special");
            }
            this.chat_count = jSONObject.optInt("chat_count", 0);
            this.mRecommendTabSwitch = jSONObject.optString("recommend_tab_switch", "0");
            JSONArray optJSONArray = jSONObject.optJSONArray("sticker_info");
            if (optJSONArray != null) {
                this.mAlaLiveStickerList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.mAlaLiveStickerList.add(AlaLiveStickerInfo.parse(optJSONArray.getJSONObject(i)));
                    } catch (JSONException e) {
                        return;
                    }
                }
                return;
            }
            this.mAlaLiveStickerList = null;
        }
    }

    public String getNameShow() {
        return TextUtils.isEmpty(this.user_nickname) ? this.user_name : this.user_nickname;
    }

    public boolean isGoodsListVisible() {
        return this.goodsList == 1;
    }

    public int getZanCount() {
        return this.zan_count;
    }

    public int getFlowerCount() {
        return this.flower_count;
    }

    public String getCloseReason() {
        return this.close_reason;
    }

    public String getSessionID() {
        return this.session_id;
    }

    public String getPushUrl() {
        if (this.session_info != null) {
            return this.session_info.getPushUrl();
        }
        return null;
    }

    public boolean isRecommendTabSwitchUnabled() {
        return TextUtils.equals(this.mRecommendTabSwitch, "0");
    }

    public String getJsonString() {
        JSONObject json = toJson();
        if (json != null) {
            return json.toString();
        }
        return null;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("live_id", this.live_id);
            jSONObject.put("room_id", this.room_id);
            jSONObject.put("user_id", this.user_id);
            jSONObject.put("user_name", this.user_name);
            jSONObject.put("user_nickname", this.user_nickname);
            jSONObject.put("group_id", this.group_id);
            jSONObject.put("introduce_goods", this.introducegoods);
            jSONObject.put("goods_list", this.goodsList);
            jSONObject.put("last_msg_id", this.last_msg_id);
            jSONObject.put("session_id", this.session_id);
            jSONObject.put("description", this.description);
            jSONObject.put("cover", this.cover);
            jSONObject.put("join_count", this.join_count);
            jSONObject.put("play_count", this.play_count);
            jSONObject.put("audience_count", this.audience_count);
            jSONObject.put("zan_count", this.zan_count);
            jSONObject.put("family_fans_count", this.familyFansCount);
            jSONObject.put("new_fans_count", this.newFansCount);
            jSONObject.put("reward_user_count", this.rewardUserCount);
            jSONObject.put("qrcode_download_url", this.qrcodeDownloadUrl);
            jSONObject.put("qrcode_url", this.qrcodeUrl);
            jSONObject.put("anchor_title", this.anchorTitle);
            jSONObject.put("live_duration", this.live_duration);
            jSONObject.put("charm_count", this.charm_count);
            jSONObject.put("flower_count", this.flower_count);
            jSONObject.put("start_time", this.start_time);
            jSONObject.put("end_time", this.end_time);
            jSONObject.put("location", this.location);
            jSONObject.put(SharedPrefConfig.CHANNEL_ID, this.channel_id);
            jSONObject.put("channel_name", this.channel_name);
            jSONObject.put("live_status", this.live_status);
            jSONObject.put("close_type", this.close_type);
            jSONObject.put("close_reason", this.close_reason);
            jSONObject.put("backstage_type", this.backstage_type);
            jSONObject.put("user_uk", this.user_uk);
            jSONObject.put(PbChosenActivityConfig.KEY_SHARE_URL, this.share_url);
            jSONObject.put("forum_id", this.forum_id);
            jSONObject.put("forum_name", this.forum_name);
            jSONObject.put("feed_id", this.feed_id);
            jSONObject.put("media_id", this.media_id);
            jSONObject.put("media_url", this.media_url);
            jSONObject.put("media_pic", this.media_pic);
            jSONObject.put("media_subtitle", this.media_subtitle);
            jSONObject.put("session_info", AlaLiveStreamSessionInfo.toJson(this.session_info));
            jSONObject.put("session_info_backup", AlaLiveStreamSessionInfo.toJson(this.session_info_backup));
            jSONObject.put("thread_id", this.thread_id);
            jSONObject.put("comment_count", this.comment_count);
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, this.live_type);
            jSONObject.put("session_default", this.session_default);
            jSONObject.put("clarity", this.clarity);
            jSONObject.put("game_id", this.game_id);
            jSONObject.put("game_label", this.game_label);
            jSONObject.put("game_icon", this.game_icon);
            jSONObject.put("call_path_android", this.call_path_android);
            jSONObject.put("third_app_id", this.appId);
            jSONObject.put("open_type", this.openType);
            jSONObject.put("on_audio_private", this.isAudioOnPrivate);
            jSONObject.put("on_private", this.isOnPrivate);
            jSONObject.put("pk_id", this.pkId);
            jSONObject.put("challenge_id", this.challengeId);
            jSONObject.put("gift_broad_msg_id", this.broadGiftMsgId);
            if (this.mCastIds != null) {
                jSONObject.put(Constants.EXTRA_CAST_IDS, this.mCastIds.toJsonObject());
            }
            if (this.mAlaLiveSwitchData != null) {
                jSONObject.put("switch", this.mAlaLiveSwitchData.toJson());
            }
            if (this.mLiveCloseData != null) {
                jSONObject.put("close_data", AlaLiveCloseData.toJson(this.mLiveCloseData));
            }
            jSONObject.put("guard_portrait", this.guardPortrait);
            jSONObject.put("chat_id", this.chatId);
            jSONObject.put("exist_chat", this.existChat ? 1 : 0);
            if (this.extraLiveInfo != null && !TextUtils.isEmpty(TbConfig.getSubappType())) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TbConfig.getSubappType() + "_special", this.extraLiveInfo.toString());
                jSONObject.put("third_special", jSONObject2.toString());
            }
            jSONObject.put("chat_count", this.chat_count);
            jSONObject.put("recommend_tab_switch", this.mRecommendTabSwitch);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public JSONObject toJsonObject() {
        return toJson();
    }
}
