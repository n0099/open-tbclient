package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long cNO;
    private long cNP;
    private String cNQ;
    private String cNR;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.cNO = awardInfo.award_id.longValue();
            this.cNP = awardInfo.award_act_id.longValue();
            this.cNQ = awardInfo.award_name;
            this.cNR = awardInfo.award_imgsrc;
        }
    }
}
