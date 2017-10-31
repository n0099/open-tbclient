package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class g {
    private String UX;
    private int UZ;
    private long mUserId;
    private String mUserName;

    public long getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String px() {
        return this.UX;
    }

    public int pz() {
        return this.UZ;
    }

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.UX = awardUser.award_name;
            this.UZ = awardUser.award_time.intValue();
        }
    }
}
