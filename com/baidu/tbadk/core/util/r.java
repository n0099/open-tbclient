package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class r {
    public static r dZz = null;

    public abstract com.baidu.tbadk.core.data.p getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.p pVar);

    public static r getInstance() {
        if (dZz == null) {
            synchronized (r.class) {
                if (dZz == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, r.class);
                    if (runTask != null && runTask.getData() != null) {
                        dZz = (r) runTask.getData();
                    }
                    return dZz;
                }
            }
        }
        return dZz;
    }
}
