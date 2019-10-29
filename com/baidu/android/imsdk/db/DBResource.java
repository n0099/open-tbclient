package com.baidu.android.imsdk.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class DBResource {
    private static final String TAG = "DBManager";
    private static Context mContext;
    private static DBResource sInstanceDbResource = new DBResource();
    private SQLiteDatabase mDatabase;
    private long appid = -1;
    private String mUid = null;
    private AtomicInteger mOpenCounter = new AtomicInteger();

    private DBResource() {
    }

    public static DBResource getInstance(Context context) {
        mContext = context.getApplicationContext();
        return sInstanceDbResource;
    }

    public static Context getContext() {
        return mContext;
    }

    public SQLiteDatabase openDatabase() {
        if (mContext == null) {
            LogUtils.d(TAG, "pls call init method first!");
            return null;
        }
        if (AccountManagerImpl.getInstance(mContext).isJustLogin()) {
            AccountManagerImpl.getInstance(mContext).setJustLogin(false);
            this.mOpenCounter.set(0);
        }
        if (AccountManagerImpl.getInstance(mContext).getLoginType() == 6) {
            this.mUid = AccountManager.getUK(mContext) + "";
        } else {
            this.mUid = AccountManager.getUid(mContext);
        }
        this.appid = AccountManager.getAppid(mContext);
        if (TextUtils.isEmpty(this.mUid) || -1 == this.appid) {
            LogUtils.d(TAG, "UK OR appid Not initialize!");
            if (TextUtils.isEmpty(this.mUid)) {
                LogUtils.d(TAG, "mUid Not initialize!");
            }
            if (-1 == this.appid) {
                LogUtils.d(TAG, "appid Not initialize!");
                return null;
            }
            return null;
        }
        if (this.mOpenCounter.incrementAndGet() == 1) {
            try {
                this.mDatabase = IMDatabase.getWritableDb(mContext, this.mUid, this.appid);
            } catch (SQLiteDatabaseCorruptException e) {
                if (this.mDatabase != null) {
                    closeDatabase();
                    this.mDatabase = null;
                    LogUtils.e(TAG, "getWritableDb  DatabaseCorruptException");
                }
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
            }
        }
        return this.mDatabase;
    }

    public void closeDatabase() {
        if (this.mOpenCounter.get() > 0) {
            if (this.mOpenCounter.decrementAndGet() == 0) {
                this.mDatabase.close();
                this.mDatabase = null;
            }
        } else if (this.mDatabase != null) {
            this.mDatabase.close();
            this.mDatabase = null;
        }
    }
}
