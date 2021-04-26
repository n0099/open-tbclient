package com.baidu.tbadk.core.data;

import java.io.Serializable;
import tbclient.FeedForumInfo;
/* loaded from: classes3.dex */
public class FeedForumData implements Serializable {
    public String avatar;
    public String forumId;
    public String forumName;
    public int isLike;
    public int memberCount;
    public int pos;
    public int postNum;
    public String reason;

    public String getAvatar() {
        return this.avatar;
    }

    public String getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public int getIsLike() {
        return this.isLike;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public int getPos() {
        return this.pos;
    }

    public int getPostNum() {
        return this.postNum;
    }

    public String getReason() {
        return this.reason;
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

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setIsLike(int i2) {
        this.isLike = i2;
    }

    public void setMemberCount(int i2) {
        this.memberCount = i2;
    }

    public void setPos(int i2) {
        this.pos = i2;
    }

    public void setPostNum(int i2) {
        this.postNum = i2;
    }

    public void setReason(String str) {
        this.reason = str;
    }
}
