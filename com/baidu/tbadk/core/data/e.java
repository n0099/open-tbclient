package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long aLr;
    private long aLs;
    private String aLt;
    private String aLu;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.aLr = awardInfo.award_id.longValue();
            this.aLs = awardInfo.award_act_id.longValue();
            this.aLt = awardInfo.award_name;
            this.aLu = awardInfo.award_imgsrc;
        }
    }
}
