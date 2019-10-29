package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class at {
    private PrivateForumShareinfo cat = null;
    private PrivatePopInfo cau = null;
    private PrivateForumInfo cav = null;
    private Integer caw = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.cau;
    }

    public PrivateForumInfo ahH() {
        return this.cav;
    }

    public Integer ahI() {
        return this.caw;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.cat = privateForumTotalInfo.private_forum_shareinfo;
                this.cav = privateForumTotalInfo.private_forum_info;
                this.caw = privateForumTotalInfo.private_forum_taskpercent;
                this.cau = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
