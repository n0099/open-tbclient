package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long bEP;
    private long bEQ;
    private String bER;
    private String bES;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.bEP = awardInfo.award_id.longValue();
            this.bEQ = awardInfo.award_act_id.longValue();
            this.bER = awardInfo.award_name;
            this.bES = awardInfo.award_imgsrc;
        }
    }
}
