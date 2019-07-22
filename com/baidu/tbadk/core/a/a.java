package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a bDH = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0234a {
        void a(AccountData accountData);

        void h(String str, int i, String str2);

        void mk(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String BY = null;
        public String bDI = null;
        public String bDJ = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0234a interfaceC0234a);

    public abstract void acg();

    public abstract b mj(String str);

    public static a acf() {
        return bDH;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (bDH == null && (runTask = MessageManager.getInstance().runTask(2001293, a.class)) != null && runTask.getData() != null) {
            bDH = (a) runTask.getData();
        }
    }
}
