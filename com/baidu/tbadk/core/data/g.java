package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class g {
    private long dZk;
    private long dZl;
    private String dZm;
    private String dZn;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.dZk = awardInfo.award_id.longValue();
            this.dZl = awardInfo.award_act_id.longValue();
            this.dZm = awardInfo.award_name;
            this.dZn = awardInfo.award_imgsrc;
        }
    }
}
