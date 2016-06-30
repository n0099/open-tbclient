package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class e {
    private String No;
    private int Nq;
    private long mUserId;
    private String mUserName;

    public long getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String oA() {
        return this.No;
    }

    public int oC() {
        return this.Nq;
    }

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.No = awardUser.award_name;
            this.Nq = awardUser.award_time.intValue();
        }
    }
}
