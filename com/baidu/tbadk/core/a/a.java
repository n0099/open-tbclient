package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a acW = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0101a {
        void a(AccountData accountData);

        void c(String str, int i, String str2);

        void de(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String Bi = null;
        public String acX = null;
        public String acY = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0101a interfaceC0101a);

    public abstract b dd(String str);

    public abstract void tB();

    public static a tA() {
        return acW;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (acW == null && (runTask = MessageManager.getInstance().runTask(2001293, a.class)) != null && runTask.getData() != null) {
            acW = (a) runTask.getData();
        }
    }
}
