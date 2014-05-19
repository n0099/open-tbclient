package com.baidu.tbadk.core.account;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.be;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AccountLoginHelper {
    private static AccountLoginHelper mHelper = null;
    private Activity mActivity;
    private int mGotoType;
    private ArrayList<AccountData> mLocalAccountList;
    private LoginHelperCallBack mLoginHelperCallBack = null;
    private int mCurrentLoginAccountIndex = 0;
    private boolean mIsReLoginExcuted = false;
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
        public void onFailure(final String str, String str2) {
            TbadkApplication.setCurrentAccount(null, AccountLoginHelper.this.mActivity);
            BdAsyncTask<Void, Void, AccountData> bdAsyncTask = new BdAsyncTask<Void, Void, AccountData>() { // from class: com.baidu.tbadk.core.account.AccountLoginHelper.1.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public AccountData doInBackground(Void... voidArr) {
                    return a.b(str);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(AccountData accountData) {
                    super.onPostExecute((C00111) accountData);
                    if (accountData == null || be.c(accountData.getPassword())) {
                        if (!AccountLoginHelper.this.mIsReLoginExcuted) {
                            AccountLoginHelper.this.reLoginByDbAccount(AccountLoginHelper.this.mActivity, AccountLoginHelper.this.mGotoType);
                            return;
                        }
                        return;
                    }
                    c.a(accountData.getAccount(), accountData.getPassword(), AccountLoginHelper.this.mLoginCallBackForCacheAccount);
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(new Void[0]);
        }
    };
    private final d mLoginCallBackForLocalAccount = new d() { // from class: com.baidu.tbadk.core.account.AccountLoginHelper.2
        @Override // com.baidu.tbadk.core.account.d
        public void onSuccess(final AccountData accountData) {
            TbadkApplication.setCurrentAccount(accountData, AccountLoginHelper.this.mActivity);
            if (AccountLoginHelper.this.mActivity != null) {
                TbadkApplication.m252getInst().onUserChanged();
                MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.STOP));
                MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.START));
                if (AccountLoginHelper.this.mLoginHelperCallBack != null) {
                    AccountLoginHelper.this.mLoginHelperCallBack.onSuccess();
                }
            }
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tbadk.core.account.AccountLoginHelper.2.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    a.a(accountData);
                    a.b(accountData);
                    return null;
                }
            }.execute(new Void[0]);
        }

        @Override // com.baidu.tbadk.core.account.d
        public void onFailure(String str) {
            if (!AccountLoginHelper.this.mIsReLoginExcuted) {
                AccountLoginHelper.this.reLoginByDbAccount(AccountLoginHelper.this.mActivity, AccountLoginHelper.this.mGotoType);
            }
        }
    };
    private final d mLoginCallBackForCacheAccount = new d() { // from class: com.baidu.tbadk.core.account.AccountLoginHelper.3
        @Override // com.baidu.tbadk.core.account.d
        public void onSuccess(final AccountData accountData) {
            TbadkApplication.setCurrentAccount(accountData, AccountLoginHelper.this.mActivity);
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tbadk.core.account.AccountLoginHelper.3.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    a.a(accountData);
                    a.b(accountData);
                    return null;
                }
            }.execute(new Void[0]);
            if (AccountLoginHelper.this.mLoginHelperCallBack != null) {
                AccountLoginHelper.this.mLoginHelperCallBack.onSuccess();
            }
        }

        @Override // com.baidu.tbadk.core.account.d
        public void onFailure(String str) {
            AccountLoginHelper.this.reLoginByLocalAccount();
        }
    };
    private final g mReLoginCallbackForLocalAccount = new g() { // from class: com.baidu.tbadk.core.account.AccountLoginHelper.4
        @Override // com.baidu.tbadk.core.account.g
        public void onBeforeLogin(String str) {
            if (AccountLoginHelper.this.mLoginHelperCallBack != null) {
                AccountLoginHelper.this.mLoginHelperCallBack.onBeforeLogin(str);
            }
        }

        @Override // com.baidu.tbadk.core.account.g
        public void onSuccess(final AccountData accountData) {
            TbadkApplication.setCurrentAccount(accountData, AccountLoginHelper.this.mActivity);
            if (AccountLoginHelper.this.mActivity != null) {
                TbadkApplication.m252getInst().onUserChanged();
                MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.STOP));
                MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.START));
                if (AccountLoginHelper.this.mLoginHelperCallBack != null) {
                    AccountLoginHelper.this.mLoginHelperCallBack.onSuccess();
                }
            }
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tbadk.core.account.AccountLoginHelper.4.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    a.a();
                    a.b(accountData);
                    return null;
                }
            }.execute(new Void[0]);
        }

        @Override // com.baidu.tbadk.core.account.g
        public void onFailure(String str, String str2) {
            AccountData accountDataByName = AccountLoginHelper.this.getAccountDataByName(str);
            if (accountDataByName == null || be.c(accountDataByName.getPassword())) {
                if (AccountLoginHelper.this.mCurrentLoginAccountIndex >= AccountLoginHelper.this.mLocalAccountList.size()) {
                    return;
                }
                AccountLoginHelper.this.reLoginByLocalAccount();
                return;
            }
            c.a(accountDataByName.getAccount(), accountDataByName.getPassword(), AccountLoginHelper.this.mLoginCallBackForLocalAccount);
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

    public void setLoginHelperCallBack(LoginHelperCallBack loginHelperCallBack) {
        this.mLoginHelperCallBack = loginHelperCallBack;
    }

    private AccountLoginHelper() {
    }

    public static AccountLoginHelper getInstance() {
        if (mHelper == null) {
            mHelper = new AccountLoginHelper();
        }
        return mHelper;
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
                        BdLog.e("AccountShareHelper", "parseBDUSS", e.getMessage());
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
        if (UtilHelper.isNetOk()) {
            this.mActivity = activity;
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null && (parseBDUSS = parseBDUSS(currentAccountObj.getBDUSS())) != null) {
                f.a(currentAccountObj.getAccount(), parseBDUSS.mBduss, parseBDUSS.mPtoken, this.mReLoginCallbackForCacheAccount);
            }
        }
    }

    public void reLoginByDbAccount(Activity activity, int i) {
        if (UtilHelper.isNetOk() && TbadkApplication.getCurrentAccountObj() == null) {
            this.mIsReLoginExcuted = true;
            this.mActivity = activity;
            this.mGotoType = i;
            BdAsyncTask<Object, Object, Object> bdAsyncTask = new BdAsyncTask<Object, Object, Object>() { // from class: com.baidu.tbadk.core.account.AccountLoginHelper.5
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Object doInBackground(Object... objArr) {
                    AccountLoginHelper.this.mLocalAccountList = a.d();
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Object obj) {
                    super.onPostExecute(obj);
                    AccountLoginHelper.this.mCurrentLoginAccountIndex = 0;
                    if (AccountLoginHelper.this.mLocalAccountList == null || AccountLoginHelper.this.mLocalAccountList.size() <= 0) {
                        return;
                    }
                    AccountLoginHelper.this.reLoginByLocalAccount();
                }
            };
            bdAsyncTask.setPriority(3);
            bdAsyncTask.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean reLoginByLocalAccount() {
        if (this.mLocalAccountList != null && this.mCurrentLoginAccountIndex < this.mLocalAccountList.size()) {
            ArrayList<AccountData> arrayList = this.mLocalAccountList;
            int i = this.mCurrentLoginAccountIndex;
            this.mCurrentLoginAccountIndex = i + 1;
            com.baidu.tbadk.core.data.j loginRawDataFromAccountData = getLoginRawDataFromAccountData(arrayList.get(i));
            if (loginRawDataFromAccountData == null) {
                return reLoginByLocalAccount();
            }
            f.a(loginRawDataFromAccountData.c, loginRawDataFromAccountData.a, loginRawDataFromAccountData.b, this.mReLoginCallbackForLocalAccount);
            return true;
        }
        return false;
    }

    private com.baidu.tbadk.core.data.j getLoginRawDataFromAccountData(AccountData accountData) {
        OurToken parseBDUSS;
        if (accountData == null || accountData.getAccount().equals(TbadkApplication.getCurrentAccountName()) || (parseBDUSS = parseBDUSS(accountData.getBDUSS())) == null) {
            return null;
        }
        com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
        jVar.c = accountData.getAccount();
        jVar.a = parseBDUSS.mBduss;
        jVar.b = parseBDUSS.mPtoken;
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AccountData getAccountDataByName(String str) {
        int size = this.mLocalAccountList.size();
        for (int i = 0; i < size; i++) {
            AccountData accountData = this.mLocalAccountList.get(i);
            if (accountData.getAccount().equals(str)) {
                return accountData;
            }
        }
        return null;
    }

    public void baiduMtjStat(String str) {
        try {
            TiebaStatic.eventStat(TbadkApplication.m252getInst().getApp(), str, "click", 1, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
