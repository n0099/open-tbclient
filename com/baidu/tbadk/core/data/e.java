package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long aLh;
    private long aLi;
    private String aLj;
    private String aLk;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.aLh = awardInfo.award_id.longValue();
            this.aLi = awardInfo.award_act_id.longValue();
            this.aLj = awardInfo.award_name;
            this.aLk = awardInfo.award_imgsrc;
        }
    }
}
