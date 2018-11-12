package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a akM = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0145a {
        void a(AccountData accountData);

        void b(String str, int i, String str2);

        void dK(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String El = null;
        public String akN = null;
        public String akO = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0145a interfaceC0145a);

    public abstract b dJ(String str);

    public abstract void wG();

    public static a wF() {
        return akM;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (akM == null && (runTask = MessageManager.getInstance().runTask(2001293, a.class)) != null && runTask.getData() != null) {
            akM = (a) runTask.getData();
        }
    }
}
