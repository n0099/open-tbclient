package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {
    public static a TR = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0057a {
        void a(AccountData accountData);

        void c(String str, int i, String str2);

        void cu(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String wr = null;
        public String TS = null;
        public String TT = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0057a interfaceC0057a);

    public abstract b ct(String str);

    public abstract void pg();

    public static a pf() {
        return TR;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (TR == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            TR = (a) runTask.getData();
        }
    }
}
