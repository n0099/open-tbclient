package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public abstract class a {
    public static a TC = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0040a {
        void a(AccountData accountData);

        void c(String str, int i, String str2);

        void cd(String str);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String ws = null;
        public String TD = null;
        public String TE = null;
    }

    public abstract void a(String str, String str2, String str3, InterfaceC0040a interfaceC0040a);

    public abstract b cc(String str);

    public abstract AccountData j(String str, String str2, String str3);

    public abstract void rb();

    public static a ra() {
        return TC;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (TC == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            TC = (a) runTask.getData();
        }
    }
}
