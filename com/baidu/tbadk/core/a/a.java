package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public abstract class a {
    public static a bVh = null;

    /* renamed from: com.baidu.tbadk.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0280a {
        void a(AccountData accountData);

        void onBeforeLogin(String str);

        void onFailure(String str, int i, String str2);
    }

    /* loaded from: classes.dex */
    public static class b {
        public String mBduss = null;
        public String mPtoken = null;
        public String mUsername = null;
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC0280a interfaceC0280a);

    public abstract b mJ(String str);

    public abstract void reLoginByCacheAccount();

    public static a agp() {
        return bVh;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (bVh == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.class)) != null && runTask.getData() != null) {
            bVh = (a) runTask.getData();
        }
    }
}
