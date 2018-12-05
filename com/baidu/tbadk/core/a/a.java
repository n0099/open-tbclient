package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a aoo = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0155a {
        void a(AccountData accountData);

        void b(String str, int i, String str2);

        void ec(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String El = null;
        public String aop = null;
        public String aoq = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0155a interfaceC0155a);

    public abstract b eb(String str);

    public abstract void xK();

    public static a xJ() {
        return aoo;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (aoo == null && (runTask = MessageManager.getInstance().runTask(2001293, a.class)) != null && runTask.getData() != null) {
            aoo = (a) runTask.getData();
        }
    }
}
