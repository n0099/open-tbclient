package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class bf {
    private PrivateForumShareinfo eMK = null;
    private PrivatePopInfo eML = null;
    private PrivateForumInfo eMM = null;
    private Integer eMN = null;

    public PrivatePopInfo getPrivatePopInfo() {
        return this.eML;
    }

    public PrivateForumInfo bmt() {
        return this.eMM;
    }

    public Integer bmu() {
        return this.eMN;
    }

    public void a(PrivateForumTotalInfo privateForumTotalInfo) {
        if (privateForumTotalInfo != null) {
            try {
                this.eMK = privateForumTotalInfo.private_forum_shareinfo;
                this.eMM = privateForumTotalInfo.private_forum_info;
                this.eMN = privateForumTotalInfo.private_forum_taskpercent;
                this.eML = privateForumTotalInfo.private_forum_popinfo;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
