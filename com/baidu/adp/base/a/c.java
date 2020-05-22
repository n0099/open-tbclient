package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.adp.base.a.a;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class c extends SQLiteOpenHelper implements a {
    private a.InterfaceC0017a Gn;
    private final String databaseName;

    public abstract void clearAllTables(SQLiteDatabase sQLiteDatabase);

    public abstract void createAllTables(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(a.InterfaceC0017a interfaceC0017a) {
        this.Gn = interfaceC0017a;
    }

    public c(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.databaseName = str;
    }

    @Override // com.baidu.adp.base.a.a
    public boolean dropDatabase(Context context) {
        return context.deleteDatabase(this.databaseName);
    }

    public boolean executeDDLSqlIgnoreAnyErrors(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
            return true;
        } catch (Throwable th) {
            BdLog.e(str + ":" + th.getMessage());
            return false;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createAllTables(sQLiteDatabase);
        exeCallback(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        clearAllTables(sQLiteDatabase);
        createAllTables(sQLiteDatabase);
    }

    private void exeCallback(SQLiteDatabase sQLiteDatabase) {
        if (this.Gn != null) {
            this.Gn.onDatabaseCreated(sQLiteDatabase);
        }
    }
}
