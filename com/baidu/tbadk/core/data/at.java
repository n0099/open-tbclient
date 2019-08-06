package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class at {
    private PrivateForumShareinfo bIo = null;
    private PrivatePopInfo bIp = null;
    private PrivateForumInfo bIq = null;
    private Integer bIr = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.bIp;
    }

    public PrivateForumInfo adz() {
        return this.bIq;
    }

    public Integer adA() {
        return this.bIr;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.bIo = privateForumTotalInfo.private_forum_shareinfo;
                this.bIq = privateForumTotalInfo.private_forum_info;
                this.bIr = privateForumTotalInfo.private_forum_taskpercent;
                this.bIp = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
