package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public abstract class e implements a {
    private SQLiteDatabase aA = null;
    private b aD;
    private final String aF;
    private int mVersion;

    public abstract void b(SQLiteDatabase sQLiteDatabase);

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(b bVar) {
        this.aD = bVar;
    }

    public e(String str, int i) {
        this.mVersion = 1;
        this.mVersion = i;
        this.aF = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.aF);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.aA = SQLiteDatabase.openOrCreateDatabase(this.aF, (SQLiteDatabase.CursorFactory) null);
            if (this.aA != null) {
                if (!exists) {
                    e(this.aA);
                    this.aA.setVersion(this.mVersion);
                } else {
                    int version = this.aA.getVersion();
                    if (version != this.mVersion) {
                        a(this.aA, version, this.mVersion);
                        this.aA.setVersion(this.mVersion);
                    }
                }
            }
        }
        return this.aA;
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        onCreate(sQLiteDatabase);
        c(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 > i) {
            onUpgrade(sQLiteDatabase, i, i2);
        } else {
            b(sQLiteDatabase, i, i2);
        }
        c(sQLiteDatabase);
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        if (this.aD != null) {
            this.aD.a(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean f(Context context) {
        File file = new File(this.aF);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
            return true;
        } catch (Throwable th) {
            BdLog.e(String.valueOf(str) + ":" + th);
            return false;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    public void b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        d(sQLiteDatabase);
        b(sQLiteDatabase);
    }
}
