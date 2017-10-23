package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class g {
    private String UE;
    private int UG;
    private long mUserId;
    private String mUserName;

    public long getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String ps() {
        return this.UE;
    }

    public int pu() {
        return this.UG;
    }

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.UE = awardUser.award_name;
            this.UG = awardUser.award_time.intValue();
        }
    }
}
