package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long VD;
    private String VE;
    private String VF;
    private long mAwardActId;

    public long pD() {
        return this.VD;
    }

    public String pE() {
        return this.VE;
    }

    public String pF() {
        return this.VF;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.VD = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.VE = awardInfo.award_name;
            this.VF = awardInfo.award_imgsrc;
        }
    }
}
