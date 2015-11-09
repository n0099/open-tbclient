package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ae;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.AnchorInfo;
/* loaded from: classes.dex */
public class LiveCardData implements ae, Serializable {
    public static final int LIVETYPE_PHOTOLIVE = 33;
    private static final long serialVersionUID = 1;
    private long authorId;
    private String authorName;
    private String background;
    private long createTime;
    private int deviceId;
    private int flag;
    private int forumId;
    private String forumName;
    private int fromType;
    private int groupId;
    private int groupType;
    private String intro;
    private boolean isModifyTime = false;
    private int isVip;
    private String labelName;
    private long lastModifiedTime;
    private int likers;
    private int listeners;
    private String name;
    private String portrait;
    private int postNum;
    private long publisherId;
    private String publisherName;
    private String publisherPortrait;
    private int replyNum;
    private long startTime;
    private int status;
    private String streamId;
    private long threadId;
    private String title;
    private int type;
    private int zanNum;

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

    public long getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(long j) {
        this.authorId = j;
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

    public long getPublisherId() {
        return this.publisherId;
    }

    public void setPublisherId(long j) {
        this.publisherId = j;
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

    public int getIsVip() {
        return this.isVip;
    }

    public void setIsVip(int i) {
        this.isVip = i;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public long getThreadId() {
        return this.threadId;
    }

    public void setPostNum(int i) {
        this.postNum = i;
    }

    public long getPostNum() {
        return this.postNum;
    }

    public void setLastModifiedTime(long j) {
        this.lastModifiedTime = j;
    }

    public long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public void setZanNum(int i) {
        this.zanNum = i;
    }

    public int getZanNum() {
        return this.zanNum;
    }

    public void setReplyNum(int i) {
        this.replyNum = i;
    }

    public int getReplyNum() {
        return this.replyNum;
    }

    public void setType(int i) {
        this.type = i;
    }

    public long getType() {
        return this.type;
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
            this.type = anchorInfo.type.intValue();
            this.publisherId = anchorInfo.author_id.longValue();
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
            if (anchorInfo.from_type == null) {
                this.fromType = 0;
            } else {
                this.fromType = anchorInfo.from_type.intValue();
            }
            this.labelName = anchorInfo.label_name;
            this.isVip = anchorInfo.is_vip.intValue();
            if (anchorInfo.twzhibo_info != null) {
                this.title = anchorInfo.twzhibo_info.title;
                this.threadId = anchorInfo.twzhibo_info.thread_id.longValue();
                this.postNum = anchorInfo.twzhibo_info.post_num.intValue();
                this.lastModifiedTime = anchorInfo.twzhibo_info.last_modified_time.longValue();
                if (anchorInfo.twzhibo_info.zan != null) {
                    this.zanNum = anchorInfo.twzhibo_info.zan.num.intValue();
                }
                this.replyNum = anchorInfo.twzhibo_info.reply_num.intValue();
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<ad> getImages() {
        ArrayList<ad> arrayList = new ArrayList<>();
        ad adVar = new ad();
        adVar.Wd = this.portrait;
        adVar.aaD = 10;
        arrayList.add(adVar);
        return arrayList;
    }

    public int getFromType() {
        return this.fromType;
    }

    public void setFromType(int i) {
        this.fromType = i;
    }
}
