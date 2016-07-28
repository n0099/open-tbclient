package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class d {
    private long Nl;
    private String Nm;
    private String Nn;
    private long mAwardActId;

    public long oo() {
        return this.Nl;
    }

    public String op() {
        return this.Nm;
    }

    public String oq() {
        return this.Nn;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.Nl = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.Nm = awardInfo.award_name;
            this.Nn = awardInfo.award_imgsrc;
        }
    }
}
