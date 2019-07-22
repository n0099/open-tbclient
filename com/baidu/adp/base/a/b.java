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
    private SQLiteDatabase sV = null;
    private a.InterfaceC0012a sW = null;
    private a sX;

    public b(a aVar) {
        this.sX = aVar;
    }

    public void a(a.InterfaceC0012a interfaceC0012a) {
        this.sW = interfaceC0012a;
    }

    public SQLiteDatabase fa() {
        return B(true);
    }

    protected SQLiteDatabase B(boolean z) {
        C(z);
        return this.sV;
    }

    private void C(boolean z) {
        synchronized (b.class) {
            if (this.sV == null || !this.sV.isOpen()) {
                try {
                    this.sX.a(this.sW);
                    this.sV = this.sX.getWritableDatabase();
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

    public boolean O(String str) {
        SQLiteDatabase fa = fa();
        if (fa != null) {
            try {
                fa.execSQL(str);
                return true;
            } catch (Throwable th) {
                c(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean f(String str, Object[] objArr) {
        SQLiteDatabase fa = fa();
        if (fa != null) {
            try {
                fa.execSQL(str, objArr);
                return true;
            } catch (Throwable th) {
                c(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public Cursor b(String str, String[] strArr) throws Exception {
        SQLiteDatabase B = B(false);
        if (B != null) {
            return B.rawQuery(str, strArr);
        }
        throw new SQLException("unable to open database.");
    }

    public void fb() {
        try {
            if (this.sV != null) {
                this.sV.close();
                this.sV = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean fc() {
        boolean ac;
        synchronized (b.class) {
            fb();
            try {
                ac = this.sX.ac(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.sV = null;
                return false;
            }
        }
        return ac;
    }

    public void c(Throwable th, String str) {
        int i;
        if (th != null && (th instanceof SQLiteException)) {
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    fc();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.sV = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.sV = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.sV = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.sV = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.sV = null;
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
