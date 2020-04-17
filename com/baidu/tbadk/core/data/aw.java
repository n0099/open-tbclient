package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class aw {
    private PrivateForumShareinfo dpC = null;
    private PrivatePopInfo dpD = null;
    private PrivateForumInfo dpE = null;
    private Integer dpF = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.dpD;
    }

    public PrivateForumInfo aJH() {
        return this.dpE;
    }

    public Integer aJI() {
        return this.dpF;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.dpC = privateForumTotalInfo.private_forum_shareinfo;
                this.dpE = privateForumTotalInfo.private_forum_info;
                this.dpF = privateForumTotalInfo.private_forum_taskpercent;
                this.dpD = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
