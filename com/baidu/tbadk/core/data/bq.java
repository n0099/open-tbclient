package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class bq {
    public long cUN;
    public String cUO;
    public String cUP;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.cUN = videoChannelInfo.channel_id.longValue();
            this.cUO = videoChannelInfo.channel_name;
            this.cUP = videoChannelInfo.channel_avatar;
        }
    }

    public void ci(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cUN = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.cUO = jSONObject.optString("channel_name");
                this.cUP = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
