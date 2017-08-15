package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class o {
    public static o agd = null;

    public abstract com.baidu.tbadk.core.data.l getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.l lVar);

    public static o getInstance() {
        if (agd == null) {
            synchronized (o.class) {
                if (agd == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, o.class);
                    if (runTask != null && runTask.getData() != null) {
                        agd = (o) runTask.getData();
                    }
                    return agd;
                }
            }
        }
        return agd;
    }
}
