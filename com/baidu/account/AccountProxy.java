package com.baidu.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorDescription;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.util.NetWork;
/* loaded from: classes.dex */
public class AccountProxy {
    public static final String BAIDUACCOUNT_ACTION = "com.baidu.account";
    public static final String BAIDUACCOUNT_KEY = "com.baidu.account.key";
    public static final String BAIDUACCOUNT_TYPE = "com.baidu";
    public static final String TAG = "AccountProxy";
    private Context mContext;
    private boolean mIsActivity;

    /* loaded from: classes.dex */
    public interface TokenCallback {
        void callBack(String str);
    }

    /* loaded from: classes.dex */
    class MyAccountManagerCallback implements AccountManagerCallback<Bundle> {
        private String mAccountType;
        private TokenCallback mCallback;
        private boolean mIfAddAccount;
        public String mytoken = null;

        private void endAll() {
            if (this.mCallback != null) {
                this.mCallback.callBack(this.mytoken);
                Log.d(AccountProxy.TAG, "the app callback is invokded");
            }
            Log.d(AccountProxy.TAG, "the  token is " + this.mytoken);
            if (AccountProxy.this.mIsActivity) {
                Intent intent = new Intent(AccountProxy.BAIDUACCOUNT_ACTION);
                intent.setComponent(((Activity) AccountProxy.this.mContext).getComponentName());
                intent.putExtra(AccountProxy.BAIDUACCOUNT_KEY, this.mytoken);
                AccountProxy.this.mContext.sendBroadcast(intent);
            }
            notify();
        }

        public MyAccountManagerCallback(TokenCallback callback, String accountType, boolean ifAddAccount) {
            this.mCallback = null;
            this.mCallback = callback;
            this.mAccountType = accountType;
            this.mIfAddAccount = ifAddAccount;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> result) {
            AccountManager am;
            Account[] accounts;
            synchronized (this) {
                try {
                    result.getResult();
                    Log.d(AccountProxy.TAG, "account callback");
                    this.mytoken = result.getResult().getString("authtoken");
                    am = AccountManager.get(AccountProxy.this.mContext);
                    accounts = am.getAccountsByType(this.mAccountType);
                    Log.d(AccountProxy.TAG, "mytoken is" + this.mytoken + " account length is" + accounts.length);
                } catch (Exception e) {
                    endAll();
                }
                if (this.mIfAddAccount && this.mytoken == null && accounts.length > 0) {
                    Log.d(AccountProxy.TAG, "continue to get token after addAccount");
                    am.getAuthToken(accounts[0], NetWork.BDUSS, (Bundle) null, AccountProxy.this.getActivity(), this, (Handler) null);
                    return;
                }
                endAll();
            }
        }
    }

    public AccountProxy(Context context) {
        this.mContext = context;
        this.mIsActivity = context instanceof Activity;
    }

