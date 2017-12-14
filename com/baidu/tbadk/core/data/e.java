package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long Vx;
    private String Vy;
    private String Vz;
    private long mAwardActId;

    public long pB() {
        return this.Vx;
    }

    public String pC() {
        return this.Vy;
    }

    public String pD() {
        return this.Vz;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.Vx = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.Vy = awardInfo.award_name;
            this.Vz = awardInfo.award_imgsrc;
        }
    }
}
