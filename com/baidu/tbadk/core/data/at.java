package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class at {
    private PrivateForumShareinfo bZC = null;
    private PrivatePopInfo bZD = null;
    private PrivateForumInfo bZE = null;
    private Integer bZF = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.bZD;
    }

    public PrivateForumInfo ahF() {
        return this.bZE;
    }

    public Integer ahG() {
        return this.bZF;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.bZC = privateForumTotalInfo.private_forum_shareinfo;
                this.bZE = privateForumTotalInfo.private_forum_info;
                this.bZF = privateForumTotalInfo.private_forum_taskpercent;
                this.bZD = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
