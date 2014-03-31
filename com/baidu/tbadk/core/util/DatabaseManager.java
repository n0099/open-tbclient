package com.baidu.tbadk.core.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class DatabaseManager {
    private static volatile SQLiteDatabase a = null;
    private static volatile SQLiteDatabase b = null;
    private static t d = null;
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
            TiebaStatic.a(th, str, new Object[0]);
            if ((th instanceof SQLiteException) && (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException)) {
                com.baidu.adp.lib.util.f.c("database corrupted.  recreate!");
                try {
                    r.a(TbadkApplication.j().b());
                } catch (Throwable th2) {
                    com.baidu.adp.lib.util.f.b("failed to drop database. msg:" + th2.getMessage());
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
                    a = new r(TbadkApplication.j().b()).getWritableDatabase();
                } catch (Exception e) {
                    TiebaStatic.a(e, "DatabaseService", new Object[0]);
                    com.baidu.adp.lib.util.f.b("DatabaseService", "DatabaseService", "error = " + e.getMessage());
                }
            }
        }
    }

    public static void a(t tVar) {
        d = tVar;
    }

    public DatabaseManager(DatabaseLocation databaseLocation) {
        synchronized (DatabaseManager.class) {
            this.c = databaseLocation;
            if (this.c != DatabaseLocation.SDCARD || b == null || !b.isOpen()) {
                if (this.c == DatabaseLocation.INNER && a != null && a.isOpen()) {
                    return;
                }
                try {
                    if (this.c == DatabaseLocation.SDCARD) {
                        s sVar = new s();
                        sVar.a(d);
                        b = sVar.a();
                    } else {
                        a = new r(TbadkApplication.j().b()).getWritableDatabase();
                    }
                } catch (Exception e) {
                    TiebaStatic.a(e, "DatabaseService", new Object[0]);
                    com.baidu.adp.lib.util.f.b("DatabaseService", "DatabaseService", "error = " + e.getMessage());
                }
            }
        }
    }

    public final boolean a(String str) {
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
            com.baidu.adp.lib.util.f.b(getClass().getName(), "ExecSQL", String.valueOf(str) + "   error = " + e.getMessage());
            throw e;
        }
    }

    public static SQLiteDatabase a() {
        new DatabaseManager();
        return a;
    }

    public final Boolean a(String str, Object[] objArr) {
        try {
            if (this.c == DatabaseLocation.SDCARD && b != null) {
                b.execSQL(str, objArr);
            } else if (this.c == DatabaseLocation.INNER && a != null) {
                a.execSQL(str, objArr);
            }
            return true;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("DatabaseService", "ExecSQL", "error = " + e.getMessage());
            com.baidu.adp.lib.util.f.b("DatabaseService", "ExecSQL", str);
            throw e;
        }
    }

    public final Cursor a(String str, String[] strArr) {
        try {
            if (this.c == DatabaseLocation.SDCARD && b != null) {
                return b.rawQuery(str, strArr);
            }
            if (this.c != DatabaseLocation.INNER || a == null) {
                return null;
            }
            return a.rawQuery(str, strArr);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("DatabaseService", "rawQuery", "error = " + e.getMessage() + " sql = " + str);
            throw e;
        }
    }

    public static void b() {
        synchronized (DatabaseManager.class) {
            try {
                b.close();
            } catch (Exception e) {
            }
            try {
                w.j("tieba_database.db");
            } catch (Exception e2) {
            }
            b = null;
        }
    }
}
