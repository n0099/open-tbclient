package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {
    public static a TP = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0040a {
        void a(AccountData accountData);

        void c(String str, int i, String str2);

        void cb(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String wt = null;
        public String TQ = null;
        public String TR = null;
    }

    public abstract void a(String str, String str2, String str3, InterfaceC0040a interfaceC0040a);

    public abstract b ca(String str);

    public abstract AccountData j(String str, String str2, String str3);

    public abstract void rk();

    public static a rj() {
        return TP;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (TP == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            TP = (a) runTask.getData();
        }
    }
}
