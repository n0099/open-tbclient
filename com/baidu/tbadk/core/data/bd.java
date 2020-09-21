package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class bd {
    private PrivateForumShareinfo ebU = null;
    private PrivatePopInfo ebV = null;
    private PrivateForumInfo ebW = null;
    private Integer ebX = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.ebV;
    }

    public PrivateForumInfo bev() {
        return this.ebW;
    }

    public Integer bew() {
        return this.ebX;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.ebU = privateForumTotalInfo.private_forum_shareinfo;
                this.ebW = privateForumTotalInfo.private_forum_info;
                this.ebX = privateForumTotalInfo.private_forum_taskpercent;
                this.ebV = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
