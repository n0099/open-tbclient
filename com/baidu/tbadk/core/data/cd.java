package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class cd {
    public long ehg;
    public String ehh;
    public String ehi;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.ehg = videoChannelInfo.channel_id.longValue();
            this.ehh = videoChannelInfo.channel_name;
            this.ehi = videoChannelInfo.channel_avatar;
        }
    }

    public void cV(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ehg = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.ehh = jSONObject.optString("channel_name");
                this.ehi = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
