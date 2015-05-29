package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a Pb = null;

    public abstract void a(String str, String str2, String str3, b bVar);

    public abstract c ca(String str);

    public abstract AccountData h(String str, String str2, String str3);

    public abstract void qj();

    public static a qi() {
        return Pb;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (Pb == null && (runTask = MessageManager.getInstance().runTask(2001300, a.class)) != null && runTask.getData() != null) {
            Pb = (a) runTask.getData();
        }
    }
}
