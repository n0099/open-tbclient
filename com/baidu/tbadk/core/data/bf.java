package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class bf {
    private PrivateForumShareinfo eRv = null;
    private PrivatePopInfo eRw = null;
    private PrivateForumInfo eRx = null;
    private Integer eRy = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.eRw;
    }

    public PrivateForumInfo bqn() {
        return this.eRx;
    }

    public Integer bqo() {
        return this.eRy;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.eRv = privateForumTotalInfo.private_forum_shareinfo;
                this.eRx = privateForumTotalInfo.private_forum_info;
                this.eRy = privateForumTotalInfo.private_forum_taskpercent;
                this.eRw = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
