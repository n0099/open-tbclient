package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long TX;
    private String TY;
    private String TZ;
    private long mAwardActId;

    public long ps() {
        return this.TX;
    }

    public String pt() {
        return this.TY;
    }

    public String pu() {
        return this.TZ;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.TX = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.TY = awardInfo.award_name;
            this.TZ = awardInfo.award_imgsrc;
        }
    }
}
