package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class at {
    private PrivateForumShareinfo bzW = null;
    private PrivatePopInfo bzX = null;
    private PrivateForumInfo bzY = null;
    private Integer bzZ = null;

    public PrivateForumShareinfo XR() {
        return this.bzW;
    }

    public PrivatePopInfo getPrivatePopInfo() {
        return this.bzX;
    }

    public PrivateForumInfo XS() {
        return this.bzY;
    }

    public Integer XT() {
        return this.bzZ;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.bzW = privateForumTotalInfo.private_forum_shareinfo;
                this.bzY = privateForumTotalInfo.private_forum_info;
                this.bzZ = privateForumTotalInfo.private_forum_taskpercent;
                this.bzX = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
