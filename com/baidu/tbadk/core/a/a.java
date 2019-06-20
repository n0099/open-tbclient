package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a bCK = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0237a {
        void a(AccountData accountData);

        void h(String str, int i, String str2);

        void ma(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String BS = null;
        public String bCL = null;
        public String bCM = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0237a interfaceC0237a);

    public abstract void abh();

    public abstract b lZ(String str);

    public static a abg() {
        return bCK;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (bCK == null && (runTask = MessageManager.getInstance().runTask(2001293, a.class)) != null && runTask.getData() != null) {
            bCK = (a) runTask.getData();
        }
    }
}
