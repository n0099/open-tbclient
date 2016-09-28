package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {
    public static a Os = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0033a {
        void a(AccountData accountData);

        void b(String str, int i, String str2);

        void cf(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String pX = null;
        public String Ot = null;
        public String Ou = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0033a interfaceC0033a);

    public abstract b ce(String str);

    public abstract AccountData h(String str, String str2, String str3, String str4);

    public abstract void oQ();

    public static a oP() {
        return Os;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (Os == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            Os = (a) runTask.getData();
        }
    }
}
