package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long aJV;
    private String aJW;
    private String aJX;
    private long mAwardActId;

    public long xd() {
        return this.aJV;
    }

    public String xe() {
        return this.aJW;
    }

    public String xf() {
        return this.aJX;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.aJV = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.aJW = awardInfo.award_name;
            this.aJX = awardInfo.award_imgsrc;
        }
    }
}
