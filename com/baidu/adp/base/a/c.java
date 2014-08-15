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
    private SQLiteDatabase a = null;
    private b b = null;
    private a c;

    public c(a aVar) {
        this.c = aVar;
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    public SQLiteDatabase a() {
        return a(true);
    }

    protected SQLiteDatabase a(boolean z) {
        b(z);
        return this.a;
    }

    private void b(boolean z) {
        synchronized (c.class) {
            if (this.a == null || !this.a.isOpen()) {
                try {
                    this.c.a(this.b);
                    this.a = this.c.getWritableDatabase();
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

    public boolean a(String str) {
        SQLiteDatabase a = a();
        if (a != null) {
            try {
                a.execSQL(str);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean a(String str, Object[] objArr) {
        SQLiteDatabase a = a();
        if (a != null) {
            try {
                a.execSQL(str, objArr);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public Cursor a(String str, String[] strArr) {
        SQLiteDatabase a = a(false);
        if (a != null) {
            return a.rawQuery(str, strArr);
        }
        throw new SQLException("unable to open database.");
    }

    public void b() {
        try {
            if (this.a != null) {
                this.a.close();
                this.a = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean c() {
        boolean a;
        synchronized (c.class) {
            b();
            try {
                a = this.c.a(BdBaseApplication.getInst());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.a = null;
                return false;
            }
        }
        return a;
    }

    public void a(Throwable th, String str) {
        int i;
        if (th != null && (th instanceof SQLiteException)) {
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    c();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.a = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.a = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.a = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.a = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.a = null;
                i = -17;
            }
            a(str, i, th.getMessage(), new Object[0]);
        }
    }

    protected void a(String str, int i, String str2, Object... objArr) {
        try {
            f.c().b(str, null, "", i, str2, objArr);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
