package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long bxE;
    private long bxF;
    private String bxG;
    private String bxH;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.bxE = awardInfo.award_id.longValue();
            this.bxF = awardInfo.award_act_id.longValue();
            this.bxG = awardInfo.award_name;
            this.bxH = awardInfo.award_imgsrc;
        }
    }
}
