package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long aqh;
    private long aqi;
    private String aqj;
    private String aqk;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.aqh = awardInfo.award_id.longValue();
            this.aqi = awardInfo.award_act_id.longValue();
            this.aqj = awardInfo.award_name;
            this.aqk = awardInfo.award_imgsrc;
        }
    }
}
