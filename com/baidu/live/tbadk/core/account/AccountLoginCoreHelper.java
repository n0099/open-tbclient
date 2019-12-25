package com.baidu.live.tbadk.core.account;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public abstract class AccountLoginCoreHelper {
    public static AccountLoginCoreHelper mAccountLoginCoreHelper = null;

    /* loaded from: classes2.dex */
    public interface IReLoginCallback {
        void onBeforeLogin(String str);

        void onFailure(String str, int i, String str2);

        void onSuccess(AccountData accountData);
    }

    /* loaded from: classes2.dex */
    public static class OurToken {
        public String mBduss = null;
        public String mPtoken = null;
        public String mUsername = null;
    }

    public abstract BdAsyncTask<?, ?, ?> asyncReLogin(String str, String str2, String str3, String str4, IReLoginCallback iReLoginCallback);

    public abstract BdAsyncTask<?, ?, ?> asyncReLoginForTbduss(String str, String str2, String str3, String str4, IReLoginCallback iReLoginCallback);

    public abstract OurToken parseBDUSS(String str);

    public abstract void reLoginByCacheAccount();

    public abstract AccountData syncReLogin(String str, String str2, String str3, String str4);

    public static AccountLoginCoreHelper getInstance() {
        return mAccountLoginCoreHelper;
    }

    public static void init() {
        CustomResponsedMessage runTask;
        if (mAccountLoginCoreHelper == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, AccountLoginCoreHelper.class)) != null && runTask.getData() != null) {
            mAccountLoginCoreHelper = (AccountLoginCoreHelper) runTask.getData();
        }
    }
}
