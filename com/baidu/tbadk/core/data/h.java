package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long bEQ;
    private long bER;
    private String bES;
    private String bET;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.bEQ = awardInfo.award_id.longValue();
            this.bER = awardInfo.award_act_id.longValue();
            this.bES = awardInfo.award_name;
            this.bET = awardInfo.award_imgsrc;
        }
    }
}
