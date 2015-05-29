package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public abstract class r {
    public static r TY = null;

    public abstract com.baidu.tbadk.core.data.h getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.h hVar);

    public static r getInstance() {
        if (TY == null) {
            synchronized (r.class) {
                if (TY == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016101, r.class);
                    if (runTask != null && runTask.getData() != null) {
                        TY = (r) runTask.getData();
                    }
                    return TY;
                }
            }
        }
        return TY;
    }
}
