package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long aew;
    private long aex;
    private String aey;
    private String aez;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.aew = awardInfo.award_id.longValue();
            this.aex = awardInfo.award_act_id.longValue();
            this.aey = awardInfo.award_name;
            this.aez = awardInfo.award_imgsrc;
        }
    }
}
