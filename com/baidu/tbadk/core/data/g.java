package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class g {
    private long dHC;
    private long dHD;
    private String dHE;
    private String dHF;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.dHC = awardInfo.award_id.longValue();
            this.dHD = awardInfo.award_act_id.longValue();
            this.dHE = awardInfo.award_name;
            this.dHF = awardInfo.award_imgsrc;
        }
    }
}
