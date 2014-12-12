package com.baidu.tbadk.core.account;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class AccountLoginHelper {
    private static AccountLoginHelper mHelper = null;
    private Activity mActivity;
    private LoginHelperCallBack mLoginHelperCallBack = null;
    private final g mReLoginCallbackForCacheAccount = new g() { // from class: com.baidu.tbadk.core.account.AccountLoginHelper.1
        @Override // com.baidu.tbadk.core.account.g
        public void onBeforeLogin(String str) {
            if (AccountLoginHelper.this.mLoginHelperCallBack != null) {
                AccountLoginHelper.this.mLoginHelperCallBack.onBeforeLogin(str);
            }
        }

        @Override // com.baidu.tbadk.core.account.g
        public void onSuccess(AccountData accountData) {
            if (AccountLoginHelper.this.mLoginHelperCallBack != null) {
                AccountLoginHelper.this.mLoginHelperCallBack.onSuccess();
            }
        }

        @Override // com.baidu.tbadk.core.account.g
        public void onFailure(final String str, int i, String str2) {
            if (i == 1) {
                ReloginManager.ob().d(null);
            }
            BdAsyncTask<Void, Void, AccountData> bdAsyncTask = new BdAsyncTask<Void, Void, AccountData>() { // from class: com.baidu.tbadk.core.account.AccountLoginHelper.1.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public AccountData doInBackground(Void... voidArr) {
                    return a.bO(str);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(AccountData accountData) {
                    super.onPostExecute((C00221) accountData);
                    if (accountData != null && !ba.isEmpty(accountData.getPassword())) {
                        c.a(accountData.getAccount(), accountData.getPassword(), AccountLoginHelper.this.mLoginCallBackForCacheAccount);
                    }
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(new Void[0]);
        }
    };
    private final d mLoginCallBackForCacheAccount = new d() { // from class: com.baidu.tbadk.core.account.AccountLoginHelper.2
        @Override // com.baidu.tbadk.core.account.d
        public void onSuccess(final AccountData accountData) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tbadk.core.account.AccountLoginHelper.2.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    if (accountData != null) {
                        a.a(accountData);
                        a.b(accountData);
                        TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                        TbadkCoreApplication.setCurrentAccount(accountData, AccountLoginHelper.this.mActivity);
                    }
                    return null;
                }
            }.execute(new Void[0]);
            if (AccountLoginHelper.this.mLoginHelperCallBack != null) {
                AccountLoginHelper.this.mLoginHelperCallBack.onSuccess();
            }
        }

        @Override // com.baidu.tbadk.core.account.d
        public void onFailure(String str) {
            if (!TextUtils.isEmpty(str)) {
                a.bN(str);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface LoginHelperCallBack {
        void onBeforeLogin(String str);

        void onFail();

        void onSuccess();
    }

    /* loaded from: classes.dex */
    public class OurToken {
        public String mBduss = null;
        public String mPtoken = null;
        public String mUsername = null;
    }

    private AccountLoginHelper() {
    }

    public static AccountLoginHelper getInstance() {
        if (mHelper == null) {
            mHelper = new AccountLoginHelper();
        }
        return mHelper;
    }

    public void setLoginHelperCallBack(LoginHelperCallBack loginHelperCallBack) {
        this.mLoginHelperCallBack = loginHelperCallBack;
    }

    public static String encodeBDUSS(OurToken ourToken) {
        if (ourToken != null) {
            return String.valueOf(ourToken.mBduss) + "|" + ourToken.mPtoken;
        }
        return null;
    }

    public static OurToken parseBDUSS(String str) {
        OurToken ourToken;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    ourToken = new OurToken();
                    try {
                        ourToken.mBduss = split[0];
                        if (split.length >= 2) {
                            ourToken.mPtoken = split[1];
                            return ourToken;
                        }
                        return ourToken;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        return ourToken;
                    }
                }
            } catch (Exception e3) {
                ourToken = null;
                e = e3;
            }
        }
        return null;
    }

    public void reLoginByCacheAccount(Activity activity) {
        OurToken parseBDUSS;
        if (com.baidu.adp.lib.util.i.fg()) {
            this.mActivity = activity;
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null && (parseBDUSS = parseBDUSS(currentAccountObj.getBDUSS())) != null) {
                f.a(currentAccountObj.getAccount(), parseBDUSS.mBduss, parseBDUSS.mPtoken, this.mReLoginCallbackForCacheAccount);
            }
        }
    }

    public void baiduMtjStat(String str) {
        try {
            TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp(), str, "click", 1, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
