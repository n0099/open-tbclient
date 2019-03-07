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
    private SQLiteDatabase vq = null;
    private a.InterfaceC0012a vr = null;
    private a vs;

    public b(a aVar) {
        this.vs = aVar;
    }

    public void a(a.InterfaceC0012a interfaceC0012a) {
        this.vr = interfaceC0012a;
    }

    public SQLiteDatabase ga() {
        return J(true);
    }

    protected SQLiteDatabase J(boolean z) {
        K(z);
        return this.vq;
    }

    private void K(boolean z) {
        synchronized (b.class) {
            if (this.vq == null || !this.vq.isOpen()) {
                try {
                    this.vs.a(this.vr);
                    this.vq = this.vs.getWritableDatabase();
                } catch (RuntimeException e) {
                    if (z) {
                        c(e, "ensureDatabaseReady");
                    } else {
                        throw e;
                    }
                }
            }
        }
    }

    public boolean af(String str) {
        SQLiteDatabase ga = ga();
        if (ga != null) {
            try {
                ga.execSQL(str);
                return true;
            } catch (Throwable th) {
                c(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean f(String str, Object[] objArr) {
        SQLiteDatabase ga = ga();
        if (ga != null) {
            try {
                ga.execSQL(str, objArr);
                return true;
            } catch (Throwable th) {
                c(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public Cursor rawQuery(String str, String[] strArr) throws Exception {
        SQLiteDatabase J = J(false);
        if (J != null) {
            return J.rawQuery(str, strArr);
        }
        throw new SQLException("unable to open database.");
    }

    public void gb() {
        try {
            if (this.vq != null) {
                this.vq.close();
                this.vq = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean gd() {
        boolean aL;
        synchronized (b.class) {
            gb();
            try {
                aL = this.vs.aL(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.vq = null;
                return false;
            }
        }
        return aL;
    }

    public void c(Throwable th, String str) {
        int i;
        if (th != null && (th instanceof SQLiteException)) {
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    gd();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.vq = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.vq = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.vq = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.vq = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.vq = null;
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
