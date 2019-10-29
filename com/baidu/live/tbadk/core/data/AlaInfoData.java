package com.baidu.live.tbadk.core.data;

import android.util.SparseArray;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.log.LogConfig;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
    public String flv_url;
    public long group_id;
    public String hls_url;
    public AlaSquareCoverLabelData label;
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
                this.session_id = jSONObject.optString(LogConfig.LOG_SESSION_ID);
                this.rtmp_url = jSONObject.optString("rtmp_url");
                this.hls_url = jSONObject.optString("hls_url");
                this.group_id = jSONObject.optLong("group_id");
                this.media_url = jSONObject.optString("media_url");
                this.media_pic = jSONObject.optString("media_pic");
                this.media_id = jSONObject.optString("media_id");
                this.media_subtitle = jSONObject.optString("media_subtitle");
                this.description = jSONObject.optString("description");
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
                    this.label = new AlaSquareCoverLabelData();
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
}
