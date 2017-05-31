package com.baidu.tbadk.ala;

import com.baidu.tbadk.core.data.i;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class AlaLiveInfoCoreData extends i implements Serializable {
    private static final long serialVersionUID = 5768965545624138312L;
    private long audienceCount;
    private long groupID;
    private String hslUrl;
    private String liveCover;
    private long liveID;
    private String liveTitle;
    private String rtmpUrl;
    private String sessionID;
    private long userID;
    private String userName;

    public void setLiveID(long j) {
        this.liveID = j;
    }

    public void setUserID(long j) {
        this.userID = j;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setGroupID(long j) {
        this.groupID = j;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void setLiveTitle(String str) {
        this.liveTitle = str;
    }

    public void setLiveCover(String str) {
        this.liveCover = str;
    }

    public void setRtmpUrl(String str) {
        this.rtmpUrl = str;
    }

    public void setHslUrl(String str) {
        this.hslUrl = str;
    }

    public long getLiveID() {
        return this.liveID;
    }

    public long getUserID() {
        return this.userID;
    }

    public String getUserName() {
        return this.userName;
    }

    public long getGroupID() {
        return this.groupID;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public String getLiveTitle() {
        return this.liveTitle;
    }

    public String getLiveCover() {
        return this.liveCover;
    }

    public String getRtmpUrl() {
        return this.rtmpUrl;
    }

    public String getHslUrl() {
        return this.hslUrl;
    }

    public long getAudienceCount() {
        return this.audienceCount;
    }

    @Override // com.baidu.tbadk.core.data.i
    public void parserJson(JSONObject jSONObject) {
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            this.liveID = alaLiveInfo.live_id.longValue();
            if (alaLiveInfo.user_info != null) {
                this.userID = alaLiveInfo.user_info.ala_id.longValue();
                this.userName = alaLiveInfo.user_info.user_name;
            }
            this.groupID = alaLiveInfo.group_id.longValue();
            this.sessionID = alaLiveInfo.session_id;
            this.liveTitle = alaLiveInfo.description;
            this.liveCover = alaLiveInfo.cover;
            this.rtmpUrl = alaLiveInfo.rtmp_url;
            this.hslUrl = alaLiveInfo.hls_url;
            this.audienceCount = alaLiveInfo.audience_count.intValue();
        }
    }
}
