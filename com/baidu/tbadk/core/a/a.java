package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {
    public static a TT = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0042a {
        void a(AccountData accountData);

        void c(String str, int i, String str2);

        void cj(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String wJ = null;
        public String TU = null;
        public String TV = null;
    }

    public abstract void a(String str, String str2, String str3, InterfaceC0042a interfaceC0042a);

    public abstract b ci(String str);

    public abstract AccountData k(String str, String str2, String str3);

    public abstract void rw();

    public static a rv() {
        return TT;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (TT == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            TT = (a) runTask.getData();
        }
    }
}
