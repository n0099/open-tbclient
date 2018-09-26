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
    private SQLiteDatabase uF = null;
    private a.InterfaceC0011a uG = null;
    private a uH;

    public b(a aVar) {
        this.uH = aVar;
    }

    public void a(a.InterfaceC0011a interfaceC0011a) {
        this.uG = interfaceC0011a;
    }

    public SQLiteDatabase fL() {
        return v(true);
    }

    protected SQLiteDatabase v(boolean z) {
        w(z);
        return this.uF;
    }

    private void w(boolean z) {
        synchronized (b.class) {
            if (this.uF == null || !this.uF.isOpen()) {
                try {
                    this.uH.a(this.uG);
                    this.uF = this.uH.getWritableDatabase();
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
        SQLiteDatabase fL = fL();
        if (fL != null) {
            try {
                fL.execSQL(str);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean f(String str, Object[] objArr) {
        SQLiteDatabase fL = fL();
        if (fL != null) {
            try {
                fL.execSQL(str, objArr);
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

    public void fM() {
        try {
            if (this.uF != null) {
                this.uF.close();
                this.uF = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean fN() {
        boolean aL;
        synchronized (b.class) {
            fM();
            try {
                aL = this.uH.aL(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.uF = null;
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
                    fN();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.uF = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.uF = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.uF = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.uF = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.uF = null;
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
