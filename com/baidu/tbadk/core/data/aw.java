package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class aw {
    private PrivateForumShareinfo cQw = null;
    private PrivatePopInfo cQx = null;
    private PrivateForumInfo cQy = null;
    private Integer cQz = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.cQx;
    }

    public PrivateForumInfo aBu() {
        return this.cQy;
    }

    public Integer aBv() {
        return this.cQz;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.cQw = privateForumTotalInfo.private_forum_shareinfo;
                this.cQy = privateForumTotalInfo.private_forum_info;
                this.cQz = privateForumTotalInfo.private_forum_taskpercent;
                this.cQx = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
