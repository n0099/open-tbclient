package com.baidu.tbadk.core.data;

import tbclient.AwardUser;
/* loaded from: classes.dex */
public class f {
    private String Ns;
    private int Nu;
    private long mUserId;
    private String mUserName;

    public long getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String oK() {
        return this.Ns;
    }

    public int oM() {
        return this.Nu;
    }

    public void a(AwardUser awardUser) {
        if (awardUser != null) {
            this.mUserId = awardUser.user_id.longValue();
            this.mUserName = awardUser.user_name;
            this.Ns = awardUser.award_name;
            this.Nu = awardUser.award_time.intValue();
        }
    }
}
