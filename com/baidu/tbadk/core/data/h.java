package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long bxD;
    private long bxE;
    private String bxF;
    private String bxG;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.bxD = awardInfo.award_id.longValue();
            this.bxE = awardInfo.award_act_id.longValue();
            this.bxF = awardInfo.award_name;
            this.bxG = awardInfo.award_imgsrc;
        }
    }
}
