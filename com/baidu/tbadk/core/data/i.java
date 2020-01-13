package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class i {
    private String cJL;
    private int cJN;
    private long mUserId;
    private String mUserName;

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.cJL = awardUser.award_name;
            this.cJN = awardUser.award_time.intValue();
        }
    }
}
