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
    private SQLiteDatabase vs = null;
    private a.InterfaceC0014a vt = null;
    private a vu;

    public b(a aVar) {
        this.vu = aVar;
    }

    public void a(a.InterfaceC0014a interfaceC0014a) {
        this.vt = interfaceC0014a;
    }

    public SQLiteDatabase ge() {
        return v(true);
    }

    protected SQLiteDatabase v(boolean z) {
        w(z);
        return this.vs;
    }

    private void w(boolean z) {
        synchronized (b.class) {
            if (this.vs == null || !this.vs.isOpen()) {
                try {
                    this.vu.a(this.vt);
                    this.vs = this.vu.getWritableDatabase();
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

    public boolean af(String str) {
        SQLiteDatabase ge = ge();
        if (ge != null) {
            try {
                ge.execSQL(str);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean f(String str, Object[] objArr) {
        SQLiteDatabase ge = ge();
        if (ge != null) {
            try {
                ge.execSQL(str, objArr);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public Cursor rawQuery(String str, String[] strArr) throws Exception {
        SQLiteDatabase v = v(false);
        if (v != null) {
            return v.rawQuery(str, strArr);
        }
        throw new SQLException("unable to open database.");
    }

    public void gf() {
        try {
            if (this.vs != null) {
                this.vs.close();
                this.vs = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean gg() {
        boolean aL;
        synchronized (b.class) {
            gf();
            try {
                aL = this.vu.aL(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.vs = null;
                return false;
            }
        }
        return aL;
    }

    public void a(Throwable th, String str) {
        int i;
        if (th != null && (th instanceof SQLiteException)) {
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    gg();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.vs = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.vs = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.vs = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.vs = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.vs = null;
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
