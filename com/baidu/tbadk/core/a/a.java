package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {
    public static a SG = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0031a {
        void a(AccountData accountData);

        void b(String str, int i, String str2);

        void bY(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String xo = null;
        public String SH = null;
        public String SI = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0031a interfaceC0031a);

    public abstract b bX(String str);

    public abstract AccountData h(String str, String str2, String str3, String str4);

    public abstract void oZ();

    public static a oY() {
        return SG;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (SG == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            SG = (a) runTask.getData();
        }
    }
}
