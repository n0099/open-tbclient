package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public abstract class q {
    public static q aoD = null;

    public abstract com.baidu.tbadk.core.data.l getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.l lVar);

    public static q getInstance() {
        if (aoD == null) {
            synchronized (q.class) {
                if (aoD == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016101, q.class);
                    if (runTask != null && runTask.getData() != null) {
                        aoD = (q) runTask.getData();
                    }
                    return aoD;
                }
            }
        }
        return aoD;
    }
}
