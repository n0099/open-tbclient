package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long UB;
    private String UC;
    private String UD;
    private long mAwardActId;

    public long pT() {
        return this.UB;
    }

    public String pU() {
        return this.UC;
    }

    public String pV() {
        return this.UD;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.UB = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.UC = awardInfo.award_name;
            this.UD = awardInfo.award_imgsrc;
        }
    }
}
