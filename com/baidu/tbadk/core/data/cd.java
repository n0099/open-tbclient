package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class cd {
    public long etn;
    public String eto;
    public String etp;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.etn = videoChannelInfo.channel_id.longValue();
            this.eto = videoChannelInfo.channel_name;
            this.etp = videoChannelInfo.channel_avatar;
        }
    }

    public void dc(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.etn = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.eto = jSONObject.optString("channel_name");
                this.etp = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
