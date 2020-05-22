package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class g {
    private long dBl;
    private long dBm;
    private String dBn;
    private String dBo;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.dBl = awardInfo.award_id.longValue();
            this.dBm = awardInfo.award_act_id.longValue();
            this.dBn = awardInfo.award_name;
            this.dBo = awardInfo.award_imgsrc;
        }
    }
}
