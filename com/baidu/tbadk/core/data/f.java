package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long WD;
    private long WE;
    private String WF;
    private String WG;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.WD = awardInfo.award_id.longValue();
            this.WE = awardInfo.award_act_id.longValue();
            this.WF = awardInfo.award_name;
            this.WG = awardInfo.award_imgsrc;
        }
    }
}
