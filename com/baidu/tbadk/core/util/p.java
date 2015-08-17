package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class p {
    public static p Zb = null;

    public abstract com.baidu.tbadk.core.data.f getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.f fVar);

    public static p getInstance() {
        if (Zb == null) {
            synchronized (p.class) {
                if (Zb == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, p.class);
                    if (runTask != null && runTask.getData() != null) {
                        Zb = (p) runTask.getData();
                    }
                    return Zb;
                }
            }
        }
        return Zb;
    }
}
