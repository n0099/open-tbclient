package com.baidu.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorDescription;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.baidu.sapi2.SapiAccountManager;
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

        public MyAccountManagerCallback(TokenCallback tokenCallback, String str, boolean z) {
            this.mCallback = null;
            this.mCallback = tokenCallback;
            this.mAccountType = str;
            this.mIfAddAccount = z;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            AccountManager accountManager;
            Account[] accountsByType;
            synchronized (this) {
                try {
                    accountManagerFuture.getResult();
                    Log.d(AccountProxy.TAG, "account callback");
                    this.mytoken = accountManagerFuture.getResult().getString("authtoken");
                    accountManager = AccountManager.get(AccountProxy.this.mContext);
                    accountsByType = accountManager.getAccountsByType(this.mAccountType);
                    Log.d(AccountProxy.TAG, "mytoken is" + this.mytoken + " account length is" + accountsByType.length);
                } catch (Exception e) {
                    endAll();
                }
                if (this.mIfAddAccount && this.mytoken == null && accountsByType.length > 0) {
                    Log.d(AccountProxy.TAG, "continue to get token after addAccount");
                    accountManager.getAuthToken(accountsByType[0], "BDUSS", (Bundle) null, AccountProxy.this.getActivity(), this, (Handler) null);
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
        for (AuthenticatorDescription authenticatorDescription : AccountManager.get(this.mContext).getAuthenticatorTypes()) {
            if (authenticatorDescription.type.equalsIgnoreCase(BAIDUACCOUNT_TYPE)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getTokenSync(String str) {
        String str2 = null;
        String str3 = (str == null || str.length() == 0) ? BAIDUACCOUNT_TYPE : str;
        AccountManager accountManager = AccountManager.get(this.mContext);
        if (accountManager != null) {
            Account[] accountsByType = accountManager.getAccountsByType(str3);
            MyAccountManagerCallback myAccountManagerCallback = new MyAccountManagerCallback(null, str3, accountsByType.length == 0);
            if (accountsByType.length != 0) {
                accountManager.getAuthToken(accountsByType[0], "BDUSS", (Bundle) null, getActivity(), myAccountManagerCallback, (Handler) null);
            } else {
                accountManager.addAccount(str3, "BDUSS", null, null, getActivity(), myAccountManagerCallback, null);
            }
            synchronized (myAccountManagerCallback) {
                try {
                    myAccountManagerCallback.wait();
                    str2 = myAccountManagerCallback.mytoken;
                } catch (Exception e) {
                }
            }
        }
        return str2;
    }

    public void invalidateToken(String str, String str2) {
        if (str == null || str.length() == 0) {
            str = BAIDUACCOUNT_TYPE;
        }
        AccountManager accountManager = AccountManager.get(this.mContext);
        if (accountManager != null) {
            accountManager.invalidateAuthToken(str, str2);
        }
    }

    public void getTokenAsync(String str, TokenCallback tokenCallback) {
        String str2 = (str == null || str.length() == 0) ? BAIDUACCOUNT_TYPE : str;
        AccountManager accountManager = AccountManager.get(this.mContext);
        if (accountManager != null) {
            Account[] accountsByType = accountManager.getAccountsByType(str2);
            Bundle bundle = new Bundle();
            bundle.putBoolean("PASSWDCK", true);
            MyAccountManagerCallback myAccountManagerCallback = new MyAccountManagerCallback(tokenCallback, str2, accountsByType.length == 0);
            if (accountsByType.length != 0) {
                accountManager.getAuthToken(accountsByType[0], "BDUSS", (Bundle) null, getActivity(), myAccountManagerCallback, (Handler) null);
            } else {
                accountManager.addAccount(str2, "BDUSS", null, bundle, getActivity(), myAccountManagerCallback, null);
            }
        } else if (tokenCallback != null) {
            tokenCallback.callBack(null);
        }
    }

    public void setAccount(String str) {
        if (str == null || str.length() == 0) {
            str = BAIDUACCOUNT_TYPE;
        }
        AccountManager accountManager = AccountManager.get(this.mContext);
        if (accountManager != null) {
            Account[] accountsByType = accountManager.getAccountsByType(str);
            if (accountsByType.length == 1) {
                Intent intent = new Intent("android.settings.ACCOUNT_SYNC_SETTINGS");
                intent.putExtra("account", accountsByType[0]);
                this.mContext.startActivity(intent);
                return;
            }
            manageAccount();
        }
    }

    public int getNumOfAccounts(String str) {
        if (str == null || str.length() == 0) {
            str = BAIDUACCOUNT_TYPE;
        }
        Log.d(TAG, "about to set the account " + str);
        return AccountManager.get(this.mContext).getAccountsByType(str).length;
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
        Cursor query = this.mContext.getContentResolver().query(Uri.parse("content://com.baidu.account.provider.AccountInfoProvider/accountInfo"), new String[]{SapiAccountManager.SESSION_UID}, null, null, null);
        if (query == null || !query.moveToFirst()) {
            return "";
        }
        return query.getString(query.getColumnIndex(SapiAccountManager.SESSION_UID));
    }

    public String getBaiduAccountDisplayName() {
        Cursor query = this.mContext.getContentResolver().query(Uri.parse("content://com.baidu.account.provider.AccountInfoProvider/accountInfo"), new String[]{SapiAccountManager.SESSION_DISPLAYNAME}, null, null, null);
        if (query == null || !query.moveToFirst()) {
            return "";
        }
        return query.getString(query.getColumnIndex(SapiAccountManager.SESSION_DISPLAYNAME));
    }

    public String getBaiduAccountPhone() {
        Cursor query = this.mContext.getContentResolver().query(Uri.parse("content://com.baidu.account.provider.AccountInfoProvider/accountInfo"), new String[]{"phone"}, null, null, null);
        if (query == null || !query.moveToFirst()) {
            return "";
        }
        return query.getString(query.getColumnIndex("phone"));
    }

    public void startFillNameActivity(boolean z) {
        Intent intent = new Intent("com.baidu.account.FILL_NAME");
        intent.putExtra("show_dialog", z);
        this.mContext.startActivity(intent);
    }
}
