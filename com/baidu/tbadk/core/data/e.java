package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long VA;
    private String VB;
    private String VC;
    private long mAwardActId;

    public long pB() {
        return this.VA;
    }

    public String pC() {
        return this.VB;
    }

    public String pD() {
        return this.VC;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.VA = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.VB = awardInfo.award_name;
            this.VC = awardInfo.award_imgsrc;
        }
    }
}
