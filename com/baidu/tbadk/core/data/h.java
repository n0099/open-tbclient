package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long dnj;
    private long dnk;
    private String dnl;
    private String dnm;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.dnj = awardInfo.award_id.longValue();
            this.dnk = awardInfo.award_act_id.longValue();
            this.dnl = awardInfo.award_name;
            this.dnm = awardInfo.award_imgsrc;
        }
    }
}
