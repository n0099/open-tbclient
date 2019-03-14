package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a bvC = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0222a {
        void a(AccountData accountData);

        void e(String str, int i, String str2);

        void kV(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String Ek = null;
        public String bvD = null;
        public String bvE = null;
    }

    public abstract void WE();

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0222a interfaceC0222a);

    public abstract b kU(String str);

    public static a WD() {
        return bvC;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (bvC == null && (runTask = MessageManager.getInstance().runTask(2001293, a.class)) != null && runTask.getData() != null) {
            bvC = (a) runTask.getData();
        }
    }
}
