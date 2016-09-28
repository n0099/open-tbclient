package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class e {
    private String PG;
    private int PI;
    private long mUserId;
    private String mUserName;

    public long getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String pm() {
        return this.PG;
    }

    public int po() {
        return this.PI;
    }

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.PG = awardUser.award_name;
            this.PI = awardUser.award_time.intValue();
        }
    }
}
