package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class bn {
    public int ZN;
    public int ceT;
    public String channelAvatar;
    public long channelId;
    public String channelName;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.channelId = videoChannelInfo.channel_id.longValue();
            this.channelName = videoChannelInfo.channel_name;
            this.channelAvatar = videoChannelInfo.channel_avatar;
        }
    }

    public void bt(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.channelId = jSONObject.optLong("channel_id", 0L);
                this.channelName = jSONObject.optString("channel_name");
                this.channelAvatar = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
