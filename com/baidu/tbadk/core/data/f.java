package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long agX;
    private long agY;
    private String agZ;
    private String aha;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.agX = awardInfo.award_id.longValue();
            this.agY = awardInfo.award_act_id.longValue();
            this.agZ = awardInfo.award_name;
            this.aha = awardInfo.award_imgsrc;
        }
    }
}
