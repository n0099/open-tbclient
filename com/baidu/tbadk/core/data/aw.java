package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class aw {
    private PrivateForumShareinfo dDF = null;
    private PrivatePopInfo dDG = null;
    private PrivateForumInfo dDH = null;
    private Integer dDI = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.dDG;
    }

    public PrivateForumInfo aPA() {
        return this.dDH;
    }

    public Integer aPB() {
        return this.dDI;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.dDF = privateForumTotalInfo.private_forum_shareinfo;
                this.dDH = privateForumTotalInfo.private_forum_info;
                this.dDI = privateForumTotalInfo.private_forum_taskpercent;
                this.dDG = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
