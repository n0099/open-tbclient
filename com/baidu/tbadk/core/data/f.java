package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class f {
    private String aJZ;
    private int aKb;
    private long mUserId;
    private String mUserName;

    public long getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String xf() {
        return this.aJZ;
    }

    public int xh() {
        return this.aKb;
    }

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.aJZ = awardUser.award_name;
            this.aKb = awardUser.award_time.intValue();
        }
    }
}
