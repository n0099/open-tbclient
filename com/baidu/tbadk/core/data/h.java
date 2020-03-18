package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long cOb;
    private long cOc;
    private String cOd;
    private String cOe;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.cOb = awardInfo.award_id.longValue();
            this.cOc = awardInfo.award_act_id.longValue();
            this.cOd = awardInfo.award_name;
            this.cOe = awardInfo.award_imgsrc;
        }
    }
}
