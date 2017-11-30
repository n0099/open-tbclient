package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class f {
    private String VE;
    private int VG;
    private long mUserId;
    private String mUserName;

    public long getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String pE() {
        return this.VE;
    }

    public int pG() {
        return this.VG;
    }

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.VE = awardUser.award_name;
            this.VG = awardUser.award_time.intValue();
        }
    }
}
