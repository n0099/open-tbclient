package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class aw {
    private PrivateForumShareinfo dpG = null;
    private PrivatePopInfo dpH = null;
    private PrivateForumInfo dpI = null;
    private Integer dpJ = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.dpH;
    }

    public PrivateForumInfo aJF() {
        return this.dpI;
    }

    public Integer aJG() {
        return this.dpJ;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.dpG = privateForumTotalInfo.private_forum_shareinfo;
                this.dpI = privateForumTotalInfo.private_forum_info;
                this.dpJ = privateForumTotalInfo.private_forum_taskpercent;
                this.dpH = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
