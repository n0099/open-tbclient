package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class aw {
    private PrivateForumShareinfo cLU = null;
    private PrivatePopInfo cLV = null;
    private PrivateForumInfo cLW = null;
    private Integer cLX = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.cLV;
    }

    public PrivateForumInfo ayF() {
        return this.cLW;
    }

    public Integer ayG() {
        return this.cLX;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.cLU = privateForumTotalInfo.private_forum_shareinfo;
                this.cLW = privateForumTotalInfo.private_forum_info;
                this.cLX = privateForumTotalInfo.private_forum_taskpercent;
                this.cLV = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
