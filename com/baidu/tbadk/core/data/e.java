package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long aJX;
    private String aJY;
    private String aJZ;
    private long mAwardActId;

    public long xe() {
        return this.aJX;
    }

    public String xf() {
        return this.aJY;
    }

    public String xg() {
        return this.aJZ;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.aJX = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.aJY = awardInfo.award_name;
            this.aJZ = awardInfo.award_imgsrc;
        }
    }
}
