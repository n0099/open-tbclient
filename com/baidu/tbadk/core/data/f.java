package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long Vw;
    private String Vx;
    private String Vy;
    private long mAwardActId;

    public long pC() {
        return this.Vw;
    }

    public String pD() {
        return this.Vx;
    }

    public String pE() {
        return this.Vy;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.Vw = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.Vx = awardInfo.award_name;
            this.Vy = awardInfo.award_imgsrc;
        }
    }
}
