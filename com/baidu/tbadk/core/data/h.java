package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes2.dex */
public class h {
    private String dWY;
    private int dXa;
    private long mUserId;
    private String mUserName;

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.dWY = awardUser.award_name;
            this.dXa = awardUser.award_time.intValue();
        }
    }
}
