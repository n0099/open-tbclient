package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class aw {
    private PrivateForumShareinfo cQi = null;
    private PrivatePopInfo cQj = null;
    private PrivateForumInfo cQk = null;
    private Integer cQl = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.cQj;
    }

    public PrivateForumInfo aBr() {
        return this.cQk;
    }

    public Integer aBs() {
        return this.cQl;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.cQi = privateForumTotalInfo.private_forum_shareinfo;
                this.cQk = privateForumTotalInfo.private_forum_info;
                this.cQl = privateForumTotalInfo.private_forum_taskpercent;
                this.cQj = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
