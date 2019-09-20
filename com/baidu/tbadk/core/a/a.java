package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a bEf = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0248a {
        void a(AccountData accountData);

        void h(String str, int i, String str2);

        void mm(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String BY = null;
        public String bEg = null;
        public String bEh = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0248a interfaceC0248a);

    public abstract void ack();

    public abstract b ml(String str);

    public static a acj() {
        return bEf;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (bEf == null && (runTask = MessageManager.getInstance().runTask(2001293, a.class)) != null && runTask.getData() != null) {
            bEf = (a) runTask.getData();
        }
    }
}
