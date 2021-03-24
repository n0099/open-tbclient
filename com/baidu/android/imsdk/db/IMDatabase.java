package com.baidu.android.imsdk.db;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes2.dex */
public class IMDatabase {
    public static DbOpenHelper mDbHelper;

    /* loaded from: classes2.dex */
    public static class DbOpenHelper extends SQLiteOpenHelper {
        public Context mContext;

        public DbOpenHelper(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
            this.mContext = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            DBVersionManager.getInstance(this.mContext).onCreate(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        @TargetApi(11)
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            DBVersionManager.getInstance(this.mContext).onDowngrade(sQLiteDatabase, i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            DBVersionManager.getInstance(this.mContext).onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public static synchronized DbOpenHelper getDBOpenHelper(Context context, String str, long j) {
        String path;
        DbOpenHelper dbOpenHelper;
        synchronized (IMDatabase.class) {
            String path2 = context.getDatabasePath(TableDefine.DB_NAME_PREFIX + str + "_" + j + ".db").getPath();
            if (mDbHelper == null) {
                mDbHelper = new DbOpenHelper(context, path2, 49);
            } else {
                try {
                    path = mDbHelper.getReadableDatabase().getPath();
                } catch (SQLiteException e2) {
                    LogUtils.e("IMDatabase", "", e2);
                    new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                }
                if (!path.equals(path2)) {
                    mDbHelper.close();
                    mDbHelper = null;
                    mDbHelper = new DbOpenHelper(context, path2, 49);
                }
            }
            dbOpenHelper = mDbHelper;
        }
        return dbOpenHelper;
    }

    public static synchronized SQLiteDatabase getReadableDb(Context context, String str, long j) {
        synchronized (IMDatabase.class) {
            DbOpenHelper dBOpenHelper = getDBOpenHelper(context, str, j);
            SQLiteDatabase sQLiteDatabase = null;
            if (dBOpenHelper == null) {
                return null;
            }
            try {
                sQLiteDatabase = dBOpenHelper.getReadableDatabase();
            } catch (SQLException e2) {
                mDbHelper = null;
                LogUtils.e("IMDatabase", "Exception ", e2);
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
            }
            return sQLiteDatabase;
        }
    }

    public static synchronized SQLiteDatabase getWritableDb(Context context, String str, long j) {
        synchronized (IMDatabase.class) {
            DbOpenHelper dBOpenHelper = getDBOpenHelper(context, str, j);
            SQLiteDatabase sQLiteDatabase = null;
            if (dBOpenHelper == null) {
                return null;
            }
            try {
                sQLiteDatabase = dBOpenHelper.getWritableDatabase();
            } catch (Exception e2) {
                mDbHelper = null;
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
            }
            return sQLiteDatabase;
        }
    }
}
