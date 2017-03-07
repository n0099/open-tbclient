package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long Uh;
    private String Ui;
    private String Uj;
    private long mAwardActId;

    public long pv() {
        return this.Uh;
    }

    public String pw() {
        return this.Ui;
    }

    public String px() {
        return this.Uj;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.Uh = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.Ui = awardInfo.award_name;
            this.Uj = awardInfo.award_imgsrc;
        }
    }
}
