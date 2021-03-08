package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class i {
    private long eNN;
    private long eNO;
    private String eNP;
    private String eNQ;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.eNN = awardInfo.award_id.longValue();
            this.eNO = awardInfo.award_act_id.longValue();
            this.eNP = awardInfo.award_name;
            this.eNQ = awardInfo.award_imgsrc;
        }
    }
}
