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
/* loaded from: classes2.dex */
public class DBResource {
    public static final String TAG = "DBManager";
    public static Context mContext;
    public static final DBResource sInstanceDbResource = new DBResource();
    public SQLiteDatabase mDatabase;
    public long appid = -1;
    public String mUid = null;

    private void closeDatabase() {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            this.mDatabase = null;
        }
    }

    public static Context getContext() {
        return mContext;
    }

    public static DBResource getInstance(Context context) {
        if (mContext == null) {
            mContext = context.getApplicationContext();
        }
        return sInstanceDbResource;
    }

    public SQLiteDatabase openDatabase() {
        Context context = mContext;
        if (context == null) {
            LogUtils.d("DBManager", "pls call init method first!");
            return null;
        }
        if (AccountManagerImpl.getInstance(context).getLoginType() == 6) {
            this.mUid = AccountManager.getUK(mContext) + "";
        } else {
            this.mUid = AccountManager.getUid(mContext);
        }
        this.appid = AccountManager.getAppid(mContext);
        if (!TextUtils.isEmpty(this.mUid) && -1 != this.appid) {
            Context context2 = mContext;
            String path = context2.getDatabasePath(TableDefine.DB_NAME_PREFIX + this.mUid + "_" + this.appid + ".db").getPath();
            if (this.mDatabase == null) {
                try {
                    this.mDatabase = IMDatabase.getWritableDb(mContext, this.mUid, this.appid);
                } catch (SQLiteDatabaseCorruptException e2) {
                    if (this.mDatabase != null) {
                        closeDatabase();
                        this.mDatabase = null;
                        LogUtils.e("DBManager", "getWritableDb  DatabaseCorruptException");
                    }
                    new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
                }
            } else if (!TextUtils.isEmpty(path) && !this.mDatabase.getPath().equals(path)) {
                closeDatabase();
                try {
                    this.mDatabase = IMDatabase.getWritableDb(mContext, this.mUid, this.appid);
                } catch (SQLiteDatabaseCorruptException e3) {
                    if (this.mDatabase != null) {
                        closeDatabase();
                        this.mDatabase = null;
                        LogUtils.e("DBManager", "getWritableDb  DatabaseCorruptException");
                    }
                    new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e3)).build();
                }
            }
            return this.mDatabase;
        }
        LogUtils.d("DBManager", "UK OR appid Not initialize!");
        if (TextUtils.isEmpty(this.mUid)) {
            LogUtils.d("DBManager", "mUid Not initialize!");
        }
        if (-1 == this.appid) {
            LogUtils.d("DBManager", "appid Not initialize!");
        }
        return null;
    }
}
