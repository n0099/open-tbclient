package com.baidu.adp.base.a;

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
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import java.sql.SQLException;
/* loaded from: classes.dex */
public class b {
    private a Gm;
    private SQLiteDatabase database = null;
    private a.InterfaceC0017a Gl = null;

    public b(a aVar) {
        this.Gm = aVar;
    }

    public void a(a.InterfaceC0017a interfaceC0017a) {
        this.Gl = interfaceC0017a;
    }

    public SQLiteDatabase getOpenedDatabase() {
        return getOpenedDatabase(true);
    }

    protected SQLiteDatabase getOpenedDatabase(boolean z) {
        ensureDatabaseReady(z);
        return this.database;
    }

    private void ensureDatabaseReady(boolean z) {
        synchronized (b.class) {
            if (this.database == null || !this.database.isOpen()) {
                try {
                    this.Gm.a(this.Gl);
                    this.database = this.Gm.getWritableDatabase();
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
        synchronized (b.class) {
            closeDatabase();
            try {
                dropDatabase = this.Gm.dropDatabase(BdBaseApplication.getInst().getContext());
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
