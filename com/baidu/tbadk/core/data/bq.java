package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class bq {
    public long cQL;
    public String cQM;
    public String cQN;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.cQL = videoChannelInfo.channel_id.longValue();
            this.cQM = videoChannelInfo.channel_name;
            this.cQN = videoChannelInfo.channel_avatar;
        }
    }

    public void ci(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cQL = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.cQM = jSONObject.optString("channel_name");
                this.cQN = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
