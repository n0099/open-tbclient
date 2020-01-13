package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class p {
    public static p cUC = null;

    public abstract com.baidu.tbadk.core.data.n getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.n nVar);

    public static p getInstance() {
        if (cUC == null) {
            synchronized (p.class) {
                if (cUC == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, p.class);
                    if (runTask != null && runTask.getData() != null) {
                        cUC = (p) runTask.getData();
                    }
                    return cUC;
                }
            }
        }
        return cUC;
    }
}
