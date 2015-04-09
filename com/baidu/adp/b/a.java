package com.baidu.adp.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.a.b.a.a.i;
/* loaded from: classes.dex */
public abstract class a extends i {
    private static volatile a EY = null;

    public abstract void b(String str, long j, long j2);

    public static a lX() {
        CustomResponsedMessage runTask;
        if (EY == null) {
            synchronized (a.class) {
                if (EY == null && (runTask = MessageManager.getInstance().runTask(2000995, a.class)) != null && runTask.getData() != null) {
                    EY = (a) runTask.getData();
                }
            }
        }
        return EY;
    }
}
