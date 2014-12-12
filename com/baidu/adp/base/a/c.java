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
    private SQLiteDatabase cl = null;
    private b cm = null;
    private a cn;

    public c(a aVar) {
        this.cn = aVar;
    }

    public void a(b bVar) {
        this.cm = bVar;
    }

    public SQLiteDatabase ak() {
        return g(true);
    }

    protected SQLiteDatabase g(boolean z) {
        h(z);
        return this.cl;
    }

    private void h(boolean z) {
        synchronized (c.class) {
            if (this.cl == null || !this.cl.isOpen()) {
                try {
                    this.cn.a(this.cm);
                    this.cl = this.cn.getWritableDatabase();
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

    public boolean t(String str) {
        SQLiteDatabase ak = ak();
        if (ak != null) {
            try {
                ak.execSQL(str);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean a(String str, Object[] objArr) {
        SQLiteDatabase ak = ak();
        if (ak != null) {
            try {
                ak.execSQL(str, objArr);
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

    public void al() {
        try {
            if (this.cl != null) {
                this.cl.close();
                this.cl = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean am() {
        boolean E;
        synchronized (c.class) {
            al();
            try {
                E = this.cn.E(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.cl = null;
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
                    am();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.cl = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.cl = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.cl = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.cl = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.cl = null;
                i = -17;
            }
            a(str, i, th.getMessage(), new Object[0]);
        }
    }

    protected void a(String str, int i, String str2, Object... objArr) {
        try {
            f.es().b(str, null, "", i, str2, objArr);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
