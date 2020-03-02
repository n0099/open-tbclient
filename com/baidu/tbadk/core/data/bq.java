package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class bq {
    public long cUO;
    public String cUP;
    public String cUQ;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.cUO = videoChannelInfo.channel_id.longValue();
            this.cUP = videoChannelInfo.channel_name;
            this.cUQ = videoChannelInfo.channel_avatar;
        }
    }

    public void ci(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cUO = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.cUP = jSONObject.optString("channel_name");
                this.cUQ = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
