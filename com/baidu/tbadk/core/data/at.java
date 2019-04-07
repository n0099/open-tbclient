package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class at {
    private PrivateForumShareinfo bzZ = null;
    private PrivatePopInfo bAa = null;
    private PrivateForumInfo bAb = null;
    private Integer bAc = null;

    public PrivateForumShareinfo XO() {
        return this.bzZ;
    }

    public PrivatePopInfo getPrivatePopInfo() {
        return this.bAa;
    }

    public PrivateForumInfo XP() {
        return this.bAb;
    }

    public Integer XQ() {
        return this.bAc;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.bzZ = privateForumTotalInfo.private_forum_shareinfo;
                this.bAb = privateForumTotalInfo.private_forum_info;
                this.bAc = privateForumTotalInfo.private_forum_taskpercent;
                this.bAa = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
