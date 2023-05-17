package com.baidu.searchbox.schemeauthenticate.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.io.Closeable;
import java.io.File;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public abstract class BaseDBControl implements Closeable {
    public static final String DB_NAME = "searchBox_security.db";
    public static final int DB_VERSION = 1;
    public static final int DB_VERSION_10_0 = 1;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = BaseDBControl.class.getSimpleName();
    @SuppressLint({"StaticFieldLeak"})
    public static Context mContext;
    public final Executor mExecutor;
    public final SQLiteOpenHelper mOpenHelper;

    /* loaded from: classes4.dex */
    public interface OnTransactionFinishedListener {
        void onFinished();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* loaded from: classes4.dex */
    public static final class DbOpenHelper extends SQLiteOpenHelper {
        public static volatile DbOpenHelper mDbOpenHelper;
        public String mPath;

        public DbOpenHelper(Context context, String str, int i, Executor executor) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        }

        public static DbOpenHelper getInstance(Context context, String str, int i, Executor executor) {
            if (mDbOpenHelper == null) {
                synchronized (DbOpenHelper.class) {
                    if (mDbOpenHelper == null) {
                        mDbOpenHelper = new DbOpenHelper(context, str, i, executor);
                    }
                }
            }
            if (BaseDBControl.DEBUG) {
                String str2 = BaseDBControl.TAG;
                Log.i(str2, "current  db version = " + BaseDBControl.DB_VERSION);
            }
            return mDbOpenHelper;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            if (BaseDBControl.DEBUG && BaseDBControl.DB_NAME.equals(getDatabaseName())) {
                throw new RuntimeException("can't close Searchbox.db!");
            }
            super.close();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public synchronized SQLiteDatabase getReadableDatabase() {
            SQLiteDatabase sQLiteDatabase;
            try {
                sQLiteDatabase = super.getReadableDatabase();
            } catch (Exception e) {
                e.printStackTrace();
                if (!BaseDBControl.DEBUG) {
                    if (new File(BaseDBControl.mContext.getDatabasePath(BaseDBControl.DB_NAME).getPath()).delete()) {
                        sQLiteDatabase = super.getReadableDatabase();
                    } else {
                        if (BaseDBControl.DEBUG) {
                            Log.e(BaseDBControl.TAG, "DbOpenHelper.getReadableDatabase() throw Exception, but failed to delete it.");
                        }
                        sQLiteDatabase = null;
                    }
                } else {
                    throw new RuntimeException(e);
                }
            }
            return sQLiteDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public synchronized SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (Exception e) {
                e.printStackTrace();
                if (!BaseDBControl.DEBUG) {
                    if (new File(BaseDBControl.mContext.getDatabasePath(BaseDBControl.DB_NAME).getPath()).delete()) {
                        sQLiteDatabase = super.getWritableDatabase();
                    } else {
                        if (BaseDBControl.DEBUG) {
                            Log.e(BaseDBControl.TAG, "DbOpenHelper.getWritableDatabase() throw Exception, but failed to delete it.");
                        }
                        sQLiteDatabase = null;
                    }
                } else {
                    throw new RuntimeException(e);
                }
            }
            return sQLiteDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(AuthenticateControl.getCreateMsgTableSql());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            super.onOpen(sQLiteDatabase);
            this.mPath = sQLiteDatabase.getPath();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (BaseDBControl.DEBUG) {
                String str = BaseDBControl.TAG;
                Log.i(str, "DB new version= " + i2 + "DB old version=" + i);
            }
            while (i < i2) {
                i++;
            }
        }
    }

    public BaseDBControl(Context context, Executor executor, SQLiteOpenHelper sQLiteOpenHelper) {
        mContext = context;
        this.mExecutor = executor;
        this.mOpenHelper = sQLiteOpenHelper;
    }

    public void runTransactionAsync(SQLiteTransaction sQLiteTransaction) {
        runTransactionAsync(sQLiteTransaction, null);
    }

    public void runTransactionSync(SQLiteTransaction sQLiteTransaction) {
        sQLiteTransaction.run(this.mOpenHelper.getWritableDatabase());
    }

    public void runTransactionAsync(final SQLiteTransaction sQLiteTransaction, final OnTransactionFinishedListener onTransactionFinishedListener) {
        this.mExecutor.execute(new Runnable() { // from class: com.baidu.searchbox.schemeauthenticate.database.BaseDBControl.1
            @Override // java.lang.Runnable
            public void run() {
                OnTransactionFinishedListener onTransactionFinishedListener2;
                sQLiteTransaction.run(BaseDBControl.this.mOpenHelper.getWritableDatabase());
                if (sQLiteTransaction.isTransactionSuccess() && (onTransactionFinishedListener2 = onTransactionFinishedListener) != null) {
                    onTransactionFinishedListener2.onFinished();
                }
            }
        });
    }

    public boolean runTransactionSyncWithReturn(SQLiteTransaction sQLiteTransaction) {
        SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            try {
                if (sQLiteTransaction.performTransaction(writableDatabase)) {
                    writableDatabase.setTransactionSuccessful();
                    return true;
                }
            } catch (RuntimeException e) {
                if (DEBUG) {
                    Log.e(TAG, "SQLiteTransaction.run()", e);
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    Log.e(TAG, "SQLiteTransaction.run()", e2);
                }
            }
            return false;
        } finally {
            writableDatabase.endTransaction();
        }
    }
}
