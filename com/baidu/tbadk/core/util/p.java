package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class p {
    public static p afw = null;

    public abstract com.baidu.tbadk.core.data.l getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.l lVar);

    public static p getInstance() {
        if (afw == null) {
            synchronized (p.class) {
                if (afw == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, p.class);
                    if (runTask != null && runTask.getData() != null) {
                        afw = (p) runTask.getData();
                    }
                    return afw;
                }
            }
        }
        return afw;
    }
}
