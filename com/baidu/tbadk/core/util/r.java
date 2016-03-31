package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class r {
    public static r aai = null;

    public abstract com.baidu.tbadk.core.data.j getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.j jVar);

    public static r getInstance() {
        if (aai == null) {
            synchronized (r.class) {
                if (aai == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, r.class);
                    if (runTask != null && runTask.getData() != null) {
                        aai = (r) runTask.getData();
                    }
                    return aai;
                }
            }
        }
        return aai;
    }
}
