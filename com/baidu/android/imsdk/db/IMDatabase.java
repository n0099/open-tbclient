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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes3.dex */
public class IMDatabase {
    private static DbOpenHelper mDbHelper = null;

    public static synchronized SQLiteDatabase getWritableDb(Context context, String str, long j) {
        SQLiteDatabase sQLiteDatabase = null;
        synchronized (IMDatabase.class) {
            DbOpenHelper dBOpenHelper = getDBOpenHelper(context, str, j);
            if (dBOpenHelper != null) {
                try {
                    sQLiteDatabase = dBOpenHelper.getWritableDatabase();
                } catch (Exception e) {
                    mDbHelper = null;
                    new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                }
            }
        }
        return sQLiteDatabase;
    }

    public static synchronized SQLiteDatabase getReadableDb(Context context, String str, long j) {
        SQLiteDatabase sQLiteDatabase = null;
        synchronized (IMDatabase.class) {
            DbOpenHelper dBOpenHelper = getDBOpenHelper(context, str, j);
            if (dBOpenHelper != null) {
                try {
                    sQLiteDatabase = dBOpenHelper.getReadableDatabase();
                } catch (SQLException e) {
                    mDbHelper = null;
                    LogUtils.e("IMDatabase", "Exception ", e);
                    new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                }
            }
        }
        return sQLiteDatabase;
    }

    private static synchronized DbOpenHelper getDBOpenHelper(Context context, String str, long j) {
        String str2;
        DbOpenHelper dbOpenHelper;
        synchronized (IMDatabase.class) {
            String path = context.getDatabasePath(TableDefine.DB_NAME_PREFIX + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + j + ".db").getPath();
            if (mDbHelper == null) {
                mDbHelper = new DbOpenHelper(context, path, 49);
            } else {
                try {
                    str2 = mDbHelper.getReadableDatabase().getPath();
                } catch (SQLiteException e) {
                    LogUtils.e("IMDatabase", "", e);
                    new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                    str2 = "";
                }
                if (!str2.equals(path)) {
                    mDbHelper.close();
                    mDbHelper = null;
                    mDbHelper = new DbOpenHelper(context, path, 49);
                }
            }
            dbOpenHelper = mDbHelper;
        }
        return dbOpenHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class DbOpenHelper extends SQLiteOpenHelper {
        private Context mContext;

        public DbOpenHelper(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
            this.mContext = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            DBVersionManager.getInstance(this.mContext).onCreate(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            DBVersionManager.getInstance(this.mContext).onUpgrade(sQLiteDatabase, i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        @TargetApi(11)
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            DBVersionManager.getInstance(this.mContext).onDowngrade(sQLiteDatabase, i, i2);
        }
    }
}
