package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long cNN;
    private long cNO;
    private String cNP;
    private String cNQ;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.cNN = awardInfo.award_id.longValue();
            this.cNO = awardInfo.award_act_id.longValue();
            this.cNP = awardInfo.award_name;
            this.cNQ = awardInfo.award_imgsrc;
        }
    }
}
