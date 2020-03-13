package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class aw {
    private PrivateForumShareinfo cQj = null;
    private PrivatePopInfo cQk = null;
    private PrivateForumInfo cQl = null;
    private Integer cQm = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.cQk;
    }

    public PrivateForumInfo aBr() {
        return this.cQl;
    }

    public Integer aBs() {
        return this.cQm;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.cQj = privateForumTotalInfo.private_forum_shareinfo;
                this.cQl = privateForumTotalInfo.private_forum_info;
                this.cQm = privateForumTotalInfo.private_forum_taskpercent;
                this.cQk = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
