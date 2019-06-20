package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class i {
    private String bES;
    private int bEU;
    private long mUserId;
    private String mUserName;

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.bES = awardUser.award_name;
            this.bEU = awardUser.award_time.intValue();
        }
    }
}
