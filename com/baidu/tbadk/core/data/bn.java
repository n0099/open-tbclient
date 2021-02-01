package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class bn extends w implements com.baidu.tbadk.mvc.b.a {
    private String ePk;
    private boolean ePl;
    private long mForumId;
    private String mForumName;
    private int member_count;
    private String recom_reason;
    private int thread_count;

    public bn() {
        mU(8);
    }

    public String getAvatar() {
        return this.ePk;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public boolean isLike() {
        return this.ePl;
    }

    public void setLike(boolean z) {
        this.ePl = z;
    }

    public int bmU() {
        return this.member_count;
    }

    public void nf(int i) {
        this.member_count = i;
    }

    public int bmV() {
        return this.thread_count;
    }

    public void ng(int i) {
        this.thread_count = i;
    }

    public void a(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            try {
                this.mForumId = recommendForumInfo.forum_id.longValue();
                this.ePk = recommendForumInfo.avatar;
                this.mForumName = recommendForumInfo.forum_name;
                this.ePl = recommendForumInfo.is_like.intValue() == 1;
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

    public void Aa(String str) {
        this.ePk = str;
    }

    public void Ab(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String blo() {
        return this.recom_reason;
    }

    public void Ac(String str) {
        this.recom_reason = str;
    }
}
