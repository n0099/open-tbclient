package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class HotTopicBussinessData extends OrmObject implements Serializable {
    private static final long serialVersionUID = 1827556427330154557L;
    public long mFollowNum;
    public String mForumAbstract;
    public String mForumAvatar;
    public long mForumId;
    public String mForumName;
    public int mIsGlobalBlock;
    public boolean mIsLiked;
    public long mPostNum;
    public long mThreadNum;
    public String mTopicName;

    public HotTopicBussinessData(long j, String str, String str2, String str3, long j2, long j3, long j4, boolean z, String str4, int i) {
        this.mForumId = 0L;
        this.mForumName = null;
        this.mForumAvatar = null;
        this.mForumAbstract = null;
        this.mThreadNum = 0L;
        this.mPostNum = 0L;
        this.mFollowNum = 0L;
        this.mIsLiked = false;
        this.mIsGlobalBlock = 0;
        this.mForumId = j;
        this.mForumName = str;
        this.mForumAvatar = str2;
        this.mForumAbstract = str3;
        this.mThreadNum = j2;
        this.mPostNum = j3;
        this.mFollowNum = j4;
        this.mIsLiked = z;
        this.mTopicName = str4;
        this.mIsGlobalBlock = i;
    }

    public HotTopicBussinessData(long j, String str, String str2, int i) {
        this.mForumId = 0L;
        this.mForumName = null;
        this.mForumAvatar = null;
        this.mForumAbstract = null;
        this.mThreadNum = 0L;
        this.mPostNum = 0L;
        this.mFollowNum = 0L;
        this.mIsLiked = false;
        this.mIsGlobalBlock = 0;
        this.mForumId = j;
        this.mForumName = str;
        this.mTopicName = str2;
        this.mIsGlobalBlock = i;
    }

    public HotTopicBussinessData() {
        this.mForumId = 0L;
        this.mForumName = null;
        this.mForumAvatar = null;
        this.mForumAbstract = null;
        this.mThreadNum = 0L;
        this.mPostNum = 0L;
        this.mFollowNum = 0L;
        this.mIsLiked = false;
        this.mIsGlobalBlock = 0;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public String getForumAvatar() {
        return this.mForumAvatar;
    }

    public void setForumAvatar(String str) {
        this.mForumAvatar = str;
    }
}
