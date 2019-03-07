package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private String bxA;
    private String bxB;
    private long bxy;
    private long bxz;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.bxy = awardInfo.award_id.longValue();
            this.bxz = awardInfo.award_act_id.longValue();
            this.bxA = awardInfo.award_name;
            this.bxB = awardInfo.award_imgsrc;
        }
    }
}
