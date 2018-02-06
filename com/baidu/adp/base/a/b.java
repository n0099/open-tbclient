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
    private SQLiteDatabase abI = null;
    private a.InterfaceC0014a abJ = null;
    private a abK;

    public b(a aVar) {
        this.abK = aVar;
    }

    public void a(a.InterfaceC0014a interfaceC0014a) {
        this.abJ = interfaceC0014a;
    }

    public SQLiteDatabase jM() {
        return T(true);
    }

    protected SQLiteDatabase T(boolean z) {
        U(z);
        return this.abI;
    }

    private void U(boolean z) {
        synchronized (b.class) {
            if (this.abI == null || !this.abI.isOpen()) {
                try {
                    this.abK.a(this.abJ);
                    this.abI = this.abK.getWritableDatabase();
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

    public boolean F(String str) {
        SQLiteDatabase jM = jM();
        if (jM != null) {
            try {
                jM.execSQL(str);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean f(String str, Object[] objArr) {
        SQLiteDatabase jM = jM();
        if (jM != null) {
            try {
                jM.execSQL(str, objArr);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public Cursor rawQuery(String str, String[] strArr) throws Exception {
        SQLiteDatabase T = T(false);
        if (T != null) {
            return T.rawQuery(str, strArr);
        }
        throw new SQLException("unable to open database.");
    }

    public void jN() {
        try {
            if (this.abI != null) {
                this.abI.close();
                this.abI = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean jO() {
        boolean al;
        synchronized (b.class) {
            jN();
            try {
                al = this.abK.al(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.abI = null;
                return false;
            }
        }
        return al;
    }

    public void a(Throwable th, String str) {
        int i;
        if (th != null && (th instanceof SQLiteException)) {
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    jO();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.abI = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.abI = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.abI = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.abI = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.abI = null;
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
