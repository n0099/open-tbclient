package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class g {
    private String aeG;
    private int aeI;
    private long mUserId;
    private String mUserName;

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.aeG = awardUser.award_name;
            this.aeI = awardUser.award_time.intValue();
        }
    }
}
