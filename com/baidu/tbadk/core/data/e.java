package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long TH;
    private String TI;
    private String TJ;
    private long mAwardActId;

    public long ps() {
        return this.TH;
    }

    public String pt() {
        return this.TI;
    }

    public String pu() {
        return this.TJ;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.TH = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.TI = awardInfo.award_name;
            this.TJ = awardInfo.award_imgsrc;
        }
    }
}
