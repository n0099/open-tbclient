package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long aJY;
    private String aJZ;
    private String aKa;
    private long mAwardActId;

    public long xe() {
        return this.aJY;
    }

    public String xf() {
        return this.aJZ;
    }

    public String xg() {
        return this.aKa;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.aJY = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.aJZ = awardInfo.award_name;
            this.aKa = awardInfo.award_imgsrc;
        }
    }
}
