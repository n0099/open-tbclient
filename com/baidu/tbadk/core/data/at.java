package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class at {
    private PrivateForumShareinfo bIn = null;
    private PrivatePopInfo bIo = null;
    private PrivateForumInfo bIp = null;
    private Integer bIq = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.bIo;
    }

    public PrivateForumInfo ady() {
        return this.bIp;
    }

    public Integer adz() {
        return this.bIq;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.bIn = privateForumTotalInfo.private_forum_shareinfo;
                this.bIp = privateForumTotalInfo.private_forum_info;
                this.bIq = privateForumTotalInfo.private_forum_taskpercent;
                this.bIo = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
