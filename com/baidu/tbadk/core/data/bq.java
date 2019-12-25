package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class bq {
    public long cQB;
    public String cQC;
    public String cQD;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.cQB = videoChannelInfo.channel_id.longValue();
            this.cQC = videoChannelInfo.channel_name;
            this.cQD = videoChannelInfo.channel_avatar;
        }
    }

    public void ci(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cQB = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.cQC = jSONObject.optString("channel_name");
                this.cQD = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
