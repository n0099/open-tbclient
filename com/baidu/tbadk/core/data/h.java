package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long bFS;
    private long bFT;
    private String bFU;
    private String bFV;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.bFS = awardInfo.award_id.longValue();
            this.bFT = awardInfo.award_act_id.longValue();
            this.bFU = awardInfo.award_name;
            this.bFV = awardInfo.award_imgsrc;
        }
    }
}
