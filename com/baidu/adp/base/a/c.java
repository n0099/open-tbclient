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
    private SQLiteDatabase aA = null;
    private b aB = null;
    private a aC;

    public c(a aVar) {
        this.aC = aVar;
    }

    public void a(b bVar) {
        this.aB = bVar;
    }

    public SQLiteDatabase P() {
        return c(true);
    }

    protected SQLiteDatabase c(boolean z) {
        d(z);
        return this.aA;
    }

    private void d(boolean z) {
        synchronized (c.class) {
            if (this.aA == null || !this.aA.isOpen()) {
                try {
                    this.aC.a(this.aB);
                    this.aA = this.aC.getWritableDatabase();
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

    public boolean g(String str) {
        SQLiteDatabase P = P();
        if (P != null) {
            try {
                P.execSQL(str);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean a(String str, Object[] objArr) {
        SQLiteDatabase P = P();
        if (P != null) {
            try {
                P.execSQL(str, objArr);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase c = c(false);
        if (c != null) {
            return c.rawQuery(str, strArr);
        }
        throw new SQLException("unable to open database.");
    }

    public void Q() {
        try {
            if (this.aA != null) {
                this.aA.close();
                this.aA = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean R() {
        boolean f;
        synchronized (c.class) {
            Q();
            try {
                f = this.aC.f(BdBaseApplication.getInst());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.aA = null;
                return false;
            }
        }
        return f;
    }

    public void a(Throwable th, String str) {
        int i;
        if (th != null && (th instanceof SQLiteException)) {
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    R();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.aA = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.aA = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.aA = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.aA = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.aA = null;
                i = -17;
            }
            a(str, i, th.getMessage(), new Object[0]);
        }
    }

    protected void a(String str, int i, String str2, Object... objArr) {
        try {
            f.er().b(str, null, "", i, str2, objArr);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
