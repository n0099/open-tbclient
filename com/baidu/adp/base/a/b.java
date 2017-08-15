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
    private SQLiteDatabase pp = null;
    private a.InterfaceC0001a pq = null;
    private a pr;

    public b(a aVar) {
        this.pr = aVar;
    }

    public void a(a.InterfaceC0001a interfaceC0001a) {
        this.pq = interfaceC0001a;
    }

    public SQLiteDatabase cs() {
        return k(true);
    }

    protected SQLiteDatabase k(boolean z) {
        l(z);
        return this.pp;
    }

    private void l(boolean z) {
        synchronized (b.class) {
            if (this.pp == null || !this.pp.isOpen()) {
                try {
                    this.pr.a(this.pq);
                    this.pp = this.pr.getWritableDatabase();
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
        SQLiteDatabase cs = cs();
        if (cs != null) {
            try {
                cs.execSQL(str);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean k(String str, Object[] objArr) {
        SQLiteDatabase cs = cs();
        if (cs != null) {
            try {
                cs.execSQL(str, objArr);
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

    public void ct() {
        try {
            if (this.pp != null) {
                this.pp.close();
                this.pp = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean cu() {
        boolean ab;
        synchronized (b.class) {
            ct();
            try {
                ab = this.pr.ab(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.pp = null;
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
                    cu();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.pp = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.pp = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.pp = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.pp = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.pp = null;
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
