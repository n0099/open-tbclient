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
    private SQLiteDatabase abK = null;
    private a.InterfaceC0014a abL = null;
    private a abM;

    public b(a aVar) {
        this.abM = aVar;
    }

    public void a(a.InterfaceC0014a interfaceC0014a) {
        this.abL = interfaceC0014a;
    }

    public SQLiteDatabase jM() {
        return R(true);
    }

    protected SQLiteDatabase R(boolean z) {
        S(z);
        return this.abK;
    }

    private void S(boolean z) {
        synchronized (b.class) {
            if (this.abK == null || !this.abK.isOpen()) {
                try {
                    this.abM.a(this.abL);
                    this.abK = this.abM.getWritableDatabase();
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

    public boolean b(String str, Object[] objArr) {
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
        SQLiteDatabase R = R(false);
        if (R != null) {
            return R.rawQuery(str, strArr);
        }
        throw new SQLException("unable to open database.");
    }

    public void jN() {
        try {
            if (this.abK != null) {
                this.abK.close();
                this.abK = null;
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
                al = this.abM.al(BdBaseApplication.getInst().getContext());
            } catch (Exception e) {
                BdLog.e("deleteDatabase：" + e.getMessage());
                this.abK = null;
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
                this.abK = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.abK = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.abK = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.abK = null;
            } else if (th instanceof SQLiteMisuseException) {
                i = -17;
            } else {
                this.abK = null;
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
