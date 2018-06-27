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
    private SQLiteDatabase sj = null;
    private a.InterfaceC0011a sk = null;
    private a sl;

    public b(a aVar) {
        this.sl = aVar;
    }

    public void a(a.InterfaceC0011a interfaceC0011a) {
        this.sk = interfaceC0011a;
    }

    public SQLiteDatabase eE() {
        return n(true);
    }

    protected SQLiteDatabase n(boolean z) {
        o(z);
        return this.sj;
    }

    private void o(boolean z) {
        synchronized (b.class) {
            if (this.sj == null || !this.sj.isOpen()) {
                try {
                    this.sl.a(this.sk);
                    this.sj = this.sl.getWritableDatabase();
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
            if (this.sj != null) {
                this.sj.close();
                this.sj = null;
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
                ae = this.sl.ae(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.sj = null;
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
                this.sj = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.sj = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.sj = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.sj = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.sj = null;
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
