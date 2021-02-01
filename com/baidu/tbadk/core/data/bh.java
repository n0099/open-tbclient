package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class bh {
    private PrivateForumShareinfo eOW = null;
    private PrivatePopInfo eOX = null;
    private PrivateForumInfo eOY = null;
    private Integer eOZ = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.eOX;
    }

    public PrivateForumInfo bmM() {
        return this.eOY;
    }

    public Integer bmN() {
        return this.eOZ;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.eOW = privateForumTotalInfo.private_forum_shareinfo;
                this.eOY = privateForumTotalInfo.private_forum_info;
                this.eOZ = privateForumTotalInfo.private_forum_taskpercent;
                this.eOX = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
