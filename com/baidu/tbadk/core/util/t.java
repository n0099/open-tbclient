package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class t {
    public static t ael = null;

    public abstract com.baidu.tbadk.core.data.m getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.m mVar);

    public static t getInstance() {
        if (ael == null) {
            synchronized (t.class) {
                if (ael == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, t.class);
                    if (runTask != null && runTask.getData() != null) {
                        ael = (t) runTask.getData();
                    }
                    return ael;
                }
            }
        }
        return ael;
    }
}
