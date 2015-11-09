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
import com.baidu.adp.lib.util.BdLog;
import java.sql.SQLException;
/* loaded from: classes.dex */
public class b {
    private a nB;
    private SQLiteDatabase nz = null;
    private a.InterfaceC0001a nA = null;

    public b(a aVar) {
        this.nB = aVar;
    }

    public void a(a.InterfaceC0001a interfaceC0001a) {
        this.nA = interfaceC0001a;
    }

    public SQLiteDatabase dL() {
        return g(true);
    }

    protected SQLiteDatabase g(boolean z) {
        h(z);
        return this.nz;
    }

    private void h(boolean z) {
        synchronized (b.class) {
            if (this.nz == null || !this.nz.isOpen()) {
                try {
                    this.nB.a(this.nA);
                    this.nz = this.nB.getWritableDatabase();
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

    public boolean E(String str) {
        SQLiteDatabase dL = dL();
        if (dL != null) {
            try {
                dL.execSQL(str);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean a(String str, Object[] objArr) {
        SQLiteDatabase dL = dL();
        if (dL != null) {
            try {
                dL.execSQL(str, objArr);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase g = g(false);
        if (g != null) {
            return g.rawQuery(str, strArr);
        }
        throw new SQLException("unable to open database.");
    }

    public void dM() {
        try {
            if (this.nz != null) {
                this.nz.close();
                this.nz = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean dN() {
        boolean D;
        synchronized (b.class) {
            dM();
            try {
                D = this.nB.D(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.nz = null;
                return false;
            }
        }
        return D;
    }

    public void a(Throwable th, String str) {
        int i;
        if (th != null && (th instanceof SQLiteException)) {
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    dN();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.nz = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.nz = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.nz = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.nz = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.nz = null;
                i = -17;
            }
            a(str, i, th.getMessage(), new Object[0]);
        }
    }

    protected void a(String str, int i, String str2, Object... objArr) {
        try {
            com.baidu.adp.lib.stats.a.hj().b(str, "", i, str2, objArr);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
