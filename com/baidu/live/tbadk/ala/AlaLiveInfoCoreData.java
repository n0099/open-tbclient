package com.baidu.live.tbadk.ala;

import com.baidu.live.tbadk.core.data.AlaInfoData;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveInfoCoreData extends BaseData implements Serializable {
    private static final long serialVersionUID = 5768965545624138312L;
    public String action;
    public long audienceCount;
    public String feed_id;
    public String flvUrl;
    public long groupID;
    public String hlsUrl;
    public String liveCover;
    public long liveID;
    public int liveStatus;
    public String liveTitle;
    public int liveType;
    public String mediaPic;
    public String otherParams;
    public String rtmpUrl;
    public int screenDirection;
    public String sessionID;
    public long threadId;
    public long userID;
    public AlaLiveUserInfoData userInfo;
    public String userName;
    public int localBroadcastType = 0;
    public int isAudio = 0;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.liveID = jSONObject.optLong("live_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.userID = optJSONObject.optLong("ala_id");
                this.userName = optJSONObject.optString("user_name");
                if (this.userInfo == null) {
                    this.userInfo = new AlaLiveUserInfoData();
                }
                this.userInfo.parserJson(optJSONObject);
            }
            this.groupID = jSONObject.optLong("group_id");
            this.sessionID = jSONObject.optString("session_id");
            this.liveTitle = jSONObject.optString("description");
            this.liveCover = jSONObject.optString("cover");
            this.rtmpUrl = jSONObject.optString("rtmp_url");
            this.hlsUrl = jSONObject.optString("hls_url");
            this.flvUrl = jSONObject.optString("flv_url");
            this.audienceCount = jSONObject.optLong("audience_count");
            this.liveType = jSONObject.optInt(UbcStatConstant.KEY_LIVE_TYPE);
            this.screenDirection = jSONObject.optInt("screen_direction");
            this.liveStatus = jSONObject.optInt("live_status");
            this.mediaPic = jSONObject.optString("media_pic");
            this.threadId = jSONObject.optLong("thread_id");
        }
    }

    public void fillWithInfoData(AlaInfoData alaInfoData) {
        if (alaInfoData != null) {
            this.liveID = alaInfoData.live_id;
            if (alaInfoData.user_info != null) {
                this.userName = alaInfoData.user_info.user_name;
            }
            if (alaInfoData.user_info != null) {
                if (this.userInfo == null) {
                    this.userInfo = new AlaLiveUserInfoData();
                }
                this.userInfo.convertFromAlaUserInfoData(alaInfoData.user_info);
            }
            this.groupID = alaInfoData.group_id;
            this.sessionID = alaInfoData.session_id;
            this.liveTitle = alaInfoData.description;
            this.liveCover = alaInfoData.cover;
            this.rtmpUrl = alaInfoData.rtmp_url;
            this.hlsUrl = alaInfoData.hls_url;
            this.flvUrl = alaInfoData.flv_url;
            this.audienceCount = alaInfoData.audience_count;
            this.liveType = alaInfoData.live_type;
            this.screenDirection = alaInfoData.screen_direction;
            this.liveStatus = alaInfoData.live_status;
            this.mediaPic = alaInfoData.media_pic;
            this.threadId = alaInfoData.thread_id;
        }
    }
}
