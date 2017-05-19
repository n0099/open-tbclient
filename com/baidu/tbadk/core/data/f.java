package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class f {
    private String TW;
    private int TY;
    private long mUserId;
    private String mUserName;

    public long getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String pB() {
        return this.TW;
    }

    public int pD() {
        return this.TY;
    }

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.TW = awardUser.award_name;
            this.TY = awardUser.award_time.intValue();
        }
    }
}
