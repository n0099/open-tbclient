package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class i {
    private String bxG;
    private int bxI;
    private long mUserId;
    private String mUserName;

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.bxG = awardUser.award_name;
            this.bxI = awardUser.award_time.intValue();
        }
    }
}
