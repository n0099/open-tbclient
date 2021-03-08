package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class bh {
    private PrivateForumShareinfo eQx = null;
    private PrivatePopInfo eQy = null;
    private PrivateForumInfo eQz = null;
    private Integer eQA = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.eQy;
    }

    public PrivateForumInfo bmO() {
        return this.eQz;
    }

    public Integer bmP() {
        return this.eQA;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.eQx = privateForumTotalInfo.private_forum_shareinfo;
                this.eQz = privateForumTotalInfo.private_forum_info;
                this.eQA = privateForumTotalInfo.private_forum_taskpercent;
                this.eQy = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
