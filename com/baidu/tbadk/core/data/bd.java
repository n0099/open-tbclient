package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class bd {
    private PrivateForumShareinfo eCo = null;
    private PrivatePopInfo eCp = null;
    private PrivateForumInfo eCq = null;
    private Integer eCr = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.eCp;
    }

    public PrivateForumInfo blx() {
        return this.eCq;
    }

    public Integer bly() {
        return this.eCr;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.eCo = privateForumTotalInfo.private_forum_shareinfo;
                this.eCq = privateForumTotalInfo.private_forum_info;
                this.eCr = privateForumTotalInfo.private_forum_taskpercent;
                this.eCp = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
