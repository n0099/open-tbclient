package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class i {
    private String cNP;
    private int cNR;
    private long mUserId;
    private String mUserName;

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.cNP = awardUser.award_name;
            this.cNR = awardUser.award_time.intValue();
        }
    }
}
