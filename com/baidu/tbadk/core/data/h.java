package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long bGq;
    private long bGr;
    private String bGs;
    private String bGt;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.bGq = awardInfo.award_id.longValue();
            this.bGr = awardInfo.award_act_id.longValue();
            this.bGs = awardInfo.award_name;
            this.bGt = awardInfo.award_imgsrc;
        }
    }
}
