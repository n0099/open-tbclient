package com.baidu.android.pushservice.pushinfo.tieba;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class PushInfoDatabase {
    private static final String DATA_DIR = "/data";
    private static final String DB_DIR = "/database";
    private static final String DB_NAME = "pushinfo.db";
    private static final int DB_VERSION = 2;
    private static final String TAG = "PushInfoDataBase";
    private static InfoDbOpenHelper mDbHelper = null;
    private static DbErrorHandler mDbErrorHandler = null;
    private static Object myLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class DbErrorHandler implements DatabaseErrorHandler {
        private DbErrorHandler() {
        }

        private void deleteDatabaseFile(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            Log.e(PushInfoDatabase.TAG, "deleting the database file: " + str);
            try {
                if (Build.VERSION.SDK_INT > 18) {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } else {
                    new File(str).delete();
                }
            } catch (Exception e) {
                Log.w(PushInfoDatabase.TAG, "delete failed: " + e.getMessage());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
        @Override // android.database.DatabaseErrorHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            List<Pair<String, String>> list;
            Throwable th;
            Log.e(PushInfoDatabase.TAG, "Corruption reported by sqlite on database: " + sQLiteDatabase.getPath());
            if (!sQLiteDatabase.isOpen()) {
                deleteDatabaseFile(sQLiteDatabase.getPath());
                return;
            }
            List<Pair<String, String>> list2 = null;
            try {
                list2 = sQLiteDatabase.getAttachedDbs();
            } catch (SQLiteException e) {
            } catch (Throwable th2) {
                list = null;
                th = th2;
                if (list == null) {
                    for (Pair<String, String> pair : list) {
                        deleteDatabaseFile((String) pair.second);
                    }
                } else {
                    deleteDatabaseFile(sQLiteDatabase.getPath());
                }
                throw th;
            }
            try {
                sQLiteDatabase.close();
            } catch (SQLiteException e2) {
            } catch (Throwable th3) {
                list = list2;
                th = th3;
                if (list == null) {
                }
                throw th;
            }
            if (list2 == null) {
                deleteDatabaseFile(sQLiteDatabase.getPath());
                return;
            }
            for (Pair<String, String> pair2 : list2) {
                deleteDatabaseFile((String) pair2.second);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class InfoDbOpenHelper extends SQLiteOpenHelper {
        public InfoDbOpenHelper(Context context, String str, int i, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i, databaseErrorHandler);
        }

        public InfoDbOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        private void dropTables(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushShareInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushVerifInfo");
            } catch (Exception e) {
                Log.d(PushInfoDatabase.TAG, "dropTables Exception: " + e);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE PushShareInfo (" + PushInfoEnum.PushInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PushInfoEnum.PushPriority.name() + " LONG  NOT NULL DEFAULT ((0)), " + PushInfoEnum.PushVersion.name() + " INTEGER DEFAULT ((0)), " + PushInfoEnum.PushChannelID.name() + " TEXT, " + PushInfoEnum.PushCurPkgName.name() + " TEXT, " + PushInfoEnum.PushWebAppBindInfo.name() + " TEXT, " + PushInfoEnum.PushLightAppBindInfo.name() + " TEXT, " + PushInfoEnum.PushSDKClientBindInfo.name() + " TEXT, " + PushInfoEnum.PushClientsBindInfo.name() + " TEXT, " + PushInfoEnum.PushSelfBindInfo.name() + " TEXT );");
                Log.d(PushInfoDatabase.TAG, "CREATE TABLE PushShareInfo (" + PushInfoEnum.PushInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PushInfoEnum.PushPriority.name() + " INTEGER DEFAULT ((0)), " + PushInfoEnum.PushVersion.name() + " INTEGER DEFAULT ((0)), " + PushInfoEnum.PushChannelID.name() + " TEXT, " + PushInfoEnum.PushCurPkgName.name() + " TEXT, " + PushInfoEnum.PushWebAppBindInfo.name() + " TEXT, " + PushInfoEnum.PushLightAppBindInfo.name() + " TEXT, " + PushInfoEnum.PushSDKClientBindInfo.name() + " TEXT, " + PushInfoEnum.PushClientsBindInfo.name() + " TEXT, " + PushInfoEnum.PushSelfBindInfo.name() + " TEXT );");
                String str = "CREATE TABLE PushVerifInfo (" + PushVerifInfoEnum.verifId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PushVerifInfoEnum.msgId.name() + " TEXT  NOT NULL, " + PushVerifInfoEnum.md5Infos.name() + " TEXT  NOT NULL, " + PushVerifInfoEnum.appId.name() + " TEXT, " + PushVerifInfoEnum.time.name() + " TEXT );";
                sQLiteDatabase.execSQL(str);
                Log.d(PushInfoDatabase.TAG, str);
            } catch (Exception e) {
                Log.e(PushInfoDatabase.TAG, e + "");
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            dropTables(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum PushInfoEnum {
        PushInfoId,
        PushPriority,
        PushVersion,
        PushChannelID,
        PushCurPkgName,
        PushWebAppBindInfo,
        PushLightAppBindInfo,
        PushSDKClientBindInfo,
        PushClientsBindInfo,
        PushSelfBindInfo;
        
        static final String TABLE_NAME = "PushShareInfo";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum PushVerifInfoEnum {
        verifId,
        msgId,
        md5Infos,
        appId,
        time;
        
        static final String TABLE_NAME = "PushVerifInfo";
    }

    public static void close() {
        synchronized (myLock) {
            try {
                if (mDbHelper != null) {
                    mDbHelper.close();
                    mDbHelper = null;
                }
            } catch (Exception e) {
                mDbHelper = null;
                Log.e(TAG, "close db: " + e);
            }
        }
    }

    public static SQLiteDatabase getDb(Context context) {
        InfoDbOpenHelper infoDbOpenHelper = getInfoDbOpenHelper(context);
        if (infoDbOpenHelper == null) {
            return null;
        }
        try {
            return infoDbOpenHelper.getWritableDatabase();
        } catch (Exception e) {
            Log.e(TAG, e + " ");
            return null;
        }
    }

    private static InfoDbOpenHelper getInfoDbOpenHelper(Context context) {
        synchronized (myLock) {
            if (mDbHelper == null) {
                File file = new File(Environment.getDataDirectory().getAbsolutePath() + DATA_DIR + File.separator + context.getPackageName() + DB_DIR);
                Log.d(TAG, "File Path is  " + Environment.getDataDirectory().getAbsolutePath() + DATA_DIR + File.separator + context.getPackageName() + DB_DIR);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str = file.getAbsolutePath() + File.separator + DB_NAME;
                Log.d(TAG, "dbname is :" + str);
                if (Build.VERSION.SDK_INT >= 11) {
                    mDbErrorHandler = new DbErrorHandler();
                    mDbHelper = new InfoDbOpenHelper(context, str, 2, mDbErrorHandler);
                } else {
                    mDbHelper = new InfoDbOpenHelper(context, str, (SQLiteDatabase.CursorFactory) null, 2);
                }
            }
        }
        return mDbHelper;
    }
}
