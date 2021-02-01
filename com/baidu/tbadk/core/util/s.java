package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class s {
    public static s eZI = null;

    public abstract com.baidu.tbadk.core.data.r getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.r rVar);

    public static s getInstance() {
        if (eZI == null) {
            synchronized (s.class) {
                if (eZI == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, s.class);
                    if (runTask != null && runTask.getData() != null) {
                        eZI = (s) runTask.getData();
                    }
                    return eZI;
                }
            }
        }
        return eZI;
    }
}
