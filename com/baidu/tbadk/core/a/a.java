package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {
    public static a aIp = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070a {
        void a(AccountData accountData);

        void c(String str, int i, String str2);

        void cB(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String akC = null;
        public String aIq = null;
        public String aIr = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0070a interfaceC0070a);

    public abstract b cA(String str);

    public abstract void wI();

    public static a wH() {
        return aIp;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (aIp == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            aIp = (a) runTask.getData();
        }
    }
}
