package com.baidu.tbadk.ala;

import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.j;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class AlaLiveInfoCoreData extends j implements Serializable {
    private static final long serialVersionUID = 5768965545624138312L;
    public long audienceCount;
    public long groupID;
    public String hslUrl;
    public String liveCover;
    public long liveID;
    public int liveStatus;
    public String liveTitle;
    public int liveType;
    public String mediaPic;
    public String rtmpUrl;
    public int screenDirection;
    public String sessionID;
    public long threadId;
    public long userID;
    public AlaLiveUserInfoData userInfo;
    public String userName;

    @Override // com.baidu.tbadk.core.data.j
    public void parserJson(JSONObject jSONObject) {
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            this.liveID = alaLiveInfo.live_id.longValue();
            if (alaLiveInfo.user_info != null) {
                this.userID = alaLiveInfo.user_info.ala_id.longValue();
                this.userName = alaLiveInfo.user_info.user_name;
                if (this.userInfo == null) {
                    this.userInfo = new AlaLiveUserInfoData();
                }
                this.userInfo.parserProtoBuf(alaLiveInfo.user_info);
            }
            this.groupID = alaLiveInfo.group_id.longValue();
            this.sessionID = alaLiveInfo.session_id;
            this.liveTitle = alaLiveInfo.description;
            this.liveCover = alaLiveInfo.cover;
            this.rtmpUrl = alaLiveInfo.rtmp_url;
            this.hslUrl = alaLiveInfo.hls_url;
            this.audienceCount = alaLiveInfo.audience_count.intValue();
            this.liveType = alaLiveInfo.live_type.intValue();
            this.screenDirection = alaLiveInfo.screen_direction.intValue();
            this.liveStatus = alaLiveInfo.live_status.intValue();
            this.mediaPic = alaLiveInfo.media_pic;
            this.threadId = alaLiveInfo.thread_id.longValue();
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
            this.hslUrl = alaInfoData.hls_url;
            this.audienceCount = alaInfoData.audience_count;
            this.liveType = alaInfoData.live_type;
            this.screenDirection = alaInfoData.screen_direction;
            this.liveStatus = alaInfoData.live_status;
            this.mediaPic = alaInfoData.media_pic;
            this.threadId = alaInfoData.thread_id;
        }
    }
}
