package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class i {
    private String bGs;
    private int bGu;
    private long mUserId;
    private String mUserName;

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.bGs = awardUser.award_name;
            this.bGu = awardUser.award_time.intValue();
        }
    }
}
