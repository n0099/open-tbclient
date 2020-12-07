package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class cf {
    public long eMW;
    public String eMX;
    public String eMY;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.eMW = videoChannelInfo.channel_id.longValue();
            this.eMX = videoChannelInfo.channel_name;
            this.eMY = videoChannelInfo.channel_avatar;
        }
    }

    public void dh(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eMW = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.eMX = jSONObject.optString("channel_name");
                this.eMY = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
