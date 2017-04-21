package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long UD;
    private String UE;
    private String UF;
    private long mAwardActId;

    public long pT() {
        return this.UD;
    }

    public String pU() {
        return this.UE;
    }

    public String pV() {
        return this.UF;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.UD = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.UE = awardInfo.award_name;
            this.UF = awardInfo.award_imgsrc;
        }
    }
}
