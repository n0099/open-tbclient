package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public abstract class q {
    public static q aoE = null;

    public abstract com.baidu.tbadk.core.data.k getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.k kVar);

    public static q getInstance() {
        if (aoE == null) {
            synchronized (q.class) {
                if (aoE == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016101, q.class);
                    if (runTask != null && runTask.getData() != null) {
                        aoE = (q) runTask.getData();
                    }
                    return aoE;
                }
            }
        }
        return aoE;
    }
}
