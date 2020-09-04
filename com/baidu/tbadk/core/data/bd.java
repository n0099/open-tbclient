package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class bd {
    private PrivateForumShareinfo dZK = null;
    private PrivatePopInfo dZL = null;
    private PrivateForumInfo dZM = null;
    private Integer dZN = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.dZL;
    }

    public PrivateForumInfo bdB() {
        return this.dZM;
    }

    public Integer bdC() {
        return this.dZN;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.dZK = privateForumTotalInfo.private_forum_shareinfo;
                this.dZM = privateForumTotalInfo.private_forum_info;
                this.dZN = privateForumTotalInfo.private_forum_taskpercent;
                this.dZL = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
