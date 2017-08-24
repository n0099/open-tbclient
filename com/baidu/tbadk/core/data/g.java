package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class g {
    private String VA;
    private int VC;
    private long mUserId;
    private String mUserName;

    public long getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String pE() {
        return this.VA;
    }

    public int pG() {
        return this.VC;
    }

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.VA = awardUser.award_name;
            this.VC = awardUser.award_time.intValue();
        }
    }
}
