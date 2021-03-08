package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class bn extends w implements com.baidu.tbadk.mvc.b.a {
    private String eQL;
    private boolean eQM;
    private long mForumId;
    private String mForumName;
    private int member_count;
    private String recom_reason;
    private int thread_count;

    public bn() {
        mV(8);
    }

    public String getAvatar() {
        return this.eQL;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public boolean isLike() {
        return this.eQM;
    }

    public void setLike(boolean z) {
        this.eQM = z;
    }

    public int bmW() {
        return this.member_count;
    }

    public void ng(int i) {
        this.member_count = i;
    }

    public int bmX() {
        return this.thread_count;
    }

    public void nh(int i) {
        this.thread_count = i;
    }

    public void a(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.eQL = recommendForumInfo.avatar;
                this.mForumName = recommendForumInfo.forum_name;
                this.eQM = recommendForumInfo.is_like.intValue() == 1;
                this.member_count = recommendForumInfo.member_count.intValue();
                this.thread_count = recommendForumInfo.thread_count.intValue();
                this.recom_reason = recommendForumInfo.recom_reason;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void dK(long j) {
        this.mForumId = j;
    }

    public void Ah(String str) {
        this.eQL = str;
    }

    public void Ai(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String blq() {
        return this.recom_reason;
    }

    public void Aj(String str) {
        this.recom_reason = str;
    }
}
