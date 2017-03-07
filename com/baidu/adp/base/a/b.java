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
    private SQLiteDatabase oc = null;
    private a.InterfaceC0002a od = null;
    private a oe;

    public b(a aVar) {
        this.oe = aVar;
    }

    public void a(a.InterfaceC0002a interfaceC0002a) {
        this.od = interfaceC0002a;
    }

    public SQLiteDatabase ci() {
        return k(true);
    }

    protected SQLiteDatabase k(boolean z) {
        l(z);
        return this.oc;
    }

    private void l(boolean z) {
        synchronized (b.class) {
            if (this.oc == null || !this.oc.isOpen()) {
                try {
                    this.oe.a(this.od);
                    this.oc = this.oe.getWritableDatabase();
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

    public boolean u(String str) {
        SQLiteDatabase ci = ci();
        if (ci != null) {
            try {
                ci.execSQL(str);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean g(String str, Object[] objArr) {
        SQLiteDatabase ci = ci();
        if (ci != null) {
            try {
                ci.execSQL(str, objArr);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public Cursor rawQuery(String str, String[] strArr) throws Exception {
        SQLiteDatabase k = k(false);
        if (k != null) {
            return k.rawQuery(str, strArr);
        }
        throw new SQLException("unable to open database.");
    }

    public void cj() {
        try {
            if (this.oc != null) {
                this.oc.close();
                this.oc = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean ck() {
        boolean ab;
        synchronized (b.class) {
            cj();
            try {
                ab = this.oe.ab(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.oc = null;
                return false;
            }
        }
        return ab;
    }

    public void a(Throwable th, String str) {
        int i;
        if (th != null && (th instanceof SQLiteException)) {
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    ck();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.oc = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.oc = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.oc = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.oc = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.oc = null;
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
