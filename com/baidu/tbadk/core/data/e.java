package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class e {
    private String PI;
    private int PK;
    private long mUserId;
    private String mUserName;

    public long getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String pl() {
        return this.PI;
    }

    public int pn() {
        return this.PK;
    }

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.PI = awardUser.award_name;
            this.PK = awardUser.award_time.intValue();
        }
    }
}
