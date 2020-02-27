package com.baidu.live.adp.base.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.live.adp.base.db.BdDatabaseHelper;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes3.dex */
public abstract class PhoneDatabaseHelper extends SQLiteOpenHelper implements BdDatabaseHelper {
    private BdDatabaseHelper.OnDatabaseCreatedCallback callback;
    private final String databaseName;

    public abstract void clearAllTables(SQLiteDatabase sQLiteDatabase);

    public abstract void createAllTables(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.live.adp.base.db.BdDatabaseHelper
    public void setOnCreateCallback(BdDatabaseHelper.OnDatabaseCreatedCallback onDatabaseCreatedCallback) {
        this.callback = onDatabaseCreatedCallback;
    }

    public PhoneDatabaseHelper(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.databaseName = str;
    }

    @Override // com.baidu.live.adp.base.db.BdDatabaseHelper
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

    @Override // android.database.sqlite.SQLiteOpenHelper, com.baidu.live.adp.base.db.BdDatabaseHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createAllTables(sQLiteDatabase);
        exeCallback(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, com.baidu.live.adp.base.db.BdDatabaseHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        clearAllTables(sQLiteDatabase);
        createAllTables(sQLiteDatabase);
    }

    private void exeCallback(SQLiteDatabase sQLiteDatabase) {
        if (this.callback != null) {
            this.callback.onDatabaseCreated(sQLiteDatabase);
        }
    }
}
