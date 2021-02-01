package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class j {
    private String eMo;
    private int eMq;
    private long mUserId;
    private String mUserName;

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.eMo = awardUser.award_name;
            this.eMq = awardUser.award_time.intValue();
        }
    }
}
