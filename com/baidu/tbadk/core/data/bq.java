package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class bq {
    public long dun;
    public String duo;
    public String dup;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.dun = videoChannelInfo.channel_id.longValue();
            this.duo = videoChannelInfo.channel_name;
            this.dup = videoChannelInfo.channel_avatar;
        }
    }

    public void ct(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dun = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.duo = jSONObject.optString("channel_name");
                this.dup = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
