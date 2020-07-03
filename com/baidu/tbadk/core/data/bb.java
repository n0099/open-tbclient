package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class bb {
    private PrivateForumShareinfo dKb = null;
    private PrivatePopInfo dKc = null;
    private PrivateForumInfo dKd = null;
    private Integer dKe = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.dKc;
    }

    public PrivateForumInfo aRm() {
        return this.dKd;
    }

    public Integer aRn() {
        return this.dKe;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.dKb = privateForumTotalInfo.private_forum_shareinfo;
                this.dKd = privateForumTotalInfo.private_forum_info;
                this.dKe = privateForumTotalInfo.private_forum_taskpercent;
                this.dKc = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
