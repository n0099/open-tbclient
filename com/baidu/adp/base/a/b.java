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
    private SQLiteDatabase dw = null;
    private a.InterfaceC0003a dx = null;
    private a dy;

    public b(a aVar) {
        this.dy = aVar;
    }

    public void a(a.InterfaceC0003a interfaceC0003a) {
        this.dx = interfaceC0003a;
    }

    public SQLiteDatabase ae() {
        return f(true);
    }

    protected SQLiteDatabase f(boolean z) {
        g(z);
        return this.dw;
    }

    private void g(boolean z) {
        synchronized (b.class) {
            if (this.dw == null || !this.dw.isOpen()) {
                try {
                    this.dy.a(this.dx);
                    this.dw = this.dy.getWritableDatabase();
                } catch (RuntimeException e) {
                    if (z) {
                        d(e, "ensureDatabaseReady");
                    } else {
                        throw e;
                    }
                }
            }
        }
    }

    public boolean s(String str) {
        SQLiteDatabase ae = ae();
        if (ae != null) {
            try {
                ae.execSQL(str);
                return true;
            } catch (Throwable th) {
                d(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean b(String str, Object[] objArr) {
        SQLiteDatabase ae = ae();
        if (ae != null) {
            try {
                ae.execSQL(str, objArr);
                return true;
            } catch (Throwable th) {
                d(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase f = f(false);
        if (f != null) {
            return f.rawQuery(str, strArr);
        }
        throw new SQLException("unable to open database.");
    }

    public void af() {
        try {
            if (this.dw != null) {
                this.dw.close();
                this.dw = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean ag() {
        boolean t;
        synchronized (b.class) {
            af();
            try {
                t = this.dy.t(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.dw = null;
                return false;
            }
        }
        return t;
    }

    public void d(Throwable th, String str) {
        int i;
        if (th != null && (th instanceof SQLiteException)) {
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    ag();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.dw = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.dw = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.dw = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.dw = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.dw = null;
                i = -17;
            }
            a(str, i, th.getMessage(), new Object[0]);
        }
    }

    protected void a(String str, int i, String str2, Object... objArr) {
        try {
            com.baidu.adp.lib.stats.a.dO().b(str, "", i, str2, objArr);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
