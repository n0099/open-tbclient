package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class br {
    public long dIm;
    public String dIn;
    public String dIo;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.dIm = videoChannelInfo.channel_id.longValue();
            this.dIn = videoChannelInfo.channel_name;
            this.dIo = videoChannelInfo.channel_avatar;
        }
    }

    public void cz(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dIm = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.dIn = jSONObject.optString("channel_name");
                this.dIo = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
