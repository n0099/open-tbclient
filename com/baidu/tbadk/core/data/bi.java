package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class bi extends u implements com.baidu.tbadk.mvc.b.a {
    private boolean eCB;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private int member_count;
    private String recom_reason;
    private int thread_count;

    public bi() {
        nT(8);
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public boolean isLike() {
        return this.eCB;
    }

    public void setLike(boolean z) {
        this.eCB = z;
    }

    public int blE() {
        return this.member_count;
    }

    public void oe(int i) {
        this.member_count = i;
    }

    public int blF() {
        return this.thread_count;
    }

    public void of(int i) {
        this.thread_count = i;
    }

    public void a(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.mAvatar = recommendForumInfo.avatar;
                this.mForumName = recommendForumInfo.forum_name;
                this.eCB = recommendForumInfo.is_like.intValue() == 1;
                this.member_count = recommendForumInfo.member_count.intValue();
                this.thread_count = recommendForumInfo.thread_count.intValue();
                this.recom_reason = recommendForumInfo.recom_reason;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void df(long j) {
        this.mForumId = j;
    }

    public void AU(String str) {
        this.mAvatar = str;
    }

    public void AV(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bka() {
        return this.recom_reason;
    }

    public void AW(String str) {
        this.recom_reason = str;
    }
}
