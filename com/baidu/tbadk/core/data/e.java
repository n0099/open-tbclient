package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long aLg;
    private long aLh;
    private String aLi;
    private String aLj;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.aLg = awardInfo.award_id.longValue();
            this.aLh = awardInfo.award_act_id.longValue();
            this.aLi = awardInfo.award_name;
            this.aLj = awardInfo.award_imgsrc;
        }
    }
}
