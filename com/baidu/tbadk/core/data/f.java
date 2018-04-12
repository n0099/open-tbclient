package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long WC;
    private long WD;
    private String WE;
    private String WF;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.WC = awardInfo.award_id.longValue();
            this.WD = awardInfo.award_act_id.longValue();
            this.WE = awardInfo.award_name;
            this.WF = awardInfo.award_imgsrc;
        }
    }
}
