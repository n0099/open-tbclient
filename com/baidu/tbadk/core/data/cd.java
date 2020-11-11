package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class cd {
    public long eHB;
    public String eHC;
    public String eHD;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.eHB = videoChannelInfo.channel_id.longValue();
            this.eHC = videoChannelInfo.channel_name;
            this.eHD = videoChannelInfo.channel_avatar;
        }
    }

    public void dl(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eHB = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.eHC = jSONObject.optString("channel_name");
                this.eHD = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
