package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private String VA;
    private long Vy;
    private String Vz;
    private long mAwardActId;

    public long pC() {
        return this.Vy;
    }

    public String pD() {
        return this.Vz;
    }

    public String pE() {
        return this.VA;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.Vy = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.Vz = awardInfo.award_name;
            this.VA = awardInfo.award_imgsrc;
        }
    }
}
