package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class g {
    private long etM;
    private long etN;
    private String etO;
    private String etP;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.etM = awardInfo.award_id.longValue();
            this.etN = awardInfo.award_act_id.longValue();
            this.etO = awardInfo.award_name;
            this.etP = awardInfo.award_imgsrc;
        }
    }
}
