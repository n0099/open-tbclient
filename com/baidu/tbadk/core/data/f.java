package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private String VA;
    private String VB;
    private long Vz;
    private long mAwardActId;

    public long pD() {
        return this.Vz;
    }

    public String pE() {
        return this.VA;
    }

    public String pF() {
        return this.VB;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.Vz = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.VA = awardInfo.award_name;
            this.VB = awardInfo.award_imgsrc;
        }
    }
}
