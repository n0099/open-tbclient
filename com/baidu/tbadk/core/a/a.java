package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a acB = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0098a {
        void a(AccountData accountData);

        void b(String str, int i, String str2);

        void dc(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String Be = null;
        public String acC = null;
        public String acD = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0098a interfaceC0098a);

    public abstract b db(String str);

    public abstract void tl();

    public static a tk() {
        return acB;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (acB == null && (runTask = MessageManager.getInstance().runTask(2001293, a.class)) != null && runTask.getData() != null) {
            acB = (a) runTask.getData();
        }
    }
}
