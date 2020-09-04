package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class cd {
    public long eeS;
    public String eeT;
    public String eeU;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.eeS = videoChannelInfo.channel_id.longValue();
            this.eeT = videoChannelInfo.channel_name;
            this.eeU = videoChannelInfo.channel_avatar;
        }
    }

    public void cS(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eeS = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.eeT = jSONObject.optString("channel_name");
                this.eeU = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
