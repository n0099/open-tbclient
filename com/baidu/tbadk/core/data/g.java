package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class g {
    private long ezF;
    private long ezG;
    private String ezH;
    private String ezI;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.ezF = awardInfo.award_id.longValue();
            this.ezG = awardInfo.award_act_id.longValue();
            this.ezH = awardInfo.award_name;
            this.ezI = awardInfo.award_imgsrc;
        }
    }
}
