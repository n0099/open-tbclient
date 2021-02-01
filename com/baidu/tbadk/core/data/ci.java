package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class ci {
    public String channelName;
    public long eUx;
    public String eUy;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.eUx = videoChannelInfo.channel_id.longValue();
            this.channelName = videoChannelInfo.channel_name;
            this.eUy = videoChannelInfo.channel_avatar;
        }
    }

    public void dp(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eUx = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.channelName = jSONObject.optString("channel_name");
                this.eUy = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
