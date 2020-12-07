package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long eEV;
    private long eEW;
    private String eEX;
    private String eEY;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.eEV = awardInfo.award_id.longValue();
            this.eEW = awardInfo.award_act_id.longValue();
            this.eEX = awardInfo.award_name;
            this.eEY = awardInfo.award_imgsrc;
        }
    }
}
