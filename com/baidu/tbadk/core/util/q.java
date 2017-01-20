package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class q {
    public static q YN = null;

    public abstract com.baidu.tbadk.core.data.m getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.m mVar);

    public static q getInstance() {
        if (YN == null) {
            synchronized (q.class) {
                if (YN == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, q.class);
                    if (runTask != null && runTask.getData() != null) {
                        YN = (q) runTask.getData();
                    }
                    return YN;
                }
            }
        }
        return YN;
    }
}
