package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class cb {
    public long dPc;
    public String dPd;
    public String dPe;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.dPc = videoChannelInfo.channel_id.longValue();
            this.dPd = videoChannelInfo.channel_name;
            this.dPe = videoChannelInfo.channel_avatar;
        }
    }

    public void cG(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dPc = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.dPd = jSONObject.optString("channel_name");
                this.dPe = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
