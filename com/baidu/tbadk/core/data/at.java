package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class at {
    private PrivateForumShareinfo bHn = null;
    private PrivatePopInfo bHo = null;
    private PrivateForumInfo bHp = null;
    private Integer bHq = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.bHo;
    }

    public PrivateForumInfo acw() {
        return this.bHp;
    }

    public Integer acx() {
        return this.bHq;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.bHn = privateForumTotalInfo.private_forum_shareinfo;
                this.bHp = privateForumTotalInfo.private_forum_info;
                this.bHq = privateForumTotalInfo.private_forum_taskpercent;
                this.bHo = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
