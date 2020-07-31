package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class cc {
    public long dVo;
    public String dVp;
    public String dVq;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.dVo = videoChannelInfo.channel_id.longValue();
            this.dVp = videoChannelInfo.channel_name;
            this.dVq = videoChannelInfo.channel_avatar;
        }
    }

    public void cM(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dVo = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.dVp = jSONObject.optString("channel_name");
                this.dVq = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
