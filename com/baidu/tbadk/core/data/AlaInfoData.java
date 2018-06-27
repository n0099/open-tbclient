package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import com.baidu.adp.lib.util.BdLog;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
import tbclient.AlaStageDislikeInfo;
/* loaded from: classes.dex */
public class AlaInfoData implements Serializable {
    public static final int LIVE_STATUS_LIVE_ON = 1;
    public static final int LIVE_STATUS_RECORD = 3;
    public String appId;
    public int audience_count;
    public String cover;
    public String description;
    public SparseArray<String> dislikeInfo;
    public double distance;
    public int duration;
    public long group_id;
    public String hls_url;
    public c label;
    public String label_name;
    public long live_id;
    public int live_status;
    public int live_type;
    public AlaChallengeInfoData mChallengeInfoData;
    public String media_id;
    public String media_pic;
    public String media_subtitle;
    public String media_url;
    public String rtmp_url;
    public int screen_direction;
    public String session_id;
    public AlaShareInfoData share_info;
    public long thread_id;
    public AlaUserInfoData user_info;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.live_id = jSONObject.optLong("live_id");
                this.cover = jSONObject.optString("cover");
                this.session_id = jSONObject.optString("session_id");
                this.rtmp_url = jSONObject.optString("rtmp_url");
                this.hls_url = jSONObject.optString("hls_url");
                this.group_id = jSONObject.optLong("group_id");
                this.media_url = jSONObject.optString("media_url");
                this.media_pic = jSONObject.optString("media_pic");
                this.media_id = jSONObject.optString("media_id");
                this.media_subtitle = jSONObject.optString("media_subtitle");
                this.description = jSONObject.optString(SocialConstants.PARAM_COMMENT);
                this.user_info = new AlaUserInfoData();
                this.user_info.parserJson(jSONObject.optJSONObject("user_info"));
                this.share_info = new AlaShareInfoData();
                this.share_info.parserJson(jSONObject.optJSONObject("share_info"));
                this.live_status = jSONObject.optInt("live_status");
                this.duration = jSONObject.optInt("duration");
                this.audience_count = jSONObject.optInt("audience_count");
                this.live_type = jSONObject.optInt("live_type");
                this.screen_direction = jSONObject.optInt("screen_direction");
                this.label_name = jSONObject.optString("label_name");
                this.distance = jSONObject.optDouble("distance");
                this.appId = jSONObject.optString("third_app_id");
                this.thread_id = jSONObject.optLong("thread_id");
                JSONObject optJSONObject = jSONObject.optJSONObject("label");
                if (optJSONObject != null) {
                    this.label = new c();
                    this.label.parserJson(optJSONObject);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("stage_dislike_info");
                if (optJSONArray != null) {
                    if (this.dislikeInfo == null) {
                        this.dislikeInfo = new SparseArray<>();
                    }
                    this.dislikeInfo.clear();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        if (optJSONArray.optJSONObject(i) != null) {
                            this.dislikeInfo.put(jSONObject.optInt("dislike_id"), jSONObject.optString("dislike_reason"));
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("challenge_info");
                if (optJSONObject2 != null) {
                    this.mChallengeInfoData = new AlaChallengeInfoData();
                    this.mChallengeInfoData.parserJson(optJSONObject2);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserProtobuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            try {
                this.live_id = alaLiveInfo.live_id.longValue();
                this.cover = alaLiveInfo.cover;
                this.session_id = alaLiveInfo.session_id;
                this.rtmp_url = alaLiveInfo.rtmp_url;
                this.hls_url = alaLiveInfo.hls_url;
                this.group_id = alaLiveInfo.group_id.longValue();
                this.media_url = alaLiveInfo.media_url;
                this.media_pic = alaLiveInfo.media_pic;
                this.media_id = alaLiveInfo.media_id;
                this.media_subtitle = alaLiveInfo.media_subtitle;
                this.description = alaLiveInfo.description;
                this.user_info = new AlaUserInfoData();
                this.user_info.a(alaLiveInfo.user_info);
                this.share_info = new AlaShareInfoData();
                this.share_info.a(alaLiveInfo.share_info);
                this.live_status = alaLiveInfo.live_status.intValue();
                this.duration = alaLiveInfo.duration.intValue();
                this.audience_count = alaLiveInfo.audience_count.intValue();
                this.live_type = alaLiveInfo.live_type.intValue();
                this.screen_direction = alaLiveInfo.screen_direction.intValue();
                this.label_name = alaLiveInfo.label_name;
                this.distance = alaLiveInfo.distance.longValue();
                this.appId = alaLiveInfo.third_app_id;
                this.thread_id = alaLiveInfo.thread_id.longValue();
                if (alaLiveInfo.stage_dislike_info != null) {
                    if (this.dislikeInfo == null) {
                        this.dislikeInfo = new SparseArray<>();
                    }
                    this.dislikeInfo.clear();
                    for (int i = 0; i < alaLiveInfo.stage_dislike_info.size(); i++) {
                        AlaStageDislikeInfo alaStageDislikeInfo = alaLiveInfo.stage_dislike_info.get(i);
                        if (alaStageDislikeInfo != null) {
                            this.dislikeInfo.put(alaStageDislikeInfo.dislike_id.intValue(), alaStageDislikeInfo.dislike_reason);
                        }
                    }
                }
                this.mChallengeInfoData = new AlaChallengeInfoData();
                this.mChallengeInfoData.parserProtobuf(alaLiveInfo.challenge_info);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
