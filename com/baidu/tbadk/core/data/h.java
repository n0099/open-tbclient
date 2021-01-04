package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long eOL;
    private long eOM;
    private String eON;
    private String eOO;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.eOL = awardInfo.award_id.longValue();
            this.eOM = awardInfo.award_act_id.longValue();
            this.eON = awardInfo.award_name;
            this.eOO = awardInfo.award_imgsrc;
        }
    }
}
