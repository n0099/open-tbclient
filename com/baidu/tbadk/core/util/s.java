package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class s {
    public static s fbh = null;

    public abstract com.baidu.tbadk.core.data.r getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(com.baidu.tbadk.core.data.r rVar);

    public static s getInstance() {
        if (fbh == null) {
            synchronized (s.class) {
                if (fbh == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, s.class);
                    if (runTask != null && runTask.getData() != null) {
                        fbh = (s) runTask.getData();
                    }
                    return fbh;
                }
            }
        }
        return fbh;
    }
}
