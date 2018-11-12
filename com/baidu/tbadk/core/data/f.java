package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long amG;
    private long amH;
    private String amI;
    private String amJ;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.amG = awardInfo.award_id.longValue();
            this.amH = awardInfo.award_act_id.longValue();
            this.amI = awardInfo.award_name;
            this.amJ = awardInfo.award_imgsrc;
        }
    }
}
