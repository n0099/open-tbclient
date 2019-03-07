package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class at {
    private PrivateForumShareinfo bzU = null;
    private PrivatePopInfo bzV = null;
    private PrivateForumInfo bzW = null;
    private Integer bzX = null;

    public PrivateForumShareinfo XR() {
        return this.bzU;
    }

    public PrivatePopInfo getPrivatePopInfo() {
        return this.bzV;
    }

    public PrivateForumInfo XS() {
        return this.bzW;
    }

    public Integer XT() {
        return this.bzX;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.bzU = privateForumTotalInfo.private_forum_shareinfo;
                this.bzW = privateForumTotalInfo.private_forum_info;
                this.bzX = privateForumTotalInfo.private_forum_taskpercent;
                this.bzV = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
