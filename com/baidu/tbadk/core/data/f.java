package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long TG;
    private String TH;
    private String TI;
    private long mAwardActId;

    public long pp() {
        return this.TG;
    }

    public String pq() {
        return this.TH;
    }

    public String pr() {
        return this.TI;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.TG = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.TH = awardInfo.award_name;
            this.TI = awardInfo.award_imgsrc;
        }
    }
}
