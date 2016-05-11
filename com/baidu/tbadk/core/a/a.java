package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {
    public static a Mf = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0033a {
        void a(AccountData accountData);

        void b(String str, int i, String str2);

        void ce(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String mZ = null;
        public String Mg = null;
        public String Mh = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, InterfaceC0033a interfaceC0033a);

    public abstract b cd(String str);

    public abstract AccountData l(String str, String str2, String str3);

    public abstract void ok();

    public static a oj() {
        return Mf;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (Mf == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            Mf = (a) runTask.getData();
        }
    }
}
