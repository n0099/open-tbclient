package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class bf {
    private PrivateForumShareinfo eHE = null;
    private PrivatePopInfo eHF = null;
    private PrivateForumInfo eHG = null;
    private Integer eHH = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.eHF;
    }

    public PrivateForumInfo bnM() {
        return this.eHG;
    }

    public Integer bnN() {
        return this.eHH;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.eHE = privateForumTotalInfo.private_forum_shareinfo;
                this.eHG = privateForumTotalInfo.private_forum_info;
                this.eHH = privateForumTotalInfo.private_forum_taskpercent;
                this.eHF = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
