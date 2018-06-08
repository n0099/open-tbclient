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
    private SQLiteDatabase sl = null;
    private a.InterfaceC0011a sm = null;
    private a so;

    public b(a aVar) {
        this.so = aVar;
    }

    public void a(a.InterfaceC0011a interfaceC0011a) {
        this.sm = interfaceC0011a;
    }

    public SQLiteDatabase eE() {
        return n(true);
    }

    protected SQLiteDatabase n(boolean z) {
        o(z);
        return this.sl;
    }

    private void o(boolean z) {
        synchronized (b.class) {
            if (this.sl == null || !this.sl.isOpen()) {
                try {
                    this.so.a(this.sm);
                    this.sl = this.so.getWritableDatabase();
                } catch (RuntimeException e) {
                    if (z) {
                        a(e, "ensureDatabaseReady");
                    } else {
                        throw e;
                    }
                }
            }
        }
    }

    public boolean O(String str) {
        SQLiteDatabase eE = eE();
        if (eE != null) {
            try {
                eE.execSQL(str);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean f(String str, Object[] objArr) {
        SQLiteDatabase eE = eE();
        if (eE != null) {
            try {
                eE.execSQL(str, objArr);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public Cursor rawQuery(String str, String[] strArr) throws Exception {
        SQLiteDatabase n = n(false);
        if (n != null) {
            return n.rawQuery(str, strArr);
        }
        throw new SQLException("unable to open database.");
    }

    public void eF() {
        try {
            if (this.sl != null) {
                this.sl.close();
                this.sl = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean eG() {
        boolean ae;
        synchronized (b.class) {
            eF();
            try {
                ae = this.so.ae(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.sl = null;
                return false;
            }
        }
        return ae;
    }

    public void a(Throwable th, String str) {
        int i;
        if (th != null && (th instanceof SQLiteException)) {
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    eG();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.sl = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.sl = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.sl = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.sl = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.sl = null;
                i = -17;
            }
            a(str, i, th.getMessage(), new Object[0]);
        }
    }

    protected void a(String str, int i, String str2, Object... objArr) {
        try {
            BdStatisticsManager.getInstance().db(str, "", i, str2, objArr);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
