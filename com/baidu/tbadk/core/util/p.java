package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public abstract class p {
    public static p aVb = null;

    public abstract com.baidu.tbadk.core.data.k getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.k kVar);

    public static p getInstance() {
        if (aVb == null) {
            synchronized (p.class) {
                if (aVb == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016101, p.class);
                    if (runTask != null && runTask.getData() != null) {
                        aVb = (p) runTask.getData();
                    }
                    return aVb;
                }
            }
        }
        return aVb;
    }
}
