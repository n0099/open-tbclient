package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class at {
    private PrivateForumShareinfo bHm = null;
    private PrivatePopInfo bHn = null;
    private PrivateForumInfo bHo = null;
    private Integer bHp = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.bHn;
    }

    public PrivateForumInfo acw() {
        return this.bHo;
    }

    public Integer acx() {
        return this.bHp;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.bHm = privateForumTotalInfo.private_forum_shareinfo;
                this.bHo = privateForumTotalInfo.private_forum_info;
                this.bHp = privateForumTotalInfo.private_forum_taskpercent;
                this.bHn = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