    public boolean hasBaiduAccount() {
        AccountManager am = AccountManager.get(this.mContext);
        AuthenticatorDescription[] desGroup = am.getAuthenticatorTypes();
        for (AuthenticatorDescription des : desGroup) {
            if (des.type.equalsIgnoreCase(BAIDUACCOUNT_TYPE)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getTokenSync(String accountType) {
        String token = null;
        if (accountType == null || accountType.length() == 0) {
            accountType = BAIDUACCOUNT_TYPE;
        }
        AccountManager am = AccountManager.get(this.mContext);
        if (am != null) {
            Account[] accounts = am.getAccountsByType(accountType);
            MyAccountManagerCallback callback = new MyAccountManagerCallback(null, accountType, accounts.length == 0);
            if (accounts.length != 0) {
                am.getAuthToken(accounts[0], NetWork.BDUSS, (Bundle) null, getActivity(), callback, (Handler) null);
            } else {
                am.addAccount(accountType, NetWork.BDUSS, null, null, getActivity(), callback, null);
            }
            synchronized (callback) {
                try {
                    callback.wait();
                    token = callback.mytoken;
                } catch (Exception e) {
                }
            }
        }
        return token;
    }

    public void invalidateToken(String accountType, String token) {
        if (accountType == null || accountType.length() == 0) {
            accountType = BAIDUACCOUNT_TYPE;
        }
        AccountManager am = AccountManager.get(this.mContext);
        if (am != null) {
            am.invalidateAuthToken(accountType, token);
        }
    }

    public void getTokenAsync(String accountType, TokenCallback tcallback) {
        if (accountType == null || accountType.length() == 0) {
            accountType = BAIDUACCOUNT_TYPE;
        }
        AccountManager am = AccountManager.get(this.mContext);
        if (am != null) {
            Account[] accounts = am.getAccountsByType(accountType);
            Bundle option = new Bundle();
            option.putBoolean("PASSWDCK", true);
            MyAccountManagerCallback callback = new MyAccountManagerCallback(tcallback, accountType, accounts.length == 0);
            if (accounts.length != 0) {
                am.getAuthToken(accounts[0], NetWork.BDUSS, (Bundle) null, getActivity(), callback, (Handler) null);
            } else {
                am.addAccount(accountType, NetWork.BDUSS, null, option, getActivity(), callback, null);
            }
        } else if (tcallback != null) {
            tcallback.callBack(null);
        }
    }

    public void setAccount(String accountType) {
        if (accountType == null || accountType.length() == 0) {
            accountType = BAIDUACCOUNT_TYPE;
        }
        AccountManager am = AccountManager.get(this.mContext);
        if (am != null) {
            Account[] accounts = am.getAccountsByType(accountType);
            if (accounts.length == 1) {
                Intent intent = new Intent("android.settings.ACCOUNT_SYNC_SETTINGS");
                intent.putExtra(LoginActivity.ACCOUNT, accounts[0]);
                this.mContext.startActivity(intent);
                return;
            }
            manageAccount();
        }
    }

    public int getNumOfAccounts(String accountType) {
        if (accountType == null || accountType.length() == 0) {
            accountType = BAIDUACCOUNT_TYPE;
        }
        Log.d(TAG, "about to set the account " + accountType);
        AccountManager am = AccountManager.get(this.mContext);
        return am.getAccountsByType(accountType).length;
    }

    private void manageAccount() {
        this.mContext.startActivity(new Intent("android.settings.SYNC_SETTINGS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        if (this.mIsActivity) {
            return (Activity) this.mContext;
        }
        return null;
    }

    public boolean isBaiduAccountLogin() {
        return hasBaiduAccount() && getNumOfAccounts(BAIDUACCOUNT_TYPE) > 0;
    }

    public String getBaiduAccountUID() {
        String[] columns = {"uid"};
        Uri myUri = Uri.parse("content://com.baidu.account.provider.AccountInfoProvider/accountInfo");
        Cursor cur = this.mContext.getContentResolver().query(myUri, columns, null, null, null);
        if (cur == null || !cur.moveToFirst()) {
            return "";
        }
        String uid = cur.getString(cur.getColumnIndex("uid"));
        return uid;
    }

    public String getBaiduAccountDisplayName() {
        String[] columns = {"displayname"};
        Uri myUri = Uri.parse("content://com.baidu.account.provider.AccountInfoProvider/accountInfo");
        Cursor cur = this.mContext.getContentResolver().query(myUri, columns, null, null, null);
        if (cur == null || !cur.moveToFirst()) {
            return "";
        }
        String displayname = cur.getString(cur.getColumnIndex("displayname"));
        return displayname;
    }

    public String getBaiduAccountPhone() {
        String[] columns = {"phone"};
        Uri myUri = Uri.parse("content://com.baidu.account.provider.AccountInfoProvider/accountInfo");
        Cursor cur = this.mContext.getContentResolver().query(myUri, columns, null, null, null);
        if (cur == null || !cur.moveToFirst()) {
            return "";
        }
        String phone = cur.getString(cur.getColumnIndex("phone"));
        return phone;
    }

    public void startFillNameActivity(boolean showDialog) throws ActivityNotFoundException {
        Intent intent = new Intent("com.baidu.account.FILL_NAME");
        intent.putExtra("show_dialog", showDialog);
        this.mContext.startActivity(intent);
    }
}
