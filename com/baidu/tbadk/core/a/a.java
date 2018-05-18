package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a UU = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0083a {
        void a(AccountData accountData);

        void c(String str, int i, String str2);

        void cE(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String vb = null;
        public String UV = null;
        public String UW = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0083a interfaceC0083a);

    public abstract b cD(String str);

    public abstract void qf();

    public static a qe() {
        return UU;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (UU == null && (runTask = MessageManager.getInstance().runTask(2001293, a.class)) != null && runTask.getData() != null) {
            UU = (a) runTask.getData();
        }
    }
}
