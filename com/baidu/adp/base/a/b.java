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
    private SQLiteDatabase lP = null;
    private a.InterfaceC0003a lQ = null;
    private a lR;

    public b(a aVar) {
        this.lR = aVar;
    }

    public void a(a.InterfaceC0003a interfaceC0003a) {
        this.lQ = interfaceC0003a;
    }

    public SQLiteDatabase bQ() {
        return l(true);
    }

    protected SQLiteDatabase l(boolean z) {
        m(z);
        return this.lP;
    }

    private void m(boolean z) {
        synchronized (b.class) {
            if (this.lP == null || !this.lP.isOpen()) {
                try {
                    this.lR.a(this.lQ);
                    this.lP = this.lR.getWritableDatabase();
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

    public boolean C(String str) {
        SQLiteDatabase bQ = bQ();
        if (bQ != null) {
            try {
                bQ.execSQL(str);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean f(String str, Object[] objArr) {
        SQLiteDatabase bQ = bQ();
        if (bQ != null) {
            try {
                bQ.execSQL(str, objArr);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public Cursor rawQuery(String str, String[] strArr) throws Exception {
        SQLiteDatabase l = l(false);
        if (l != null) {
            return l.rawQuery(str, strArr);
        }
        throw new SQLException("unable to open database.");
    }

    public void bR() {
        try {
            if (this.lP != null) {
                this.lP.close();
                this.lP = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean bS() {
        boolean ac;
        synchronized (b.class) {
            bR();
            try {
                ac = this.lR.ac(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.lP = null;
                return false;
            }
        }
        return ac;
    }

    public void a(Throwable th, String str) {
        int i;
        if (th != null && (th instanceof SQLiteException)) {
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    bS();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.lP = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.lP = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.lP = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.lP = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.lP = null;
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
