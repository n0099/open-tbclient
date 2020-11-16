package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class ce {
    public long eFT;
    public String eFU;
    public String eFV;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.eFT = videoChannelInfo.channel_id.longValue();
            this.eFU = videoChannelInfo.channel_name;
            this.eFV = videoChannelInfo.channel_avatar;
        }
    }

    public void df(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eFT = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.eFU = jSONObject.optString("channel_name");
                this.eFV = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
