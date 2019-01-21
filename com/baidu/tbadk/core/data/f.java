package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long aqK;
    private long aqL;
    private String aqM;
    private String aqN;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.aqK = awardInfo.award_id.longValue();
            this.aqL = awardInfo.award_act_id.longValue();
            this.aqM = awardInfo.award_name;
            this.aqN = awardInfo.award_imgsrc;
        }
    }
}
