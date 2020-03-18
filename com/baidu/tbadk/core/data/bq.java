package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class bq {
    public long cVc;
    public String cVd;
    public String cVe;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.cVc = videoChannelInfo.channel_id.longValue();
            this.cVd = videoChannelInfo.channel_name;
            this.cVe = videoChannelInfo.channel_avatar;
        }
    }

    public void ci(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cVc = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.cVd = jSONObject.optString("channel_name");
                this.cVe = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
