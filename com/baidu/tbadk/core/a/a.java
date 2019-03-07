package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a bvA = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0188a {
        void a(AccountData accountData);

        void e(String str, int i, String str2);

        void kV(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String Ek = null;
        public String bvB = null;
        public String bvC = null;
    }

    public abstract void WE();

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0188a interfaceC0188a);

    public abstract b kU(String str);

    public static a WD() {
        return bvA;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (bvA == null && (runTask = MessageManager.getInstance().runTask(2001293, a.class)) != null && runTask.getData() != null) {
            bvA = (a) runTask.getData();
        }
    }
}
