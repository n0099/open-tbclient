package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class q {
    public static q dTg = null;

    public abstract com.baidu.tbadk.core.data.p getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.p pVar);

    public static q getInstance() {
        if (dTg == null) {
            synchronized (q.class) {
                if (dTg == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, q.class);
                    if (runTask != null && runTask.getData() != null) {
                        dTg = (q) runTask.getData();
                    }
                    return dTg;
                }
            }
        }
        return dTg;
    }
}
