package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long Nr;
    private String Ns;
    private String Nt;
    private long mAwardActId;

    public long oJ() {
        return this.Nr;
    }

    public String oK() {
        return this.Ns;
    }

    public String oL() {
        return this.Nt;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.Nr = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.Ns = awardInfo.award_name;
            this.Nt = awardInfo.award_imgsrc;
        }
    }
}
