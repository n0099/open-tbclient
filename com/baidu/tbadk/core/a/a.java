package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {
    public static a SR = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0043a {
        void a(AccountData accountData);

        void c(String str, int i, String str2);

        void cp(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String wq = null;
        public String SS = null;
        public String ST = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0043a interfaceC0043a);

    public abstract b co(String str);

    public abstract AccountData f(String str, String str2, String str3, String str4);

    public abstract void pb();

    public static a pa() {
        return SR;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (SR == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            SR = (a) runTask.getData();
        }
    }
}
