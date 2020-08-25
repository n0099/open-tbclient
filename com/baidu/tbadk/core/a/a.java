package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes2.dex */
public abstract class a {
    public static a dUI = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0536a {
        void a(AccountData accountData);

        void onBeforeLogin(String str);

        void onFailure(String str, int i, String str2);
    }

    /* loaded from: classes2.dex */
    public static class b {
        public String mBduss = null;
        public String mPtoken = null;
        public String mUsername = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0536a interfaceC0536a);

    public abstract void reLoginByCacheAccount();

    public abstract b yM(String str);

    public static a bbN() {
        return dUI;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (dUI == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            dUI = (a) runTask.getData();
        }
    }
}
