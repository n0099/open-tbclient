package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public abstract class p {
    public static p bRr = null;

    public abstract com.baidu.tbadk.core.data.m getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.m mVar);

    public static p getInstance() {
        if (bRr == null) {
            synchronized (p.class) {
                if (bRr == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016101, p.class);
                    if (runTask != null && runTask.getData() != null) {
                        bRr = (p) runTask.getData();
                    }
                    return bRr;
                }
            }
        }
        return bRr;
    }
}
