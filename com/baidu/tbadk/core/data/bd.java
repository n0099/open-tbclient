package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class bd {
    private PrivateForumShareinfo enY = null;
    private PrivatePopInfo enZ = null;
    private PrivateForumInfo eoa = null;
    private Integer eob = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.enZ;
    }

    public PrivateForumInfo bhe() {
        return this.eoa;
    }

    public Integer bhf() {
        return this.eob;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.enY = privateForumTotalInfo.private_forum_shareinfo;
                this.eoa = privateForumTotalInfo.private_forum_info;
                this.eob = privateForumTotalInfo.private_forum_taskpercent;
                this.enZ = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
