package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a acT = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0100a {
        void a(AccountData accountData);

        void c(String str, int i, String str2);

        void dc(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String Bg = null;
        public String acU = null;
        public String acV = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0100a interfaceC0100a);

    public abstract b db(String str);

    public abstract void tB();

    public static a tA() {
        return acT;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (acT == null && (runTask = MessageManager.getInstance().runTask(2001293, a.class)) != null && runTask.getData() != null) {
            acT = (a) runTask.getData();
        }
    }
}
