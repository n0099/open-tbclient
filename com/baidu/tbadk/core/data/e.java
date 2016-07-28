package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class e {
    private String Nm;
    private int No;
    private long mUserId;
    private String mUserName;

    public long getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String op() {
        return this.Nm;
    }

    public int or() {
        return this.No;
    }

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.Nm = awardUser.award_name;
            this.No = awardUser.award_time.intValue();
        }
    }
}
