package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class be {
    private PrivateForumShareinfo eAF = null;
    private PrivatePopInfo eAG = null;
    private PrivateForumInfo eAH = null;
    private Integer eAI = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.eAG;
    }

    public PrivateForumInfo bkz() {
        return this.eAH;
    }

    public Integer bkA() {
        return this.eAI;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.eAF = privateForumTotalInfo.private_forum_shareinfo;
                this.eAH = privateForumTotalInfo.private_forum_info;
                this.eAI = privateForumTotalInfo.private_forum_taskpercent;
                this.eAG = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
