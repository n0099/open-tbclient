package com.baidu.live.adp.base.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.live.adp.base.db.BdDatabaseHelper;
import com.baidu.live.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes11.dex */
public abstract class SDCardDatabaseHelper implements BdDatabaseHelper {
    private BdDatabaseHelper.OnDatabaseCreatedCallback callback;
    private SQLiteDatabase database = null;
    private final String dbFileFullPath;
    private int mVersion;

    public abstract void clearAllTables(SQLiteDatabase sQLiteDatabase);

    public abstract void createAllTables(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.live.adp.base.db.BdDatabaseHelper
    public void setOnCreateCallback(BdDatabaseHelper.OnDatabaseCreatedCallback onDatabaseCreatedCallback) {
        this.callback = onDatabaseCreatedCallback;
    }

    public SDCardDatabaseHelper(String str, int i) {
        this.mVersion = 1;
        this.mVersion = i;
        this.dbFileFullPath = str;
    }

    @Override // com.baidu.live.adp.base.db.BdDatabaseHelper
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.dbFileFullPath);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.database = SQLiteDatabase.openOrCreateDatabase(this.dbFileFullPath, (SQLiteDatabase.CursorFactory) null);
            if (this.database != null) {
                if (!exists) {
                    onCreateDatabase(this.database);
                    this.database.setVersion(this.mVersion);
                } else {
                    int version = this.database.getVersion();
                    if (version != this.mVersion) {
                        onUpdateDatabase(this.database, version, this.mVersion);
                        this.database.setVersion(this.mVersion);
                    }
                }
            }
        }
        return this.database;
    }

    private void onCreateDatabase(SQLiteDatabase sQLiteDatabase) {
        onCreate(sQLiteDatabase);
        exeCallback(sQLiteDatabase);
    }

    private void onUpdateDatabase(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 > i) {
            onUpgrade(sQLiteDatabase, i, i2);
        } else {
            onDowngrade(sQLiteDatabase, i, i2);
        }
        exeCallback(sQLiteDatabase);
    }

    private void exeCallback(SQLiteDatabase sQLiteDatabase) {
        if (this.callback != null) {
            this.callback.onDatabaseCreated(sQLiteDatabase);
        }
    }

    @Override // com.baidu.live.adp.base.db.BdDatabaseHelper
    public boolean dropDatabase(Context context) {
        File file = new File(this.dbFileFullPath);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public boolean executeDDLSqlIgnoreAnyErrors(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
            return true;
        } catch (Throwable th) {
            BdLog.e(str + ":" + th);
            return false;
        }
    }

    @Override // com.baidu.live.adp.base.db.BdDatabaseHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createAllTables(sQLiteDatabase);
    }

    @Override // com.baidu.live.adp.base.db.BdDatabaseHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        clearAllTables(sQLiteDatabase);
        createAllTables(sQLiteDatabase);
    }
}
