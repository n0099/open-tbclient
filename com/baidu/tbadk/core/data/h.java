package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long bxA;
    private long bxB;
    private String bxC;
    private String bxD;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.bxA = awardInfo.award_id.longValue();
            this.bxB = awardInfo.award_act_id.longValue();
            this.bxC = awardInfo.award_name;
            this.bxD = awardInfo.award_imgsrc;
        }
    }
}
