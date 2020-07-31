package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class bc {
    private PrivateForumShareinfo dQn = null;
    private PrivatePopInfo dQo = null;
    private PrivateForumInfo dQp = null;
    private Integer dQq = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.dQo;
    }

    public PrivateForumInfo aVi() {
        return this.dQp;
    }

    public Integer aVj() {
        return this.dQq;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.dQn = privateForumTotalInfo.private_forum_shareinfo;
                this.dQp = privateForumTotalInfo.private_forum_info;
                this.dQq = privateForumTotalInfo.private_forum_taskpercent;
                this.dQo = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
