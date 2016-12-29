package com.baidu.tbadk.core.data;

import tbclient.AwardInfo;
/* loaded from: classes.dex */
public class e {
    private long PW;
    private String PX;
    private String PY;
    private long mAwardActId;

    public long po() {
        return this.PW;
    }

    public String pp() {
        return this.PX;
    }

    public String pq() {
        return this.PY;
    }

    public void a(AwardInfo awardInfo) {
        if (awardInfo != null) {
            this.PW = awardInfo.award_id.longValue();
            this.mAwardActId = awardInfo.award_act_id.longValue();
            this.PX = awardInfo.award_name;
            this.PY = awardInfo.award_imgsrc;
        }
    }
}
