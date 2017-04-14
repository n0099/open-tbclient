package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class f {
    private String UC;
    private int UE;
    private long mUserId;
    private String mUserName;

    public long getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String pU() {
        return this.UC;
    }

    public int pW() {
        return this.UE;
    }

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.UC = awardUser.award_name;
            this.UE = awardUser.award_time.intValue();
        }
    }
}
