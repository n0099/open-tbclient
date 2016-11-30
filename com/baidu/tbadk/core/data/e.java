package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long PZ;
    private String Qa;
    private String Qb;
    private long mAwardActId;

    public long po() {
        return this.PZ;
    }

    public String pp() {
        return this.Qa;
    }

    public String pq() {
        return this.Qb;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.PZ = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.Qa = awardInfo.award_name;
            this.Qb = awardInfo.award_imgsrc;
        }
    }
}
