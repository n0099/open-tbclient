package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long UQ;
    private String UR;
    private String US;
    private long mAwardActId;

    public long py() {
        return this.UQ;
    }

    public String pz() {
        return this.UR;
    }

    public String pA() {
        return this.US;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.UQ = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.UR = awardInfo.award_name;
            this.US = awardInfo.award_imgsrc;
        }
    }
}
