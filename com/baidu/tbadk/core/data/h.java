package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long cJJ;
    private long cJK;
    private String cJL;
    private String cJM;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.cJJ = awardInfo.award_id.longValue();
            this.cJK = awardInfo.award_act_id.longValue();
            this.cJL = awardInfo.award_name;
            this.cJM = awardInfo.award_imgsrc;
        }
    }
}
