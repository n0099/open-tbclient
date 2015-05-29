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
    private a nB;
    private SQLiteDatabase nz = null;
    private b nA = null;

    public c(a aVar) {
        this.nB = aVar;
    }

    public void a(b bVar) {
        this.nA = bVar;
    }

    public SQLiteDatabase dK() {
        return g(true);
    }

    protected SQLiteDatabase g(boolean z) {
        h(z);
        return this.nz;
    }

    private void h(boolean z) {
        synchronized (c.class) {
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
        SQLiteDatabase dK = dK();
        if (dK != null) {
            try {
                dK.execSQL(str);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean a(String str, Object[] objArr) {
        SQLiteDatabase dK = dK();
        if (dK != null) {
            try {
                dK.execSQL(str, objArr);
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

    public void dL() {
        try {
            if (this.nz != null) {
                this.nz.close();
                this.nz = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean dM() {
        boolean E;
        synchronized (c.class) {
            dL();
            try {
                E = this.nB.E(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.nz = null;
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
                    dM();
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
            f.hz().b(str, null, "", i, str2, objArr);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
