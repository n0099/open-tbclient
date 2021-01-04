package com.baidu.live.adp.base.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteMisuseException;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.base.db.BdDatabaseHelper;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.util.BdLog;
import java.sql.SQLException;
/* loaded from: classes11.dex */
public class DatabaseManager {
    static final int ERR_SQLITE_ABORT = -11;
    static final int ERR_SQLITE_CONSTRAINT = -12;
    static final int ERR_SQLITE_DATABASE_CORRUPT = -14;
    static final int ERR_SQLITE_DISK_IO = -15;
    static final int ERR_SQLITE_DONE = -19;
    static final int ERR_SQLITE_FULL = -16;
    static final int ERR_SQLITE_UNKNOWN = -17;
    private BdDatabaseHelper databaseHelper;
    private SQLiteDatabase database = null;
    private BdDatabaseHelper.OnDatabaseCreatedCallback mOnCreateCallback = null;

    public DatabaseManager(BdDatabaseHelper bdDatabaseHelper) {
        this.databaseHelper = bdDatabaseHelper;
    }

    public void setOnCreateCallback(BdDatabaseHelper.OnDatabaseCreatedCallback onDatabaseCreatedCallback) {
        this.mOnCreateCallback = onDatabaseCreatedCallback;
    }

    public SQLiteDatabase getOpenedDatabase() {
        return getOpenedDatabase(true);
    }

    protected SQLiteDatabase getOpenedDatabase(boolean z) {
        ensureDatabaseReady(z);
        return this.database;
    }

    private void ensureDatabaseReady(boolean z) {
        synchronized (DatabaseManager.class) {
            if (this.database == null || !this.database.isOpen()) {
                try {
                    this.databaseHelper.setOnCreateCallback(this.mOnCreateCallback);
                    this.database = this.databaseHelper.getWritableDatabase();
                } catch (RuntimeException e) {
                    if (z) {
                        notifySQLException(e, "ensureDatabaseReady");
                    } else {
                        throw e;
                    }
                }
            }
        }
    }

    public int getVersion() {
        SQLiteDatabase openedDatabase = getOpenedDatabase();
        if (openedDatabase != null) {
            return openedDatabase.getVersion();
        }
        return 0;
    }

    public boolean execSQLNoException(String str) {
        SQLiteDatabase openedDatabase = getOpenedDatabase();
        if (openedDatabase != null) {
            try {
                openedDatabase.execSQL(str);
                return true;
            } catch (Throwable th) {
                notifySQLException(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean execSQLNoException(String str, Object[] objArr) {
        SQLiteDatabase openedDatabase = getOpenedDatabase();
        if (openedDatabase != null) {
            try {
                openedDatabase.execSQL(str, objArr);
                return true;
            } catch (Throwable th) {
                notifySQLException(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public Cursor rawQuery(String str, String[] strArr) throws Exception {
        SQLiteDatabase openedDatabase = getOpenedDatabase(false);
        if (openedDatabase != null) {
            return openedDatabase.rawQuery(str, strArr);
        }
        throw new SQLException("unable to open database.");
    }

    public void closeDatabase() {
        try {
            if (this.database != null) {
                this.database.close();
                this.database = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean deleteDatabase() {
        boolean dropDatabase;
        synchronized (DatabaseManager.class) {
            closeDatabase();
            try {
                dropDatabase = this.databaseHelper.dropDatabase(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.database = null;
                return false;
            }
        }
        return dropDatabase;
    }

    public void notifySQLException(Throwable th, String str) {
        int i;
        if (th != null && (th instanceof SQLiteException)) {
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    deleteDatabase();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.database = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.database = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.database = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.database = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.database = null;
                i = -17;
            }
            logDBException(str, i, th.getMessage(), new Object[0]);
        }
    }

    protected void logDBException(String str, int i, String str2, Object... objArr) {
        try {
            BdStatisticsManager.getInstance().db(str, "", i, str2, objArr);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
