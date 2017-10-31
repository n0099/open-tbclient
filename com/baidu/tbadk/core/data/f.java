package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long UW;
    private String UX;
    private String UY;
    private long mAwardActId;

    public long pw() {
        return this.UW;
    }

    public String px() {
        return this.UX;
    }

    public String py() {
        return this.UY;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.UW = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.UX = awardInfo.award_name;
            this.UY = awardInfo.award_imgsrc;
        }
    }
}
