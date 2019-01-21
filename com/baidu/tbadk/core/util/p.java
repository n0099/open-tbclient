package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public abstract class p {
    public static p aAI = null;

    public abstract com.baidu.tbadk.core.data.k getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.k kVar);

    public static p getInstance() {
        if (aAI == null) {
            synchronized (p.class) {
                if (aAI == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016101, p.class);
                    if (runTask != null && runTask.getData() != null) {
                        aAI = (p) runTask.getData();
                    }
                    return aAI;
                }
            }
        }
        return aAI;
    }
}
