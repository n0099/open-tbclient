package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class r {
    public static r Zu = null;

    public abstract com.baidu.tbadk.core.data.k getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.k kVar);

    public static r getInstance() {
        if (Zu == null) {
            synchronized (r.class) {
                if (Zu == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, r.class);
                    if (runTask != null && runTask.getData() != null) {
                        Zu = (r) runTask.getData();
                    }
                    return Zu;
                }
            }
        }
        return Zu;
    }
}
