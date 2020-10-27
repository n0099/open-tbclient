package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class cd {
    public long eBM;
    public String eBN;
    public String eBO;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.eBM = videoChannelInfo.channel_id.longValue();
            this.eBN = videoChannelInfo.channel_name;
            this.eBO = videoChannelInfo.channel_avatar;
        }
    }

    public void df(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eBM = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.eBN = jSONObject.optString("channel_name");
                this.eBO = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
