package com.baidu.tbadk.core.data;

import java.io.Serializable;
import tbclient.FeedForumInfo;
/* loaded from: classes2.dex */
public class FeedForumData implements Serializable {
    private String avatar;
    private String forumId;
    private String forumName;
    private int isLike;
    private int memberCount;
    private int pos;
    private int postNum;
    private String reason;

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public void setMemberCount(int i) {
        this.memberCount = i;
    }

    public int getPostNum() {
        return this.postNum;
    }

    public void setPostNum(int i) {
        this.postNum = i;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public int getPos() {
        return this.pos;
    }

    public void setPos(int i) {
        this.pos = i;
    }

    public int getIsLike() {
        return this.isLike;
    }

    public void setIsLike(int i) {
        this.isLike = i;
    }

    public void parseFromFeedForumInfo(FeedForumInfo feedForumInfo) {
        this.forumId = feedForumInfo.forum_id + "";
        this.forumName = feedForumInfo.forum_name;
        this.memberCount = feedForumInfo.member_count.intValue();
        this.postNum = feedForumInfo.post_num.intValue();
        this.avatar = feedForumInfo.avatar;
        this.reason = feedForumInfo.reason;
        this.pos = feedForumInfo.pos.intValue();
        this.isLike = feedForumInfo.is_like.intValue();
    }
}
