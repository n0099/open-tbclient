package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class bl extends v implements com.baidu.tbadk.mvc.b.a {
    private String eRJ;
    private boolean eRK;
    private long mForumId;
    private String mForumName;
    private int member_count;
    private String recom_reason;
    private int thread_count;

    public bl() {
        ox(8);
    }

    public String getAvatar() {
        return this.eRJ;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public boolean isLike() {
        return this.eRK;
    }

    public void setLike(boolean z) {
        this.eRK = z;
    }

    public int bqv() {
        return this.member_count;
    }

    public void oI(int i) {
        this.member_count = i;
    }

    public int bqw() {
        return this.thread_count;
    }

    public void oJ(int i) {
        this.thread_count = i;
    }

    public void a(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.eRJ = recommendForumInfo.avatar;
                this.mForumName = recommendForumInfo.forum_name;
                this.eRK = recommendForumInfo.is_like.intValue() == 1;
                this.member_count = recommendForumInfo.member_count.intValue();
                this.thread_count = recommendForumInfo.thread_count.intValue();
                this.recom_reason = recommendForumInfo.recom_reason;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void dE(long j) {
        this.mForumId = j;
    }

    public void AU(String str) {
        this.eRJ = str;
    }

    public void AV(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String boQ() {
        return this.recom_reason;
    }

    public void AW(String str) {
        this.recom_reason = str;
    }
}
