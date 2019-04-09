package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class at {
    private PrivateForumShareinfo bAa = null;
    private PrivatePopInfo bAb = null;
    private PrivateForumInfo bAc = null;
    private Integer bAd = null;

    public PrivateForumShareinfo XO() {
        return this.bAa;
    }

    public PrivatePopInfo getPrivatePopInfo() {
        return this.bAb;
    }

    public PrivateForumInfo XP() {
        return this.bAc;
    }

    public Integer XQ() {
        return this.bAd;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.bAa = privateForumTotalInfo.private_forum_shareinfo;
                this.bAc = privateForumTotalInfo.private_forum_info;
                this.bAd = privateForumTotalInfo.private_forum_taskpercent;
                this.bAb = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
