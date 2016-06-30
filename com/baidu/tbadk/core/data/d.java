package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class d {
    private long Nn;
    private String No;
    private String Np;
    private long mAwardActId;

    public long oz() {
        return this.Nn;
    }

    public String oA() {
        return this.No;
    }

    public String oB() {
        return this.Np;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.Nn = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.No = awardInfo.award_name;
            this.Np = awardInfo.award_imgsrc;
        }
    }
}
