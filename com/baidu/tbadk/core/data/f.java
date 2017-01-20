package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long Pf;
    private String Pg;
    private String Ph;
    private long mAwardActId;

    public long ph() {
        return this.Pf;
    }

    public String pi() {
        return this.Pg;
    }

    public String pj() {
        return this.Ph;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.Pf = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.Pg = awardInfo.award_name;
            this.Ph = awardInfo.award_imgsrc;
        }
    }
}
