package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class j {
    private String eNP;
    private int eNR;
    private long mUserId;
    private String mUserName;

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.eNP = awardUser.award_name;
            this.eNR = awardUser.award_time.intValue();
        }
    }
}
