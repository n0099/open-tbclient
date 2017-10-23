package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {
    public static a ST = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0044a {
        void a(AccountData accountData);

        void c(String str, int i, String str2);

        void co(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String wt = null;
        public String SU = null;
        public String SV = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0044a interfaceC0044a);

    public abstract b cn(String str);

    public abstract AccountData f(String str, String str2, String str3, String str4);

    public abstract void oV();

    public static a oU() {
        return ST;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (ST == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            ST = (a) runTask.getData();
        }
    }
}
