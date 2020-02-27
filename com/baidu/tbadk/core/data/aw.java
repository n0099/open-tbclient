package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class aw {
    private PrivateForumShareinfo cQh = null;
    private PrivatePopInfo cQi = null;
    private PrivateForumInfo cQj = null;
    private Integer cQk = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.cQi;
    }

    public PrivateForumInfo aBp() {
        return this.cQj;
    }

    public Integer aBq() {
        return this.cQk;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.cQh = privateForumTotalInfo.private_forum_shareinfo;
                this.cQj = privateForumTotalInfo.private_forum_info;
                this.cQk = privateForumTotalInfo.private_forum_taskpercent;
                this.cQi = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
