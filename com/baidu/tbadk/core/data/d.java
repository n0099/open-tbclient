package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class d {
    private long PH;
    private String PI;
    private String PJ;
    private long mAwardActId;

    public long pk() {
        return this.PH;
    }

    public String pl() {
        return this.PI;
    }

    public String pm() {
        return this.PJ;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.PH = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.PI = awardInfo.award_name;
            this.PJ = awardInfo.award_imgsrc;
        }
    }
}
