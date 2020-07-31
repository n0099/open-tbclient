package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class h {
    private String dNP;
    private int dNR;
    private long mUserId;
    private String mUserName;

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.dNP = awardUser.award_name;
            this.dNR = awardUser.award_time.intValue();
        }
    }
}
