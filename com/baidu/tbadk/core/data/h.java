package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long bFR;
    private long bFS;
    private String bFT;
    private String bFU;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.bFR = awardInfo.award_id.longValue();
            this.bFS = awardInfo.award_act_id.longValue();
            this.bFT = awardInfo.award_name;
            this.bFU = awardInfo.award_imgsrc;
        }
    }
}
