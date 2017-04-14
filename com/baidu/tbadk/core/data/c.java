package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class c {
    public AlaUserInfoData Uz;
    public int audience_count;
    public String cover;
    public String description;
    public int duration;
    public long group_id;
    public String hls_url;
    public long live_id;
    public String media_id;
    public String media_pic;
    public String media_subtitle;
    public String media_url;
    public String rtmp_url;
    public String session_id;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.live_id = jSONObject.optLong("live_id");
                this.cover = jSONObject.optString("cover");
                this.session_id = jSONObject.optString("session_id");
                this.rtmp_url = jSONObject.optString("rtmp_url");
                this.hls_url = jSONObject.optString("hls_url");
                this.group_id = jSONObject.optLong("group_id");
                this.media_url = jSONObject.optString("media_url");
                this.media_pic = jSONObject.optString("media_pic");
                this.media_id = jSONObject.optString("media_id");
                this.media_subtitle = jSONObject.optString("media_subtitle");
                this.description = jSONObject.optString("description");
                this.Uz = (AlaUserInfoData) OrmObject.objectWithJsonStr(jSONObject.optString("user_info"), AlaUserInfoData.class);
                this.duration = jSONObject.optInt("duration");
                this.audience_count = jSONObject.optInt("audience_count");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            try {
                this.live_id = alaLiveInfo.live_id.longValue();
                this.cover = alaLiveInfo.cover;
                this.session_id = alaLiveInfo.session_id;
                this.rtmp_url = alaLiveInfo.rtmp_url;
                this.hls_url = alaLiveInfo.hls_url;
                this.group_id = alaLiveInfo.group_id.longValue();
                this.media_url = alaLiveInfo.media_url;
                this.media_pic = alaLiveInfo.media_pic;
                this.media_id = alaLiveInfo.media_id;
                this.media_subtitle = alaLiveInfo.media_subtitle;
                this.description = alaLiveInfo.description;
                this.Uz = new AlaUserInfoData();
                this.Uz.a(alaLiveInfo.user_info);
                this.duration = alaLiveInfo.duration.intValue();
                this.audience_count = alaLiveInfo.audience_count.intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
