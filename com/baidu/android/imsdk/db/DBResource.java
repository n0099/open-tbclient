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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes18.dex */
public class DBResource {
    private static final String TAG = "DBManager";
    private static Context mContext;
    private static final DBResource sInstanceDbResource = new DBResource();
    private SQLiteDatabase mDatabase;
    private long appid = -1;
    private String mUid = null;

    private DBResource() {
    }

    public static DBResource getInstance(Context context) {
        if (mContext == null) {
            mContext = context.getApplicationContext();
        }
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
        String path = mContext.getDatabasePath(TableDefine.DB_NAME_PREFIX + this.mUid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.appid + ".db").getPath();
        if (this.mDatabase == null) {
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
        } else if (!TextUtils.isEmpty(path) && !this.mDatabase.getPath().equals(path)) {
            closeDatabase();
            try {
                this.mDatabase = IMDatabase.getWritableDb(mContext, this.mUid, this.appid);
            } catch (SQLiteDatabaseCorruptException e2) {
                if (this.mDatabase != null) {
                    closeDatabase();
                    this.mDatabase = null;
                    LogUtils.e(TAG, "getWritableDb  DatabaseCorruptException");
                }
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
        return this.mDatabase;
    }

    private void closeDatabase() {
        if (this.mDatabase != null) {
            this.mDatabase.close();
            this.mDatabase = null;
        }
    }
}
