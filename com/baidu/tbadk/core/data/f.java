package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long aqJ;
    private long aqK;
    private String aqL;
    private String aqM;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.aqJ = awardInfo.award_id.longValue();
            this.aqK = awardInfo.award_act_id.longValue();
            this.aqL = awardInfo.award_name;
            this.aqM = awardInfo.award_imgsrc;
        }
    }
}
