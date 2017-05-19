package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long TV;
    private String TW;
    private String TX;
    private long mAwardActId;

    public long pA() {
        return this.TV;
    }

    public String pB() {
        return this.TW;
    }

    public String pC() {
        return this.TX;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.TV = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.TW = awardInfo.award_name;
            this.TX = awardInfo.award_imgsrc;
        }
    }
}
