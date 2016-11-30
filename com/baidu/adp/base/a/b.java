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
import com.baidu.adp.lib.util.BdLog;
import java.sql.SQLException;
/* loaded from: classes.dex */
public class b {
    private SQLiteDatabase gn = null;
    private a.InterfaceC0003a go = null;
    private a gp;

    public b(a aVar) {
        this.gp = aVar;
    }

    public void a(a.InterfaceC0003a interfaceC0003a) {
        this.go = interfaceC0003a;
    }

    public SQLiteDatabase aZ() {
        return j(true);
    }

    protected SQLiteDatabase j(boolean z) {
        k(z);
        return this.gn;
    }

    private void k(boolean z) {
        synchronized (b.class) {
            if (this.gn == null || !this.gn.isOpen()) {
                try {
                    this.gp.a(this.go);
                    this.gn = this.gp.getWritableDatabase();
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

    public boolean x(String str) {
        SQLiteDatabase aZ = aZ();
        if (aZ != null) {
            try {
                aZ.execSQL(str);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean g(String str, Object[] objArr) {
        SQLiteDatabase aZ = aZ();
        if (aZ != null) {
            try {
                aZ.execSQL(str, objArr);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public Cursor rawQuery(String str, String[] strArr) throws Exception {
        SQLiteDatabase j = j(false);
        if (j != null) {
            return j.rawQuery(str, strArr);
        }
        throw new SQLException("unable to open database.");
    }

    public void ba() {
        try {
            if (this.gn != null) {
                this.gn.close();
                this.gn = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean bb() {
        boolean D;
        synchronized (b.class) {
            ba();
            try {
                D = this.gp.D(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.gn = null;
                return false;
            }
        }
        return D;
    }

    public void a(Throwable th, String str) {
        int i;
        if (th != null && (th instanceof SQLiteException)) {
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    bb();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.gn = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.gn = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.gn = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.gn = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.gn = null;
                i = -17;
            }
            a(str, i, th.getMessage(), new Object[0]);
        }
    }

    protected void a(String str, int i, String str2, Object... objArr) {
        try {
            com.baidu.adp.lib.stats.a.eI().b(str, "", i, str2, objArr);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
