package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class i {
    private long eMm;
    private long eMn;
    private String eMo;
    private String eMp;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.eMm = awardInfo.award_id.longValue();
            this.eMn = awardInfo.award_act_id.longValue();
            this.eMo = awardInfo.award_name;
            this.eMp = awardInfo.award_imgsrc;
        }
    }
}
