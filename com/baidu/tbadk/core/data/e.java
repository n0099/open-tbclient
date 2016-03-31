package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long SD;
    private String SE;
    private String SF;
    private long mAwardActId;

    public long rp() {
        return this.SD;
    }

    public String rq() {
        return this.SE;
    }

    public String rr() {
        return this.SF;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.SD = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.SE = awardInfo.award_name;
            this.SF = awardInfo.award_imgsrc;
        }
    }
}
