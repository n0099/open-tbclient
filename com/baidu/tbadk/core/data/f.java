package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long UD;
    private String UE;
    private String UF;
    private long mAwardActId;

    public long pr() {
        return this.UD;
    }

    public String ps() {
        return this.UE;
    }

    public String pt() {
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
