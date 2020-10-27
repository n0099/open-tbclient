package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class bd {
    private PrivateForumShareinfo eww = null;
    private PrivatePopInfo ewx = null;
    private PrivateForumInfo ewy = null;
    private Integer ewz = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.ewx;
    }

    public PrivateForumInfo biX() {
        return this.ewy;
    }

    public Integer biY() {
        return this.ewz;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.eww = privateForumTotalInfo.private_forum_shareinfo;
                this.ewy = privateForumTotalInfo.private_forum_info;
                this.ewz = privateForumTotalInfo.private_forum_taskpercent;
                this.ewx = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
