package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class ci {
    public String channelName;
    public long eVW;
    public String eVX;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.eVW = videoChannelInfo.channel_id.longValue();
            this.channelName = videoChannelInfo.channel_name;
            this.eVX = videoChannelInfo.channel_avatar;
        }
    }

    public void dr(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eVW = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.channelName = jSONObject.optString("channel_name");
                this.eVX = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
