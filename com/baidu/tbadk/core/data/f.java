package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long UB;
    private String UC;
    private String UD;
    private long mAwardActId;

    public long px() {
        return this.UB;
    }

    public String py() {
        return this.UC;
    }

    public String pz() {
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
