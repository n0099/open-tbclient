package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long eKa;
    private long eKb;
    private String eKc;
    private String eKd;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.eKa = awardInfo.award_id.longValue();
            this.eKb = awardInfo.award_act_id.longValue();
            this.eKc = awardInfo.award_name;
            this.eKd = awardInfo.award_imgsrc;
        }
    }
}
