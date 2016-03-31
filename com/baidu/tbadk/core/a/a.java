package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {
    public static a Rp = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0042a {
        void a(AccountData accountData);

        void b(String str, int i, String str2);

        void cg(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String xa = null;
        public String Rq = null;
        public String Rr = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, InterfaceC0042a interfaceC0042a);

    public abstract b cf(String str);

    public abstract AccountData k(String str, String str2, String str3);

    public abstract void qN();

    public static a qM() {
        return Rp;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (Rp == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            Rp = (a) runTask.getData();
        }
    }
}
