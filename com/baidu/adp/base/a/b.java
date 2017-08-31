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
    private SQLiteDatabase mU = null;
    private a.InterfaceC0001a mV = null;
    private a mW;

    public b(a aVar) {
        this.mW = aVar;
    }

    public void a(a.InterfaceC0001a interfaceC0001a) {
        this.mV = interfaceC0001a;
    }

    public SQLiteDatabase ch() {
        return k(true);
    }

    protected SQLiteDatabase k(boolean z) {
        l(z);
        return this.mU;
    }

    private void l(boolean z) {
        synchronized (b.class) {
            if (this.mU == null || !this.mU.isOpen()) {
                try {
                    this.mW.a(this.mV);
                    this.mU = this.mW.getWritableDatabase();
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

    public boolean y(String str) {
        SQLiteDatabase ch = ch();
        if (ch != null) {
            try {
                ch.execSQL(str);
                return true;
            } catch (Throwable th) {
                a(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean a(String str, Object[] objArr) {
        SQLiteDatabase ch = ch();
        if (ch != null) {
            try {
                ch.execSQL(str, objArr);
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

    public void ci() {
        try {
            if (this.mU != null) {
                this.mU.close();
                this.mU = null;
            }
        } catch (Exception e) {
            BdLog.e("closeDatabase：" + e.getMessage());
        }
    }

    public boolean cj() {
        boolean Y;
        synchronized (b.class) {
            ci();
            try {
                Y = this.mW.Y(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.mU = null;
                return false;
            }
        }
        return Y;
    }

    public void a(Throwable th, String str) {
        int i;
        if (th != null && (th instanceof SQLiteException)) {
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    cj();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.mU = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.mU = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.mU = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.mU = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.mU = null;
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
