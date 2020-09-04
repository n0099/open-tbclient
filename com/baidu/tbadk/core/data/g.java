package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class g {
    private long dXa;
    private long dXb;
    private String dXc;
    private String dXd;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.dXa = awardInfo.award_id.longValue();
            this.dXb = awardInfo.award_act_id.longValue();
            this.dXc = awardInfo.award_name;
            this.dXd = awardInfo.award_imgsrc;
        }
    }
}
