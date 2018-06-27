package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long aeT;
    private long aeU;
    private String aeV;
    private String aeW;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.aeT = awardInfo.award_id.longValue();
            this.aeU = awardInfo.award_act_id.longValue();
            this.aeV = awardInfo.award_name;
            this.aeW = awardInfo.award_imgsrc;
        }
    }
}
