package com.baidu.android.imsdk.db;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import com.baidu.android.imsdk.db.DBVersionManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes2.dex */
public class DBConnection extends SQLiteOpenHelper {
    public static final String TAG = "DBConnection";
    public Context mContext;

    /* loaded from: classes2.dex */
    public class Version27And28Handler implements DBVersionManager.VersionHandler {
        public Version27And28Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE groupmember ADD COLUMN nickname TEXT");
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(DBConnection.this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(LogUtils.TAG, "DBConnection onUpgrade:27->28", e2);
            }
            Log.d(LogUtils.TAG, "DBConnection onUpgrade:27->28");
        }
    }

    /* loaded from: classes2.dex */
    public class Version47And48Handler implements DBVersionManager.VersionHandler {
        public Version47And48Handler() {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN marktop INTEGER DEFAULT 1");
                sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN marktoptime LONG ");
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(DBConnection.this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(LogUtils.TAG, "DBConnection onUpgrade:27->28", e2);
            }
            Log.d(LogUtils.TAG, "DBConnection onUpgrade:27->28");
        }
    }

    public DBConnection(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.mContext = context;
    }

    private void createDb(SQLiteDatabase sQLiteDatabase) {
        if (dropTable(sQLiteDatabase) < 0) {
            LogUtils.d(TAG, "drop table db failed when db upgrade or downgrade!");
        } else if (createTable(sQLiteDatabase) < 0) {
            LogUtils.d(TAG, "create table db failed when db upgrade or downgrade!");
        }
    }

    private int createTable(SQLiteDatabase sQLiteDatabase) {
        int i = -1;
        if (sQLiteDatabase != null) {
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL(DBTableDefine.SQL_CREATE_TABLE_LOCALMESSAGE);
                    sQLiteDatabase.execSQL(DBTableDefine.SQL_CREATE_TABLE_GROUPINFO);
                    sQLiteDatabase.execSQL(DBTableDefine.SQL_CREATE_TABLE_GROUP_MEMBER);
                    i = 0;
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "createTable:", e2);
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
        return i;
    }

    private int dropTable(SQLiteDatabase sQLiteDatabase) {
        int i = -1;
        if (sQLiteDatabase != null) {
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS grouplocalmessage");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS groupinfo");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS groupmember");
                    i = 0;
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "dropTable:", e2);
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
        return i;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        super.onConfigure(sQLiteDatabase);
        if (Build.VERSION.SDK_INT > 10) {
            try {
                boolean enableWriteAheadLogging = sQLiteDatabase.enableWriteAheadLogging();
                LogUtils.d(TAG, "enableWAL : " + enableWriteAheadLogging);
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "onConfigure", e2);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createDb(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i <= 27 && i2 >= 28) {
            new Version27And28Handler().onUpgrade(sQLiteDatabase, i, i2);
            i = 28;
        }
        if (i > 47 || i2 < 48) {
            return;
        }
        new Version47And48Handler().onUpgrade(sQLiteDatabase, i, i2);
    }
}
