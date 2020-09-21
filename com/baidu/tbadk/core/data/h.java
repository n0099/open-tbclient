package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class h {
    private String dZm;
    private int dZo;
    private long mUserId;
    private String mUserName;

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.dZm = awardUser.award_name;
            this.dZo = awardUser.award_time.intValue();
        }
    }
}
