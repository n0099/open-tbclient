package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long bXk;
    private long bXl;
    private String bXm;
    private String bXn;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.bXk = awardInfo.award_id.longValue();
            this.bXl = awardInfo.award_act_id.longValue();
            this.bXm = awardInfo.award_name;
            this.bXn = awardInfo.award_imgsrc;
        }
    }
}
