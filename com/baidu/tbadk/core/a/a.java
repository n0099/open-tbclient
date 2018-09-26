package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a afc = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0097a {
        void a(AccountData accountData);

        void b(String str, int i, String str2);

        void du(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String Dy = null;
        public String afd = null;
        public String afe = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0097a interfaceC0097a);

    public abstract b dt(String str);

    public abstract void up();

    public static a uo() {
        return afc;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (afc == null && (runTask = MessageManager.getInstance().runTask(2001293, a.class)) != null && runTask.getData() != null) {
            afc = (a) runTask.getData();
        }
    }
}
