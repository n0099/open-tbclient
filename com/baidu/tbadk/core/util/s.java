package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class s {
    public static s aaA = null;

    public abstract com.baidu.tbadk.core.data.f getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.f fVar);

    public static s getInstance() {
        if (aaA == null) {
            synchronized (s.class) {
                if (aaA == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, s.class);
                    if (runTask != null && runTask.getData() != null) {
                        aaA = (s) runTask.getData();
                    }
                    return aaA;
                }
            }
        }
        return aaA;
    }
}
