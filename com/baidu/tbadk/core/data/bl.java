package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class bl extends v implements com.baidu.tbadk.mvc.b.a {
    private String eMY;
    private boolean eMZ;
    private long mForumId;
    private String mForumName;
    private int member_count;
    private String recom_reason;
    private int thread_count;

    public bl() {
        mR(8);
    }

    public String getAvatar() {
        return this.eMY;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public boolean isLike() {
        return this.eMZ;
    }

    public void setLike(boolean z) {
        this.eMZ = z;
    }

    public int bmB() {
        return this.member_count;
    }

    public void nc(int i) {
        this.member_count = i;
    }

    public int bmC() {
        return this.thread_count;
    }

    public void nd(int i) {
        this.thread_count = i;
    }

    public void a(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.eMY = recommendForumInfo.avatar;
                this.mForumName = recommendForumInfo.forum_name;
                this.eMZ = recommendForumInfo.is_like.intValue() == 1;
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

    public void zJ(String str) {
        this.eMY = str;
    }

    public void zK(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bkW() {
        return this.recom_reason;
    }

    public void zL(String str) {
        this.recom_reason = str;
    }
}
