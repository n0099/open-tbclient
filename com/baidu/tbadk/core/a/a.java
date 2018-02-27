package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a aJB = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0094a {
        void a(AccountData accountData);

        void c(String str, int i, String str2);

        void cM(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String aky = null;
        public String aJC = null;
        public String aJD = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0094a interfaceC0094a);

    public abstract b cL(String str);

    public abstract void xw();

    public static a xv() {
        return aJB;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (aJB == null && (runTask = MessageManager.getInstance().runTask(2001293, a.class)) != null && runTask.getData() != null) {
            aJB = (a) runTask.getData();
        }
    }
}
