package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.h0.r.q.r;
/* loaded from: classes.dex */
public abstract class ICDNProblemUploader {
    public static ICDNProblemUploader problemUploader;

    public static ICDNProblemUploader getInstance() {
        if (problemUploader == null) {
            synchronized (ICDNProblemUploader.class) {
                if (problemUploader == null) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016101, ICDNProblemUploader.class);
                    if (runTask != null && runTask.getData() != null) {
                        problemUploader = (ICDNProblemUploader) runTask.getData();
                    }
                    return problemUploader;
                }
            }
        }
        return problemUploader;
    }

    public abstract r getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(r rVar);
}
