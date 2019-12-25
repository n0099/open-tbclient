package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private String cJA;
    private String cJB;
    private long cJy;
    private long cJz;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.cJy = awardInfo.award_id.longValue();
            this.cJz = awardInfo.award_act_id.longValue();
            this.cJA = awardInfo.award_name;
            this.cJB = awardInfo.award_imgsrc;
        }
    }
}
