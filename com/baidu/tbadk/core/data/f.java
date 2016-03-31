package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class f {
    private String SE;
    private int SG;
    private long mUserId;
    private String mUserName;

    public long getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String rq() {
        return this.SE;
    }

    public int rs() {
        return this.SG;
    }

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.SE = awardUser.award_name;
            this.SG = awardUser.award_time.intValue();
        }
    }
}
