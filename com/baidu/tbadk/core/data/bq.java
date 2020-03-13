package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class bq {
    public long cUP;
    public String cUQ;
    public String cUR;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.cUP = videoChannelInfo.channel_id.longValue();
            this.cUQ = videoChannelInfo.channel_name;
            this.cUR = videoChannelInfo.channel_avatar;
        }
    }

    public void ci(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cUP = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.cUQ = jSONObject.optString("channel_name");
                this.cUR = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
