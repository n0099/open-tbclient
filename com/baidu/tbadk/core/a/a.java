package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {
    public static a Sb = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0037a {
        void a(AccountData accountData);

        void b(String str, int i, String str2);

        void cl(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String mBduss = null;
        public String Sc = null;
        public String Sd = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0037a interfaceC0037a);

    public abstract b ck(String str);

    public abstract AccountData h(String str, String str2, String str3, String str4);

    public abstract void oT();

    public static a oS() {
        return Sb;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (Sb == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            Sb = (a) runTask.getData();
        }
    }
}
