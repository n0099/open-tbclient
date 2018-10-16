package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long alT;
    private long alU;
    private String alV;
    private String alW;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.alT = awardInfo.award_id.longValue();
            this.alU = awardInfo.award_act_id.longValue();
            this.alV = awardInfo.award_name;
            this.alW = awardInfo.award_imgsrc;
        }
    }
}
