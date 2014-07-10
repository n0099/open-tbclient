package com.baidu.tbadk.core.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class DatabaseManager {
    private static volatile SQLiteDatabase a = null;
    private static volatile SQLiteDatabase b = null;
    private static u d = null;
    private DatabaseLocation c;

    /* loaded from: classes.dex */
    public enum DatabaseLocation {
        INNER,
        SDCARD;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static DatabaseLocation[] valuesCustom() {
            DatabaseLocation[] valuesCustom = values();
            int length = valuesCustom.length;
            DatabaseLocation[] databaseLocationArr = new DatabaseLocation[length];
            System.arraycopy(valuesCustom, 0, databaseLocationArr, 0, length);
            return databaseLocationArr;
        }
    }

    public static void a(Throwable th, String str) {
        if (th != null) {
            TiebaStatic.printDBExceptionLog(th, str, new Object[0]);
            if ((th instanceof SQLiteException) && (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException)) {
                try {
                    s.a(TbadkApplication.m252getInst().getApp());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                a = null;
            }
        }
    }

    public DatabaseManager() {
        synchronized (DatabaseManager.class) {
            this.c = DatabaseLocation.INNER;
            if (a == null || !a.isOpen()) {
                try {
                    a = new s(TbadkApplication.m252getInst().getApp()).getWritableDatabase();
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "DatabaseService", new Object[0]);
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    public static void a(u uVar) {
        d = uVar;
    }

    public DatabaseManager(DatabaseLocation databaseLocation) {
        synchronized (DatabaseManager.class) {
            this.c = databaseLocation;
            if (this.c != DatabaseLocation.SDCARD || b == null || !b.isOpen()) {
                if (this.c != DatabaseLocation.INNER || a == null || !a.isOpen()) {
                    try {
                        if (this.c == DatabaseLocation.SDCARD) {
                            t tVar = new t();
                            tVar.a(d);
                            b = tVar.a();
                        } else {
                            a = new s(TbadkApplication.m252getInst().getApp()).getWritableDatabase();
                        }
                    } catch (Exception e) {
                        TiebaStatic.printDBExceptionLog(e, "DatabaseService", new Object[0]);
                        BdLog.e(e.getMessage());
                    }
                }
            }
        }
    }

    public boolean a(String str) {
        try {
            if (this.c == DatabaseLocation.SDCARD && b != null) {
                b.execSQL(str);
                return true;
            } else if (this.c == DatabaseLocation.INNER && a != null) {
                a.execSQL(str);
                return true;
            } else {
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            throw e;
        }
    }

    public static SQLiteDatabase a() {
        new DatabaseManager();
        return a;
    }

    public Boolean a(String str, Object[] objArr) {
        try {
            if (this.c == DatabaseLocation.SDCARD && b != null) {
                b.execSQL(str, objArr);
            } else if (this.c == DatabaseLocation.INNER && a != null) {
                a.execSQL(str, objArr);
            }
            return true;
        } catch (Exception e) {
            BdLog.e(String.valueOf(str) + e.getMessage());
            throw e;
        }
    }

    public Cursor a(String str, String[] strArr) {
        try {
            if (this.c == DatabaseLocation.SDCARD && b != null) {
                return b.rawQuery(str, strArr);
            }
            if (this.c != DatabaseLocation.INNER || a == null) {
                return null;
            }
            return a.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            throw e;
        }
    }

    public void b() {
        synchronized (DatabaseManager.class) {
            try {
                b.close();
            } catch (Exception e) {
            }
            try {
                z.j(TbConfig.TMP_DATABASE_NAME);
            } catch (Exception e2) {
            }
            b = null;
        }
    }

    public void a(Context context) {
        synchronized (DatabaseManager.class) {
            try {
                a.close();
            } catch (Exception e) {
            }
            try {
                context.deleteDatabase(TbConfig.PHONE_DATEBASE_NAME);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            a = null;
        }
    }
}
