package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a aoQ = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0155a {
        void a(AccountData accountData);

        void b(String str, int i, String str2);

        void el(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String El = null;
        public String aoR = null;
        public String aoS = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0155a interfaceC0155a);

    public abstract b ek(String str);

    public abstract void xX();

    public static a xW() {
        return aoQ;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (aoQ == null && (runTask = MessageManager.getInstance().runTask(2001293, a.class)) != null && runTask.getData() != null) {
            aoQ = (a) runTask.getData();
        }
    }
}
