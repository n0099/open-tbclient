package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class f {
    private long aeE;
    private long aeF;
    private String aeG;
    private String aeH;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.aeE = awardInfo.award_id.longValue();
            this.aeF = awardInfo.award_act_id.longValue();
            this.aeG = awardInfo.award_name;
            this.aeH = awardInfo.award_imgsrc;
        }
    }
}
