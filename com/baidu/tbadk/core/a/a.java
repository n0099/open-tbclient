package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {
    public static a TU = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0041a {
        void a(AccountData accountData);

        void c(String str, int i, String str2);

        void ci(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String wy = null;
        public String TV = null;
        public String TW = null;
    }

    public abstract void a(String str, String str2, String str3, InterfaceC0041a interfaceC0041a);

    public abstract b ch(String str);

    public abstract AccountData k(String str, String str2, String str3);

    public abstract void rq();

    public static a rp() {
        return TU;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (TU == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            TU = (a) runTask.getData();
        }
    }
}
