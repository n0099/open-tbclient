package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes2.dex */
public class bd {
    private PrivateForumShareinfo dZG = null;
    private PrivatePopInfo dZH = null;
    private PrivateForumInfo dZI = null;
    private Integer dZJ = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.dZH;
    }

    public PrivateForumInfo bdB() {
        return this.dZI;
    }

    public Integer bdC() {
        return this.dZJ;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.dZG = privateForumTotalInfo.private_forum_shareinfo;
                this.dZI = privateForumTotalInfo.private_forum_info;
                this.dZJ = privateForumTotalInfo.private_forum_taskpercent;
                this.dZH = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
