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
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.util.BdLog;
import java.sql.SQLException;
/* loaded from: classes.dex */
public class c {
    private SQLiteDatabase nw = null;
    private b nx = null;
    private a ny;

    public c(a aVar) {
        this.ny = aVar;
    }

    public void a(b bVar) {
        this.nx = bVar;
    }

    public SQLiteDatabase dI() {
        return g(true);
    }

    protected SQLiteDatabase g(boolean z) {
        h(z);
        return this.nw;
    }

    private void h(boolean z) {
        synchronized (c.class) {
            if (this.nw == null || !this.nw.isOpen()) {
                try {
                    this.ny.a(this.nx);
                    this.nw = this.ny.getWritableDatabase();
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

    public boolean D(String str) {
        SQLiteDatabase dI = dI();
        if (dI != null) {
            try {
                dI.execSQL(str);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean a(String str, Object[] objArr) {
        SQLiteDatabase dI = dI();
        if (dI != null) {
            try {
                dI.execSQL(str, objArr);
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

    public void dJ() {
        try {
            if (this.nw != null) {
                this.nw.close();
                this.nw = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean dK() {
        boolean E;
        synchronized (c.class) {
            dJ();
            try {
                E = this.ny.E(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.nw = null;
                return false;
            }
        }
        return E;
    }

    public void a(Throwable th, String str) {
        int i;
        if (th != null && (th instanceof SQLiteException)) {
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    dK();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.nw = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.nw = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.nw = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.nw = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.nw = null;
                i = -17;
            }
            a(str, i, th.getMessage(), new Object[0]);
        }
    }

    protected void a(String str, int i, String str2, Object... objArr) {
        try {
            f.hP().b(str, null, "", i, str2, objArr);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
