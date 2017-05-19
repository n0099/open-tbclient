package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {
    public static a St = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0035a {
        void a(AccountData accountData);

        void b(String str, int i, String str2);

        void cf(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String mBduss = null;
        public String Su = null;
        public String Sv = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0035a interfaceC0035a);

    public abstract b ce(String str);

    public abstract AccountData h(String str, String str2, String str3, String str4);

    public abstract void pe();

    public static a pd() {
        return St;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (St == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            St = (a) runTask.getData();
        }
    }
}
