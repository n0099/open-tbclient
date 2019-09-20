package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class at {
    private PrivateForumShareinfo bIM = null;
    private PrivatePopInfo bIN = null;
    private PrivateForumInfo bIO = null;
    private Integer bIP = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.bIN;
    }

    public PrivateForumInfo adD() {
        return this.bIO;
    }

    public Integer adE() {
        return this.bIP;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.bIM = privateForumTotalInfo.private_forum_shareinfo;
                this.bIO = privateForumTotalInfo.private_forum_info;
                this.bIP = privateForumTotalInfo.private_forum_taskpercent;
                this.bIN = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
