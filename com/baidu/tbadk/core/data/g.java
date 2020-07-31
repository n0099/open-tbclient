package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class g {
    private long dNN;
    private long dNO;
    private String dNP;
    private String dNQ;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.dNN = awardInfo.award_id.longValue();
            this.dNO = awardInfo.award_act_id.longValue();
            this.dNP = awardInfo.award_name;
            this.dNQ = awardInfo.award_imgsrc;
        }
    }
}
