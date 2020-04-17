package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class h {
    private long dnf;
    private long dng;
    private String dnh;
    private String dni;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.dnf = awardInfo.award_id.longValue();
            this.dng = awardInfo.award_act_id.longValue();
            this.dnh = awardInfo.award_name;
            this.dni = awardInfo.award_imgsrc;
        }
    }
}
