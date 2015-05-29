package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public abstract class e implements a {
    private b nC;
    private int nE;
    private final String nF;
    private SQLiteDatabase nz = null;

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    public abstract void f(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(b bVar) {
        this.nC = bVar;
    }

    public e(String str, int i) {
        this.nE = 1;
        this.nE = i;
        this.nF = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.nF);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.nz = SQLiteDatabase.openOrCreateDatabase(this.nF, (SQLiteDatabase.CursorFactory) null);
            if (this.nz != null) {
                if (!exists) {
                    g(this.nz);
                    this.nz.setVersion(this.nE);
                } else {
                    int version = this.nz.getVersion();
                    if (version != this.nE) {
                        b(this.nz, version, this.nE);
                        this.nz.setVersion(this.nE);
                    }
                }
            }
        }
        return this.nz;
    }

    private void g(SQLiteDatabase sQLiteDatabase) {
        onCreate(sQLiteDatabase);
        e(sQLiteDatabase);
    }

    private void b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 > i) {
            onUpgrade(sQLiteDatabase, i, i2);
        } else {
            onDowngrade(sQLiteDatabase, i, i2);
        }
        e(sQLiteDatabase);
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (this.nC != null) {
            this.nC.c(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean E(Context context) {
        File file = new File(this.nF);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public boolean b(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
            return true;
        } catch (Throwable th) {
            BdLog.e(String.valueOf(str) + ":" + th);
            return false;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        d(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        f(sQLiteDatabase);
        d(sQLiteDatabase);
    }
}
