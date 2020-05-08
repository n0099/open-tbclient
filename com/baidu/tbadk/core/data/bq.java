package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes.dex */
public class bq {
    public long dur;
    public String dus;
    public String dut;

    public void a(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo != null && videoChannelInfo.channel_id.longValue() > 0) {
            this.dur = videoChannelInfo.channel_id.longValue();
            this.dus = videoChannelInfo.channel_name;
            this.dut = videoChannelInfo.channel_avatar;
        }
    }

    public void ct(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dur = jSONObject.optLong(SharedPrefConfig.CHANNEL_ID, 0L);
                this.dus = jSONObject.optString("channel_name");
                this.dut = jSONObject.optString("channel_avatar");
            } catch (Exception e) {
            }
        }
    }
}
