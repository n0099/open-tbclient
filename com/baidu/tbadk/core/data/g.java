package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class g {
    private long elm;
    private long eln;
    private String elo;
    private String elp;

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.elm = awardInfo.award_id.longValue();
            this.eln = awardInfo.award_act_id.longValue();
            this.elo = awardInfo.award_name;
            this.elp = awardInfo.award_imgsrc;
        }
    }
}
