package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.AnchorInfo;
/* loaded from: classes.dex */
public class LiveCardData implements au, Serializable {
    private static final long serialVersionUID = 1;
    private int authorId;
    private String authorName;
    private String background;
    private long createTime;
    private int deviceId;
    private int flag;
    private int forumId;
    private String forumName;
    private int groupId;
    private int groupType;
    private String intro;
    private boolean isModifyTime = false;
    private int likers;
    private int listeners;
    private String name;
    private String portrait;
    private int publisherId;
    private String publisherName;
    private String publisherPortrait;
    private long startTime;
    private int status;
    private String streamId;

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public boolean isModifyTime() {
        return this.isModifyTime;
    }

    public void setModifyTime(boolean z) {
        this.isModifyTime = z;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public String getPublisherPortrait() {
        return this.publisherPortrait;
    }

    public void setPublisherPortrait(String str) {
        this.publisherPortrait = str;
    }

    public int getForumId() {
        return this.forumId;
    }

    public void setForumId(int i) {
        this.forumId = i;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(int i) {
        this.authorId = i;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public void setGroupType(int i) {
        this.groupType = i;
    }

    public String getPublisherName() {
        return this.publisherName;
    }

    public void setPublisherName(String str) {
        this.publisherName = str;
    }

    public int getPublisherId() {
        return this.publisherId;
    }

    public void setPublisherId(int i) {
        this.publisherId = i;
    }

    public String getStreamId() {
        return this.streamId;
    }

    public void setStreamId(String str) {
        this.streamId = str;
    }

    public int getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(int i) {
        this.deviceId = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getLikers() {
        return this.likers;
    }

    public void setLikers(int i) {
        this.likers = i;
    }

    public int getListeners() {
        return this.listeners;
    }

    public void setListeners(int i) {
        this.listeners = i;
    }

    public String getBackground() {
        return this.background;
    }

    public void setBackground(String str) {
        this.background = str;
    }

    public JSONObject toDraftJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("startTime", this.startTime);
            jSONObject.put("isModifyTime", this.isModifyTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void parseDraftJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.startTime = jSONObject.optLong("startTime");
            this.isModifyTime = jSONObject.optBoolean("isModifyTime");
        }
    }

    public void parserProtobuf(AnchorInfo anchorInfo) {
        if (anchorInfo != null) {
            this.publisherId = anchorInfo.author_id.intValue();
            this.publisherName = anchorInfo.author_name;
            this.groupId = anchorInfo.group_id.intValue();
            this.intro = anchorInfo.intro;
            this.likers = anchorInfo.likers.intValue();
            this.listeners = anchorInfo.listeners.intValue();
            this.name = anchorInfo.name;
            this.portrait = anchorInfo.portrait;
            this.publisherPortrait = anchorInfo.publisherPortrait;
            this.startTime = anchorInfo.start_time.intValue();
            this.status = anchorInfo.status.intValue();
            this.forumName = anchorInfo.forumName;
        }
    }

    @Override // com.baidu.tbadk.core.util.au
    public ArrayList<at> getImages() {
        ArrayList<at> arrayList = new ArrayList<>();
        at atVar = new at();
        atVar.imgUrl = this.portrait;
        atVar.Jd = 10;
        arrayList.add(atVar);
        return arrayList;
    }
}
