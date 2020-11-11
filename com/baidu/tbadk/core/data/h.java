package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class h {
    private String ezH;
    private int ezJ;
    private long mUserId;
    private String mUserName;

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.ezH = awardUser.award_name;
            this.ezJ = awardUser.award_time.intValue();
        }
    }
}
