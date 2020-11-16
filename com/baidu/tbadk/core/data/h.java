package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long exU;
    private long exV;
    private String exW;
    private String exX;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.exU = awardInfo.award_id.longValue();
            this.exV = awardInfo.award_act_id.longValue();
            this.exW = awardInfo.award_name;
            this.exX = awardInfo.award_imgsrc;
        }
    }
}
