package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class bk extends v implements com.baidu.tbadk.mvc.b.a {
    private String eHR;
    private boolean eHS;
    private long mForumId;
    private String mForumName;
    private int member_count;
    private String recom_reason;
    private int thread_count;

    public bk() {
        on(8);
    }

    public String getAvatar() {
        return this.eHR;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public boolean isLike() {
        return this.eHS;
    }

    public void setLike(boolean z) {
        this.eHS = z;
    }

    public int bnT() {
        return this.member_count;
    }

    public void oy(int i) {
        this.member_count = i;
    }

    public int bnU() {
        return this.thread_count;
    }

    public void oz(int i) {
        this.thread_count = i;
    }

    public void a(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.eHR = recommendForumInfo.avatar;
                this.mForumName = recommendForumInfo.forum_name;
                this.eHS = recommendForumInfo.is_like.intValue() == 1;
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

    public void AW(String str) {
        this.eHR = str;
    }

    public void AX(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bmo() {
        return this.recom_reason;
    }

    public void AY(String str) {
        this.recom_reason = str;
    }
}
