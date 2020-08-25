package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes2.dex */
public class g {
    private long dWW;
    private long dWX;
    private String dWY;
    private String dWZ;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.dWW = awardInfo.award_id.longValue();
            this.dWX = awardInfo.award_act_id.longValue();
            this.dWY = awardInfo.award_name;
            this.dWZ = awardInfo.award_imgsrc;
        }
    }
}
