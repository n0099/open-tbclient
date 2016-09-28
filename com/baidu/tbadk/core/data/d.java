package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class d {
    private long PF;
    private String PG;
    private String PH;
    private long mAwardActId;

    public long pl() {
        return this.PF;
    }

    public String pm() {
        return this.PG;
    }

    public String pn() {
        return this.PH;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.PF = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.PG = awardInfo.award_name;
            this.PH = awardInfo.award_imgsrc;
        }
    }
}
