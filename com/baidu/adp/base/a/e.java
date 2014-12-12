package com.baidu.adp.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public abstract class e implements a {
    private SQLiteDatabase cl = null;
    private b co;
    private int cq;
    private final String cr;

    public abstract void d(SQLiteDatabase sQLiteDatabase);

    public abstract void f(SQLiteDatabase sQLiteDatabase);

    @Override // com.baidu.adp.base.a.a
    public void a(b bVar) {
        this.co = bVar;
    }

    public e(String str, int i) {
        this.cq = 1;
        this.cq = i;
        this.cr = str;
    }

    @Override // com.baidu.adp.base.a.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.cr);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            this.cl = SQLiteDatabase.openOrCreateDatabase(this.cr, (SQLiteDatabase.CursorFactory) null);
            if (this.cl != null) {
                if (!exists) {
                    g(this.cl);
                    this.cl.setVersion(this.cq);
                } else {
                    int version = this.cl.getVersion();
                    if (version != this.cq) {
                        b(this.cl, version, this.cq);
                        this.cl.setVersion(this.cq);
                    }
                }
            }
        }
        return this.cl;
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
        if (this.co != null) {
            this.co.c(sQLiteDatabase);
        }
    }

    @Override // com.baidu.adp.base.a.a
    public boolean E(Context context) {
        File file = new File(this.cr);
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
