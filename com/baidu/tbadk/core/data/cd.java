package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes2.dex */
public class cd {
    public long eeO;
    public String eeP;
    public String eeQ;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.eeO = videoChannelInfo.channel_id.longValue();
            this.eeP = videoChannelInfo.channel_name;
            this.eeQ = videoChannelInfo.channel_avatar;
        }
    }

    public void cS(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eeO = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.eeP = jSONObject.optString("channel_name");
                this.eeQ = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
