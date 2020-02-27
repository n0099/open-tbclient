package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long cNM;
    private long cNN;
    private String cNO;
    private String cNP;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.cNM = awardInfo.award_id.longValue();
            this.cNN = awardInfo.award_act_id.longValue();
            this.cNO = awardInfo.award_name;
            this.cNP = awardInfo.award_imgsrc;
        }
    }
}
