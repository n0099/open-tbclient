package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class aw {
    private PrivateForumShareinfo cMe = null;
    private PrivatePopInfo cMf = null;
    private PrivateForumInfo cMg = null;
    private Integer cMh = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.cMf;
    }

    public PrivateForumInfo ayY() {
        return this.cMg;
    }

    public Integer ayZ() {
        return this.cMh;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.cMe = privateForumTotalInfo.private_forum_shareinfo;
                this.cMg = privateForumTotalInfo.private_forum_info;
                this.cMh = privateForumTotalInfo.private_forum_taskpercent;
                this.cMf = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
