package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long bYb;
    private long bYc;
    private String bYd;
    private String bYe;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.bYb = awardInfo.award_id.longValue();
            this.bYc = awardInfo.award_act_id.longValue();
            this.bYd = awardInfo.award_name;
            this.bYe = awardInfo.award_imgsrc;
        }
    }
}
