package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public abstract class e implements a {
    private int nB;
    private final String nC;
    private SQLiteDatabase nw = null;
    private b nz;

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    public abstract void f(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(b bVar) {
        this.nz = bVar;
    }

    public e(String str, int i) {
        this.nB = 1;
        this.nB = i;
        this.nC = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.nC);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.nw = SQLiteDatabase.openOrCreateDatabase(this.nC, (SQLiteDatabase.CursorFactory) null);
            if (this.nw != null) {
                if (!exists) {
                    g(this.nw);
                    this.nw.setVersion(this.nB);
                } else {
                    int version = this.nw.getVersion();
                    if (version != this.nB) {
                        b(this.nw, version, this.nB);
                        this.nw.setVersion(this.nB);
                    }
                }
            }
        }
        return this.nw;
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
        if (this.nz != null) {
            this.nz.c(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean E(Context context) {
        File file = new File(this.nC);
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
